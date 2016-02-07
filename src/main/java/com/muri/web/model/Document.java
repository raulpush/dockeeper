package com.muri.web.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.util.*;

/**
 * Created by andrei.muresan on 10/2/2015.
 */
@Entity
@Table(name="documents")
public class Document {


    @Id
    @GeneratedValue
    private Long id;

    private String origTitle;

    private String description;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DocumentVersions> versions;


    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }


    @Past
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date data;

    @Transient
    private List<String> categories = new ArrayList<String>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DocumentVersions> getVersions() {
        return versions;
    }

    public void setVersions(List<DocumentVersions> versions) {
        this.versions = versions;
    }

    public void addVersions(DocumentVersions docVer) {
        if (this.versions == null)
          this.versions = new ArrayList<>();
        this.versions.add(docVer);
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }


    public String getOrigTitle() {
        return origTitle;
    }

    public void setOrigTitle(String origTitle) {
        this.origTitle = origTitle;
    }


    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", origTitle='" + origTitle + '\'' +
                ", description='" + description + '\'' +
                ", categories=" + categories +
                '}';
    }
}
