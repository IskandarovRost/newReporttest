create table NEWREPORTTEST_REF_ENTITY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    STRING_FIELD varchar(255),
    BOOL_FIELD boolean,
    INT_FIELD integer,
    DT_FIELD timestamp,
    AUTHOR_ID varchar(36),
    BOOK_ID varchar(36),
    --
    primary key (ID)
);
