package com.company.newreporttest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.FileDescriptor;

@Table(name = "NEWREPORTTEST_REF_ENTITY")
@Entity(name = "newreporttest$RefEntity")
public class RefEntity extends StandardEntity {
    private static final long serialVersionUID = 8331913861432113458L;

    @Column(name = "STRING_FIELD")
    protected String stringField;

    @Column(name = "BOOL_FIELD")
    protected Boolean boolField;

    @Column(name = "INT_FIELD")
    protected Integer intField;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_FIELD")
    protected Date dtField;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID")
    protected Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_ID")
    protected Book book;

    @JoinTable(name = "NEWREPORTTEST_REF_ENTITY_LITERATURE_TYPE_LINK",
        joinColumns = @JoinColumn(name = "REF_ENTITY_ID"),
        inverseJoinColumns = @JoinColumn(name = "LITERATURE_TYPE_ID"))
    @ManyToMany
    protected Set<LiteratureType> types;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IMAGE_ID")
    protected FileDescriptor image;

    public void setImage(FileDescriptor image) {
        this.image = image;
    }

    public FileDescriptor getImage() {
        return image;
    }


    public void setStringField(String stringField) {
        this.stringField = stringField;
    }

    public String getStringField() {
        return stringField;
    }

    public void setBoolField(Boolean boolField) {
        this.boolField = boolField;
    }

    public Boolean getBoolField() {
        return boolField;
    }

    public void setIntField(Integer intField) {
        this.intField = intField;
    }

    public Integer getIntField() {
        return intField;
    }

    public void setDtField(Date dtField) {
        this.dtField = dtField;
    }

    public Date getDtField() {
        return dtField;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setTypes(Set<LiteratureType> types) {
        this.types = types;
    }

    public Set<LiteratureType> getTypes() {
        return types;
    }


}