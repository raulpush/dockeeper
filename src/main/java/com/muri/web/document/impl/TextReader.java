package com.muri.web.document.impl;


import com.muri.web.document.Uploader;
import com.muri.web.model.User;
import com.muri.web.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

//import org.apache.tika.exception.TikaException;
//import org.apache.tika.metadata.Metadata;
//import org.apache.tika.parser.AutoDetectParser;
//import org.apache.tika.parser.ParseContext;
//import org.apache.tika.parser.Parser;
//import org.apache.tika.sax.BodyContentHandler;

/**
 * Created by andrei.muresan on 10/5/2015.
 */
public class TextReader implements Uploader {
    public void upload(InputStream f, String name, String origName, String description, User us,SequenceService sequenceService) throws IOException {
//        ContentHandler contenthandler = new BodyContentHandler();
//        Metadata metadata = new Metadata();
//        Parser parser = new AutoDetectParser();
//        try {
//            parser.parse(f, contenthandler, metadata, new ParseContext());
//        } catch (SAXException e) {
//            e.printStackTrace();
//        } catch (TikaException e) {
//            e.printStackTrace();
//        }
//        String[] aux = contenthandler.toString().split("\n");
//        int i = 0;
//        for (String it : aux) {
//            if (it != null && !it.trim().isEmpty()) {
//                System.out.println(it);
//                UtilityDocument.saveDocumentInSearch(name, description, it, "document", "doc");
//            }
//        }
    }
}
