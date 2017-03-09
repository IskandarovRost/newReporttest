package com.company.newreporttest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@Table(name = "NEWREPORTTEST_BOOK")
@Entity(name = "newreporttest$Book")
public class Book extends StandardEntity {
    private static final long serialVersionUID = 4683677485197641882L;

    @Column(name = "NAME")
    protected String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LITERATURE_TYPE_ID")
    protected LiteratureType literatureType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID")
    protected Author author;

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }


    public void setLiteratureType(LiteratureType literatureType) {
        this.literatureType = literatureType;
    }

    public LiteratureType getLiteratureType() {
        return literatureType;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}