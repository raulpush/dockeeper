package com.muri.web.document;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.muri.web.client.impl.SearchClientServiceImpl;
import com.muri.web.model.Document;
import com.muri.web.model.DocumentVersions;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Date;

/**
 * Created by andrei.muresan on 10/2/2015.
 */
public class ReadPdf {

    public static void main(String[] args) {
        SearchClientServiceImpl client = new SearchClientServiceImpl();
        try {
            PdfReader reader = new PdfReader("c:\\tools\\files\\rezolutie.pdf");
            PdfReaderContentParser parser = new PdfReaderContentParser(reader);
            TextExtractionStrategy strategy;
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
                String it = strategy.getResultantText();
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
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            client.getClient().close();
        }
    }

}
