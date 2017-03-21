package com.company.newreporttest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@NamePattern("%s|ponderField")
@Table(name = "NEWREPORTTEST_PONDER")
@Entity(name = "newreporttest$Ponder")
public class Ponder extends StandardEntity {
    private static final long serialVersionUID = -4490504782875714649L;

    @Column(name = "PONDER_FIELD")
    protected String ponderField;

    @JoinTable(name = "NEWREPORTTEST_STAMEN_PONDER_LINK",
        joinColumns = @JoinColumn(name = "PONDER_ID"),
        inverseJoinColumns = @JoinColumn(name = "STAMEN_ID"))
    @ManyToMany
    protected Set<Stamen> stamens;

    public void setStamens(Set<Stamen> stamens) {
        this.stamens = stamens;
    }

    public Set<Stamen> getStamens() {
        return stamens;
    }


    public void setPonderField(String ponderField) {
        this.ponderField = ponderField;
    }

    public String getPonderField() {
        return ponderField;
    }


}