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

@NamePattern("%s|stamenField")
@Table(name = "NEWREPORTTEST_STAMEN")
@Entity(name = "newreporttest$Stamen")
public class Stamen extends StandardEntity {
    private static final long serialVersionUID = -1758096700629046645L;

    @Column(name = "STAMEN_FIELD")
    protected String stamenField;

    @JoinTable(name = "NEWREPORTTEST_STAMEN_PONDER_LINK",
        joinColumns = @JoinColumn(name = "STAMEN_ID"),
        inverseJoinColumns = @JoinColumn(name = "PONDER_ID"))
    @ManyToMany
    protected Set<Ponder> ponders;

    public void setPonders(Set<Ponder> ponders) {
        this.ponders = ponders;
    }

    public Set<Ponder> getPonders() {
        return ponders;
    }


    public void setStamenField(String stamenField) {
        this.stamenField = stamenField;
    }

    public String getStamenField() {
        return stamenField;
    }


}