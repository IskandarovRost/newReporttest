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
);
