-- begin NEWREPORTTEST_BOOK
create table NEWREPORTTEST_BOOK (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    LITERATURE_TYPE_ID varchar(32),
    AUTHOR_ID varchar(32),
    --
    primary key (ID)
)^
-- end NEWREPORTTEST_BOOK
-- begin NEWREPORTTEST_LITERATURE_TYPE
create table NEWREPORTTEST_LITERATURE_TYPE (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end NEWREPORTTEST_LITERATURE_TYPE
-- begin NEWREPORTTEST_AUTHOR
create table NEWREPORTTEST_AUTHOR (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
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
)^
-- end NEWREPORTTEST_REF_ENTITY
-- begin NEWREPORTTEST_DUMMY
create table NEWREPORTTEST_DUMMY (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
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
    UUID varchar(32),
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
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    SOME_FIELD varchar(255),
    FILE_ID varchar(32),
    --
    primary key (ID)
)^
-- end NEWREPORTTEST_NEW_ENTITY
-- begin NEWREPORTTEST_TEST_ONE
create table NEWREPORTTEST_TEST_ONE (
    UUID varchar(32),
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
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    PONDER_FIELD varchar(255),
    --
    primary key (ID)
)^
-- end NEWREPORTTEST_PONDER
-- begin NEWREPORTTEST_STAMEN
create table NEWREPORTTEST_STAMEN (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    STAMEN_FIELD varchar(255),
    --
    primary key (ID)
)^
-- end NEWREPORTTEST_STAMEN
-- begin NEWREPORTTEST_STAMEN_PONDER_LINK
create table NEWREPORTTEST_STAMEN_PONDER_LINK (
    STAMEN_ID varchar(32),
    PONDER_ID varchar(32),
    primary key (STAMEN_ID, PONDER_ID)
)^
-- end NEWREPORTTEST_STAMEN_PONDER_LINK
-- begin NEWREPORTTEST_REF_ENTITY_LITERATURE_TYPE_LINK
create table NEWREPORTTEST_REF_ENTITY_LITERATURE_TYPE_LINK (
    REF_ENTITY_ID varchar(32),
    LITERATURE_TYPE_ID varchar(32),
    primary key (REF_ENTITY_ID, LITERATURE_TYPE_ID)
)^
-- end NEWREPORTTEST_REF_ENTITY_LITERATURE_TYPE_LINK
