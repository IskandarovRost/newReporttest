package com.company.newreporttest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.BaseGenericIdEntity;
import com.haulmont.cuba.core.entity.HasUuid;
import java.util.UUID;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import java.util.Set;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Table(name = "NEWREPORTTEST_TEST_TWO")
@Entity(name = "newreporttest$TestTwo")
public class TestTwo extends BaseGenericIdEntity<KeyTwo> implements HasUuid {
    private static final long serialVersionUID = 3236288918714904773L;

    @Temporal(TemporalType.DATE)
    @Column(name = "UTILITY_DATE")
    protected Date utilityDate;

    @EmbeddedId
    protected KeyTwo id;

    @Column(name = "UUID")
    private UUID uuid;




    @Override
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }


    public void setUtilityDate(Date utilityDate) {
        this.utilityDate = utilityDate;
    }

    public Date getUtilityDate() {
        return utilityDate;
    }

    @Override
    public KeyTwo getId() {
        return id;
    }

    @Override
    public void setId(KeyTwo id) {
        this.id = id;
    }


}