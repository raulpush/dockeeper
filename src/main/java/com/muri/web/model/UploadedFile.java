package com.muri.web.model;

/**
 * Created by andrei.muresan on 10/5/2015.
 */
import org.springframework.web.multipart.MultipartFile;

public class UploadedFile {

    private MultipartFile file;
    private String  searchable;
    private String  crypted;
    private String  description;
    private String  domains;


    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getSearchable() {
        return searchable;
    }

    public void setSearchable(String searchable) {
        this.searchable = searchable;
    }

    public String getCrypted() {
        return crypted;
    }

    public void setCrypted(String crypted) {
        this.crypted = crypted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDomains() {
        return domains;
    }

    public void setDomains(String domains) {
        this.domains = domains;
    }
}
