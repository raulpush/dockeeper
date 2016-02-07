package com.muri.web.service;


import com.muri.web.model.*;

import java.util.List;

/**
 * Created by andrei.muresan on 10/5/2015.
 */
public interface DocumentService {
    /**
     * insert a new document in system
     * return file name
     */
    String uploadDocument(UploadedFile uploadedFile, User us);

    /**
     * get a documnet from system
     */
    Paragraph getDocument(String id, User us);


    /**
     * get a documnet from system
     */
    List<Document> getDocuments(User us);

    /**
     * ask a question
     */
    List<Paragraph> queryDocuments(Search text, User us);

    /**
     *
     * @param seq
     * @return
     */
    Document save(Document seq);

    /**
     *
     * @param username
     * @return
     */
    Document findByName(String username);


}
