package com.muri.web.model;

import javax.persistence.OneToMany;

public class Paragraph {

	private String text;
	private String title;
	private String decorator;
	private Long id;
	private String date;
	private float score;

    public String getText() {
        return text;
    }

    public Paragraph setText(String text) {
        this.text = text;
        return this;
    }

    public String getTitle() {
        return title;
    }
    @OneToMany(mappedBy="author")
    public Paragraph setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Paragraph setDate(String date) {
        this.date = date;
        return this;
    }


    public float getScore() {
        return score;
    }

    public Paragraph setScore(float score) {
        this.score = score;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Paragraph setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDecorator() {
        return decorator;
    }

    public Paragraph setDecorator(String decorator) {
        this.decorator = decorator;
        return this;
    }
}
