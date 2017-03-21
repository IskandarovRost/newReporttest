package com.company.newreporttest.entity;

import javax.persistence.Embeddable;
import com.haulmont.chile.core.annotations.MetaClass;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.EmbeddableEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import java.util.Objects;

@NamePattern("%s %s %s|oFieldOne,oFieldThree,oFieldTwo")
@MetaClass(name = "newreporttest$KeyOne")
@Embeddable
public class KeyOne extends EmbeddableEntity {
    private static final long serialVersionUID = 7408492929752506622L;

    @Column(name = "O_FIELD_ONE")
    protected String oFieldOne;

    @Column(name = "O_FIELD_TWO")
    protected Integer oFieldTwo;

    @Column(name = "O_FIELD_THREE")
    protected Boolean oFieldThree;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyOne entity = (KeyOne) o;
        return Objects.equals(this.oFieldTwo, entity.oFieldTwo) &&
                Objects.equals(this.oFieldOne, entity.oFieldOne) &&
                Objects.equals(this.oFieldThree, entity.oFieldThree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oFieldTwo, oFieldOne, oFieldThree);
    }


    public void setOFieldOne(String oFieldOne) {
        this.oFieldOne = oFieldOne;
    }

    public String getOFieldOne() {
        return oFieldOne;
    }

    public void setOFieldTwo(Integer oFieldTwo) {
        this.oFieldTwo = oFieldTwo;
    }

    public Integer getOFieldTwo() {
        return oFieldTwo;
    }

    public void setOFieldThree(Boolean oFieldThree) {
        this.oFieldThree = oFieldThree;
    }

    public Boolean getOFieldThree() {
        return oFieldThree;
    }


}