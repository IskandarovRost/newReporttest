package com.company.newreporttest.entity;

import javax.persistence.Embeddable;
import com.haulmont.chile.core.annotations.MetaClass;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.EmbeddableEntity;
import java.util.Objects;

@MetaClass(name = "newreporttest$KeyTwo")
@Embeddable
public class KeyTwo extends EmbeddableEntity {
    private static final long serialVersionUID = -4246903769806808927L;

    @Column(name = "S_FIELD_ONE")
    protected String sFieldOne;

    @Column(name = "S_FIELD_TWO")
    protected Long sFieldTwo;

    @Column(name = "S_FIELD_THREE")
    protected Boolean sFieldThree;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyTwo entity = (KeyTwo) o;
        return Objects.equals(this.sFieldOne, entity.sFieldOne) &&
                Objects.equals(this.sFieldThree, entity.sFieldThree) &&
                Objects.equals(this.sFieldTwo, entity.sFieldTwo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sFieldOne, sFieldThree, sFieldTwo);
    }


    public void setSFieldOne(String sFieldOne) {
        this.sFieldOne = sFieldOne;
    }

    public String getSFieldOne() {
        return sFieldOne;
    }

    public void setSFieldTwo(Long sFieldTwo) {
        this.sFieldTwo = sFieldTwo;
    }

    public Long getSFieldTwo() {
        return sFieldTwo;
    }

    public void setSFieldThree(Boolean sFieldThree) {
        this.sFieldThree = sFieldThree;
    }

    public Boolean getSFieldThree() {
        return sFieldThree;
    }


}