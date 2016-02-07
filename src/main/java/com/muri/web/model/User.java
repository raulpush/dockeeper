package com.muri.web.model;

/**
 * Created by andrei.a.muresan on 10/13/2015.
 */
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Cacheable
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Size(min=4, max=20)
    private String username;

    @NotEmpty
    private String firstname;

    @NotEmpty
    private String lastname;

    private String publicKey;

    @NotEmpty
    @Size(min=3, max=12)
    private String password;

    @NotEmpty
    @Email
    private String emailAddress;

    @NotEmpty
    private String company;

    private String profession;

    private Integer enabled;

    public Boolean getGenerate_publicKey() {
        return generate_publicKey;
    }

    public void setGenerate_publicKey(Boolean generate_publicKey) {
        this.generate_publicKey = generate_publicKey;
    }

    private Boolean  generate_publicKey;

    @NotNull
    @Past
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date dateOfBirth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", company='" + company + '\'' +
                ", enabled=" + enabled +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
