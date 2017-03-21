package com.company.newreporttest.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import com.haulmont.cuba.core.entity.BaseGenericIdEntity;
import com.haulmont.cuba.core.entity.HasUuid;
import java.util.UUID;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|utilityField")
@Table(name = "NEWREPORTTEST_TEST_ONE")
@Entity(name = "newreporttest$TestOne")
public class TestOne extends BaseGenericIdEntity<KeyOne> implements HasUuid {
    private static final long serialVersionUID = 425505165439822627L;

    @Column(name = "UTILITY_FIELD")
    protected String utilityField;

    @EmbeddedId
    protected KeyOne id;

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


    public void setUtilityField(String utilityField) {
        this.utilityField = utilityField;
    }

    public String getUtilityField() {
        return utilityField;
    }

    @Override
    public KeyOne getId() {
        return id;
    }

    @Override
    public void setId(KeyOne id) {
        this.id = id;
    }


}