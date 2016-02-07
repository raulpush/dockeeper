package com.muri.web.controller;

import com.muri.web.model.Filex;
import com.muri.web.model.User;
import com.muri.web.service.DocumentServiceImpl;
import com.muri.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;

@Controller
public class DownloadController {

    @Autowired
    private UserService userService;

    private static final int BUFFER_SIZE = 4096;
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "downloadForm", method = RequestMethod.POST)
    public void doDownload( @ModelAttribute("file") Filex file,
            HttpServletResponse response, Principal principal) throws IOException {
        System.out.println(file.getName());
        // construct the complete absolute path of the file
        User us = userService.findByUsername(principal.getName());
        File downloadFile = new File(DocumentServiceImpl.filePath+us.getCompany()+"/"+file.getName());
        FileInputStream inputStream = new FileInputStream(downloadFile);
        String mimeType = "application/octet-stream";

        // set content attributes for the response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());

        // set headers for the response
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        // get output stream of the response
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;

        // write bytes read from the input stream into the output stream
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        outStream.close();

    }
	
}
