package com.company.newreporttest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.Column;

@Table(name = "NEWREPORTTEST_DUMMY")
@Entity(name = "newreporttest$Dummy")
public class Dummy extends StandardEntity {
    private static final long serialVersionUID = -1859770740093734979L;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "SURNAME")
    protected String surname;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }


}