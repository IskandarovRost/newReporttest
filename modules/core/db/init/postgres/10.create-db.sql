-- begin NEWREPORTTEST_BOOK
create table NEWREPORTTEST_BOOK (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    LITERATURE_TYPE_ID uuid,
    AUTHOR_ID uuid,
    --
    primary key (ID)
)^
-- end NEWREPORTTEST_BOOK
-- begin NEWREPORTTEST_LITERATURE_TYPE
create table NEWREPORTTEST_LITERATURE_TYPE (
    ID uuid,
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
    ID uuid,
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
-- begin NEWREPORTTEST_REF_ENTITY
create table NEWREPORTTEST_REF_ENTITY (
    ID uuid,
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
    AUTHOR_ID uuid,
    BOOK_ID uuid,
    IMAGE_ID uuid,
    --
    primary key (ID)
)^
-- end NEWREPORTTEST_REF_ENTITY
-- begin NEWREPORTTEST_DUMMY
create table NEWREPORTTEST_DUMMY (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    SURNAME varchar(255),
    --
    primary key (ID)
)^
-- end NEWREPORTTEST_DUMMY
-- begin NEWREPORTTEST_TEST_TWO
create table NEWREPORTTEST_TEST_TWO (
    UUID uuid,
    --
    S_FIELD_ONE varchar(255),
    S_FIELD_TWO bigint,
    S_FIELD_THREE boolean,
    --
    UTILITY_DATE date,
    --
    primary key (S_FIELD_ONE, S_FIELD_TWO, S_FIELD_THREE)
)^
-- end NEWREPORTTEST_TEST_TWO
-- begin NEWREPORTTEST_NEW_ENTITY
create table NEWREPORTTEST_NEW_ENTITY (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SOME_FIELD varchar(255),
    FILE_ID uuid,
    --
    primary key (ID)
)^
-- end NEWREPORTTEST_NEW_ENTITY
-- begin NEWREPORTTEST_TEST_ONE
create table NEWREPORTTEST_TEST_ONE (
    UUID uuid,
    --
    O_FIELD_ONE varchar(255),
    O_FIELD_TWO integer,
    O_FIELD_THREE boolean,
    --
    UTILITY_FIELD varchar(255),
    --
    primary key (O_FIELD_ONE, O_FIELD_TWO, O_FIELD_THREE)
)^
-- end NEWREPORTTEST_TEST_ONE
-- begin NEWREPORTTEST_PONDER
create table NEWREPORTTEST_PONDER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PONDER_FIELD varchar(255),
    --
    primary key (ID)
)^
-- end NEWREPORTTEST_PONDER
-- begin NEWREPORTTEST_STAMEN
create table NEWREPORTTEST_STAMEN (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    STAMEN_FIELD varchar(255),
    --
    primary key (ID)
)^
-- end NEWREPORTTEST_STAMEN
-- begin NEWREPORTTEST_STAMEN_PONDER_LINK
create table NEWREPORTTEST_STAMEN_PONDER_LINK (
    STAMEN_ID uuid,
    PONDER_ID uuid,
    primary key (STAMEN_ID, PONDER_ID)
)^
-- end NEWREPORTTEST_STAMEN_PONDER_LINK
-- begin NEWREPORTTEST_REF_ENTITY_LITERATURE_TYPE_LINK
create table NEWREPORTTEST_REF_ENTITY_LITERATURE_TYPE_LINK (
    REF_ENTITY_ID uuid,
    LITERATURE_TYPE_ID uuid,
    primary key (REF_ENTITY_ID, LITERATURE_TYPE_ID)
)^
-- end NEWREPORTTEST_REF_ENTITY_LITERATURE_TYPE_LINK
