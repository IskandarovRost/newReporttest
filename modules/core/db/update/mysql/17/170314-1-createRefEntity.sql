create table NEWREPORTTEST_REF_ENTITY (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    STRING_FIELD varchar(255),
    BOOL_FIELD boolean,
    INT_FIELD integer,
    DT_FIELD datetime(3),
    AUTHOR_ID varchar(32),
    BOOK_ID varchar(32),
    IMAGE_ID varchar(32),
    --
    primary key (ID)
);
