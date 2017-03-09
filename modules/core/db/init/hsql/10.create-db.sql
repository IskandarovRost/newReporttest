-- begin NEWREPORTTEST_BOOK
create table NEWREPORTTEST_BOOK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    LITERATURE_TYPE_ID varchar(36),
    AUTHOR_ID varchar(36),
    --
    primary key (ID)
)^
-- end NEWREPORTTEST_BOOK
-- begin NEWREPORTTEST_LITERATURE_TYPE
create table NEWREPORTTEST_LITERATURE_TYPE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end NEWREPORTTEST_LITERATURE_TYPE
-- begin NEWREPORTTEST_AUTHOR
create table NEWREPORTTEST_AUTHOR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(255),
    LAST_NAME varchar(255),
    --
    primary key (ID)
)^
-- end NEWREPORTTEST_AUTHOR
