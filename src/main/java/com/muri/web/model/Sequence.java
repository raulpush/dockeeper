package com.muri.web.model;

import javax.persistence.*;

/**
 * Created by andrei.a.muresan on 10/12/2015.
 */
@Entity
@Table(name="sequences")
public class Sequence {
    private Integer id = null;
    private String elasSearchIndex;
    private Integer next;

    public Sequence() {
    }

    public Sequence(String index, Integer next) {
        this.elasSearchIndex = index;
        this.next = next;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getElasSearchIndex() {
        return elasSearchIndex;
    }

    public void setElasSearchIndex(String elasSearchIndex) {
        this.elasSearchIndex = elasSearchIndex;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Sequence{" +
                "id=" + id +
                ", next=" + next +
                ", elasSearchIndex='" + elasSearchIndex + '\'' +
                '}';
    }
}
