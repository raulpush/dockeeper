package com.muri.web.document.impl;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.muri.web.document.Uploader;
import com.muri.web.document.UtilityDocument;
import com.muri.web.model.Sequence;
import com.muri.web.model.User;
import com.muri.web.service.SequenceService;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by andrei.muresan on 10/5/2015.
 */
public class PDFReader implements Uploader {
    public void upload(InputStream file, String name, String origName, String description, User us,SequenceService sequenceService ) {
        try {
            Sequence seq = sequenceService.findByIndex(us.getCompany());
            PdfReader reader = new PdfReader(file);
            PdfReaderContentParser parser = new PdfReaderContentParser(reader);
            TextExtractionStrategy strategy;
            seq.setNext(seq.getNext() + reader.getNumberOfPages());
            sequenceService.save(seq);
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
                String it = strategy.getResultantText();
                if (it != null && !it.trim().isEmpty()) {
                    System.out.println(it);
                    UtilityDocument.saveDocumentInSearch(name, description, it, us.getCompany(), "doc",String.valueOf(++i));
                }
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
