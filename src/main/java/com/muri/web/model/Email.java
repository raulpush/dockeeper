package com.muri.web.model;

import javax.persistence.OneToMany;

public class Email {

	private String text;
	private String title;
	private String file;
	private String to;
	private String from;

    public String getText() {
        return text;
    }

    public Email setText(String text) {
        this.text = text;
        return this;
    }

    public String getTitle() {
        return title;
    }
    @OneToMany(mappedBy="author")
    public Email setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
