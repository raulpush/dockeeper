package com.muri.web.document.impl;

import com.muri.web.document.Uploader;
import com.muri.web.document.UtilityDocument;
import com.muri.web.model.Sequence;
import com.muri.web.model.User;
import com.muri.web.service.SequenceService;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by andrei.muresan on 10/5/2015.
 */
public class DocReader implements Uploader {

    public void upload(InputStream f, String name, String origName, String description, User us,SequenceService sequenceService) throws IOException {
        Sequence seq = sequenceService.findByIndex(us.getCompany());
        HWPFDocument dc = new HWPFDocument(f);
        WordExtractor we = new WordExtractor(dc);
        String[] aux = we.getParagraphText();
        int i = seq.getNext();
        seq.setNext(seq.getNext() + aux.length);
        sequenceService.save(seq);
        for (String it : aux) {
            if (it != null && !it.trim().isEmpty()) {
                System.out.println(it);
                UtilityDocument.saveDocumentInSearch(name, description, it, us.getCompany(), "doc", String.valueOf(++i));
            }
        }

    }
}
