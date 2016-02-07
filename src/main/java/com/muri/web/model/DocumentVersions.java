package com.muri.web.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by andrei.muresan on 10/2/2015.
 */
@Entity
@Table(name="documents_versions")
public class DocumentVersions {


    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    private String content;

    private Boolean encrypted;

    private Boolean searchable;

    private String path;

    private String version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="document_id")
    private Document document;

    @NotNull
    @Past
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date data;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Transient
    private List<String> categories = new ArrayList<String>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void addCategories(String categ)
    {
        if(categories==null)
        {
            categories = new ArrayList<String>();
        }
        categories.add(categ);
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Boolean getEncrypted() {
        return encrypted;
    }

    public void setEncrypted(Boolean encrypted) {
        this.encrypted = encrypted;
    }

    public Boolean getSearchable() {
        return searchable;
    }

    public void setSearchable(Boolean searchable) {
        this.searchable = searchable;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", encrypted=" + encrypted +
                ", searchable=" + searchable +
                ", path='" + path + '\'' +
                ", version='" + version + '\'' +
                ", categories=" + categories +
                '}';
    }
}
