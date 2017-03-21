create table NEWREPORTTEST_REF_ENTITY_LITERATURE_TYPE_LINK (
    REF_ENTITY_ID varchar(36) not null,
    LITERATURE_TYPE_ID varchar(36) not null,
    primary key (REF_ENTITY_ID, LITERATURE_TYPE_ID)
);
