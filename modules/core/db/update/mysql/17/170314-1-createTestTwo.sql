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
);
