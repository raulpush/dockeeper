package com.muri.web.service;


import com.muri.web.client.impl.SearchClientServiceImpl;
import com.muri.web.document.FactoryFileReader;
import com.muri.web.document.Uploader;
import com.muri.web.model.*;
import com.muri.web.repository.DocumentRepository;
import com.muri.web.repository.UserRepository;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by andrei.muresan on 10/5/2015.
 */
@Service("documentService")
public class DocumentServiceImpl implements DocumentService {

    public final static String filePath = "c:/tools/files/";

    @Autowired
    private SequenceService sequenceService;

    @Qualifier("documentRepository")
    @Autowired
    private DocumentRepository documentRepository;

    @Transactional
    public Document save(Document seq) {
        return documentRepository.save(seq);
    }

    public Document findByName(String index) {
        Document doc = documentRepository.findByName(index);

        if(doc != null) {
            return doc;
        }
        return new Document();
    }

    public String uploadDocument(UploadedFile uploadedFile, User us) {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        MultipartFile file = uploadedFile.getFile();
        DocumentVersions docVer = new DocumentVersions();
        String fileName="";
        String origName;

        try {

            inputStream = file.getInputStream();
            fileName = file.getOriginalFilename();
            origName = fileName;
            int index = fileName.lastIndexOf(".");

            if (index > 0) {
                String name = fileName.substring(0, index);
                String extension = fileName.substring(index + 1);

                File newFile = getNewFile(docVer,name, extension, us.getCompany());
                fileName = newFile.getName();
                outputStream = new FileOutputStream(newFile);
                int read;
                byte[] bytes = new byte[1024];

                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
                outputStream.flush();
                outputStream.close();

                BasicFileAttributes attr =
                        Files.readAttributes(Paths.get(newFile.getPath()), BasicFileAttributes.class);
                System.out.println("creationTime: " + attr.creationTime());
                System.out.println("lastAccessTime: " + attr.lastAccessTime());
                System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

                FileInputStream fis = new FileInputStream(newFile);
                Uploader uploader = FactoryFileReader.getInstance(extension);
                uploader.upload(fis, fileName, origName, "", us, sequenceService);
                Document doc = findByName(origName);
                docVer.setEncrypted("on".equals(uploadedFile.getCrypted()));
                docVer.setSearchable("on".equals(uploadedFile.getSearchable()));
                doc.setDescription(uploadedFile.getDescription());
                doc.setOrigTitle(origName);
                docVer.setTitle(fileName);
                if (docVer.getData() == null)
                {
                    docVer.setData(new Date());
                }
                if (doc.getData() == null)
                {
                    doc.setData(new Date());
                }
                docVer.setPath(newFile.getPath());
                docVer.setDocument(doc);
                doc.addVersions(docVer);
                doc.setCompany(us.getCompany());
                save(doc);
            } else {
                System.out.println("Invalid file name");
                fileName = "error:"+fileName;
            }
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            fileName = "error:"+fileName;
        }
        return fileName;
    }

    private File getNewFile(DocumentVersions doc, String fileName, String extension, String company) throws IOException {
        File f = getFile(fileName, extension, company);
        int version = 1;
        while (f == null) {
            String finalName = fileName + "-" + (version++);
            f = getFile(finalName, extension, company);
        }
        doc.setVersion(String.valueOf(version));
        return f;
    }

    private File getFile(String fileName, String extension, String company) throws IOException {
        String folder = filePath + company + "/";
        File directory = new File(folder);
        if (!directory.exists()) {
            directory.mkdir();
        }
        File newFile = new File(folder + fileName + "." + extension);
        if (!newFile.exists()) {
            newFile.createNewFile();
        } else {
            return null;
        }
        return newFile;
    }

    public Paragraph getDocument(String id, User us) {
        Paragraph par = new Paragraph();
        try {
            long iid = Long.valueOf(id);
            SearchClientServiceImpl transport = new SearchClientServiceImpl();
            GetResponse response = transport.getClient().prepareGet(us.getCompany(), "doc", id)
                    .execute()
                    .actionGet();
                Map<String, Object> obj = response.getSource();
                if (obj != null && obj.get("content") != null) {
                    String respStr = (String) obj.get("content");
                    par.setText(respStr)
                            .setTitle((String) obj.get("title")).setId(iid - 1);
                }

        } catch (Throwable e) {
            e.printStackTrace();
        }
        return par;
    }

    public List<Paragraph> queryDocuments(Search text, User us) {
        String[] words = text.getContent().split(" ");
        List<Paragraph> aux = new ArrayList<Paragraph>();
        List<String> responseIds = new ArrayList<String>();
        SearchClientServiceImpl transport = new SearchClientServiceImpl();
        try {
            SearchResponse response = transport.getClient().prepareSearch(us.getCompany())
                    .setTypes("doc")
                    .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                    .setQuery(QueryBuilders.matchQuery("content", text.getContent()))
                    .setFrom(0).setSize(10).setExplain(false)
                    .execute()
                    .actionGet();
            for (SearchHit sh : response.getHits()) {
                Map<String, Object> obj = sh.getSource();
                if (obj != null && obj.get("content") != null) {
                    if (sh.getId() != null && sh.getId().length() > 0 && !responseIds.contains(sh.getId())) {
                        responseIds.add(sh.getId());
                        applyDecorator(words, aux, sh, obj, "");
                    }
                }

            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        try {
            SearchResponse response = transport.getClient().prepareSearch(us.getCompany())
                    .setTypes("doc")
                    .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                    .setQuery(QueryBuilders.fuzzyQuery("content", text.getContent()))
                    .setFrom(0).setSize(10).setExplain(false)
                    .execute()
                    .actionGet();
            for (SearchHit sh : response.getHits()) {
                Map<String, Object> obj = sh.getSource();
                if (obj != null && obj.get("content") != null) {
                    if (sh.getId() != null && sh.getId().length() > 0 && !responseIds.contains(sh.getId())) {
                        responseIds.add(sh.getId());
                        applyDecorator(words, aux, sh, obj,"*");
                    }

                }

            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return aux;
    }

    private void applyDecorator(String[] words, List<Paragraph> aux, SearchHit sh, Map<String, Object> obj, String post) {
        String respStr = (String) obj.get("content");
//        for (String it : words) {
//            if (it != null && it.length() > 0) {
//                respStr = respStr.replaceAll(it, "<b>" + it + "</b>");
//            }
//        }
        aux.add(new Paragraph().setScore(sh.getScore()).setText(respStr)
                .setTitle(obj.get("title").toString()).setId(Long.valueOf(sh.getId())).setDecorator(post));
    }

    public List<Document> getDocuments(User us){
        List<Document> doc = documentRepository.getCompanyDocuments(us.getCompany());

        if(doc != null) {
            return doc;
        }
        return null;
    }
}
