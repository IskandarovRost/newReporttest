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

@NamePattern("%s|name")
@Table(name = "NEWREPORTTEST_LITERATURE_TYPE")
@Entity(name = "newreporttest$LiteratureType")
public class LiteratureType extends StandardEntity {
    private static final long serialVersionUID = 6986795925540455924L;

    @Column(name = "NAME")
    protected String name;

    @JoinTable(name = "NEWREPORTTEST_REF_ENTITY_LITERATURE_TYPE_LINK",
        joinColumns = @JoinColumn(name = "LITERATURE_TYPE_ID"),
        inverseJoinColumns = @JoinColumn(name = "REF_ENTITY_ID"))
    @ManyToMany
    protected Set<RefEntity> refEntities;

    public void setRefEntities(Set<RefEntity> refEntities) {
        this.refEntities = refEntities;
    }

    public Set<RefEntity> getRefEntities() {
        return refEntities;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}