package com.muri.web.controller;

/**
 * Created by andrei.muresan on 10/5/2015.
 */

import com.muri.web.model.Sequence;
import com.muri.web.model.UploadedFile;
import com.muri.web.model.User;
import com.muri.web.service.DocumentService;
import com.muri.web.service.SequenceService;
import com.muri.web.service.UserService;
import com.muri.web.validator.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;


@Controller
public class UploadController {

    @Autowired
    FileValidator fileValidator;

    @Autowired
    private SequenceService sequenceService;
    @Autowired
    private UserService userService;


    @Autowired
    DocumentService documentService;
    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/fileUploadForm")
    public ModelAndView getUploadForm(
            @ModelAttribute("uploadedFile") UploadedFile uploadedFile,
            BindingResult result, Principal principal
    ) {
        final String loggedInUserName = principal.getName();
        User us = userService.findByUsername(loggedInUserName);
        Sequence seq = sequenceService.findByIndex(us.getCompany());
        if (seq == null) {
            seq = new Sequence();
            seq.setElasSearchIndex(us.getCompany());
            seq.setNext(1);
            sequenceService.save(seq);
        }
        System.out.println(seq);

        System.out.println("loggedInUserName=" + loggedInUserName);
        return new ModelAndView("uploadForm");
    }


    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/fileUpload")
    public ModelAndView fileUploaded(
            @ModelAttribute("uploadedFile") UploadedFile uploadedFile,
            BindingResult result, Principal principal,
            @RequestParam(value="searchable", required = false) String searchable,
            @RequestParam(value="crypted", required = false) String crypted,
            @RequestParam(value="description", required = false) String description,
            @RequestParam(value="domains", required = false) String domains) {
        System.out.println(searchable+"---"+crypted+"---"+ description+"---"+ domains);
        uploadedFile.setSearchable(searchable);
        uploadedFile.setCrypted(crypted);
        uploadedFile.setDescription(description);
        uploadedFile.setDomains(domains);
        MultipartFile file = uploadedFile.getFile();
        fileValidator.validate(uploadedFile, result);
        if (result.hasErrors()) {
            return new ModelAndView("uploadForm");
        }
        System.out.println(principal);
        User us = userService.findByUsername(principal.getName());
        System.out.println(us);
        String name = documentService.uploadDocument(uploadedFile, us);
        return new ModelAndView("showFile", "message", name);
    }

}
