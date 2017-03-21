package com.company.newreporttest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.FileDescriptor;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumns;

@Table(name = "NEWREPORTTEST_NEW_ENTITY")
@Entity(name = "newreporttest$NewEntity")
public class NewEntity extends StandardEntity {
    private static final long serialVersionUID = -8448374892822169050L;

    @Column(name = "SOME_FIELD")
    protected String someField;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE_ID")
    protected FileDescriptor file;


    public void setFile(FileDescriptor file) {
        this.file = file;
    }

    public FileDescriptor getFile() {
        return file;
    }



    public void setSomeField(String someField) {
        this.someField = someField;
    }

    public String getSomeField() {
        return someField;
    }


}