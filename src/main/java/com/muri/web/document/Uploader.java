package com.muri.web.document;

import com.muri.web.model.User;
import com.muri.web.service.SequenceService;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by andrei.muresan on 10/5/2015.
 */
public interface Uploader {

    public void upload(InputStream file, String name, String origName, String description, User us,SequenceService sequenceService) throws IOException;

}
