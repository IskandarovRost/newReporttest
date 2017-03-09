package com.company.newreporttest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@Table(name = "NEWREPORTTEST_LITERATURE_TYPE")
@Entity(name = "newreporttest$LiteratureType")
public class LiteratureType extends StandardEntity {
    private static final long serialVersionUID = 6986795925540455924L;

    @Column(name = "NAME")
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}