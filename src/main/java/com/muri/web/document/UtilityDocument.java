package com.muri.web.document;

import com.muri.web.client.impl.SearchClientServiceImpl;
import com.muri.web.model.Document;
import com.muri.web.model.DocumentVersions;
import org.codehaus.jackson.map.ObjectMapper;
import org.elasticsearch.action.ActionResponse;

import java.io.IOException;
import java.util.Date;

/**
 * Created by andrei.muresan on 10/5/2015.
 */
public class UtilityDocument {
    private static SearchClientServiceImpl transport = new SearchClientServiceImpl();

    public static void saveDocumentInSearch(String name, String description, String content,
            String searchIndex, String searchType,String db_id)
            throws IOException {
        DocumentVersions doc = new DocumentVersions();
        doc.setContent(content);
        doc.setTitle(name);
        doc.setDescription(description);
        doc.setData(new Date());
        ObjectMapper mapper = new ObjectMapper();
        String val = mapper.writeValueAsString(doc);
        ActionResponse res = transport.getClient().prepareIndex(searchIndex, searchType,db_id)
                .setSource(val)
                .get();
        System.out.println(res.toString());
    }

    public static void saveDocumentInSearch(Document doc,
            String searchIndex, String searchType)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String val = mapper.writeValueAsString(doc);
        ActionResponse res = transport.getClient().prepareIndex(searchIndex, searchType)
                .setSource(val)
                .get();
        System.out.println(res.toString());
    }
}
