package com.muri.web.document;

import com.muri.web.client.impl.SearchClientServiceImpl;
import com.muri.web.model.Document;
import com.muri.web.model.DocumentVersions;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Date;

/**
 * Created by andrei.muresan on 10/2/2015.
 */
public class ReadDocument {

    public static void main(String[] args) {
        SearchClientServiceImpl client = new SearchClientServiceImpl();
        try {
            FileInputStream fis = new FileInputStream("c:\\tool\\files\\Maria art Acta Sibiu 17.09.2014.doc");

            HWPFDocument dc1 = new HWPFDocument(fis);
            XWPFDocument dc = new XWPFDocument(fis);
            XWPFWordExtractor extract = new XWPFWordExtractor(dc);
            String[] aux = extract.getText().split("\\n");
            int i = 0;
            for (String it : aux) {
                if (it != null && !it.trim().isEmpty()) {
                    System.out.println(it);
                    DocumentVersions doc = new DocumentVersions();
                    doc.setContent(it);
                    doc.setTitle("Han7");
                    doc.setDescription("Descriere");
                    doc.setData(new Date());
                    ObjectMapper mapper = new ObjectMapper();
                    String val = mapper.writeValueAsString(doc);
                    client.getClient().prepareIndex("twitter", "tweet", String.valueOf(i++))
                            .setSource(val)
                            .get();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            client.getClient().close();
        }
    }

    public static Workbook create(InputStream inp) throws IOException, InvalidFormatException {
        // If clearly doesn't do mark/reset, wrap up
        if (!inp.markSupported()) {
            inp = new PushbackInputStream(inp, 8);
        }

        if (POIFSFileSystem.hasPOIFSHeader(inp)) {
            return new HSSFWorkbook(inp);
        }
        if (POIXMLDocument.hasOOXMLHeader(inp)) {
            return new XSSFWorkbook(OPCPackage.open(inp));
        }
        throw new IllegalArgumentException("Your InputStream was neither an OLE2 stream, nor an OOXML stream");
    }

}
