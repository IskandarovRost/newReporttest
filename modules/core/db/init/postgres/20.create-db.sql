-- begin NEWREPORTTEST_BOOK
alter table NEWREPORTTEST_BOOK add constraint FK_NEWREPORTTEST_BOOK_LITERATURE_TYPE foreign key (LITERATURE_TYPE_ID) references NEWREPORTTEST_LITERATURE_TYPE(ID)^
alter table NEWREPORTTEST_BOOK add constraint FK_NEWREPORTTEST_BOOK_AUTHOR foreign key (AUTHOR_ID) references NEWREPORTTEST_AUTHOR(ID)^
create index IDX_NEWREPORTTEST_BOOK_LITERATURE_TYPE on NEWREPORTTEST_BOOK (LITERATURE_TYPE_ID)^
create index IDX_NEWREPORTTEST_BOOK_AUTHOR on NEWREPORTTEST_BOOK (AUTHOR_ID)^
-- end NEWREPORTTEST_BOOK
-- begin NEWREPORTTEST_REF_ENTITY
alter table NEWREPORTTEST_REF_ENTITY add constraint FK_NEWREPORTTEST_REF_ENTITY_AUTHOR foreign key (AUTHOR_ID) references NEWREPORTTEST_AUTHOR(ID)^
alter table NEWREPORTTEST_REF_ENTITY add constraint FK_NEWREPORTTEST_REF_ENTITY_BOOK foreign key (BOOK_ID) references NEWREPORTTEST_BOOK(ID)^
alter table NEWREPORTTEST_REF_ENTITY add constraint FK_NEWREPORTTEST_REF_ENTITY_IMAGE foreign key (IMAGE_ID) references SYS_FILE(ID)^
create index IDX_NEWREPORTTEST_REF_ENTITY_AUTHOR on NEWREPORTTEST_REF_ENTITY (AUTHOR_ID)^
create index IDX_NEWREPORTTEST_REF_ENTITY_IMAGE on NEWREPORTTEST_REF_ENTITY (IMAGE_ID)^
create index IDX_NEWREPORTTEST_REF_ENTITY_BOOK on NEWREPORTTEST_REF_ENTITY (BOOK_ID)^
-- end NEWREPORTTEST_REF_ENTITY
-- begin NEWREPORTTEST_NEW_ENTITY
alter table NEWREPORTTEST_NEW_ENTITY add constraint FK_NEWREPORTTEST_NEW_ENTITY_FILE foreign key (FILE_ID) references SYS_FILE(ID)^
create index IDX_NEWREPORTTEST_NEW_ENTITY_FILE on NEWREPORTTEST_NEW_ENTITY (FILE_ID)^
-- end NEWREPORTTEST_NEW_ENTITY
-- begin NEWREPORTTEST_STAMEN_PONDER_LINK
alter table NEWREPORTTEST_STAMEN_PONDER_LINK add constraint FK_NSPL_STAMEN foreign key (STAMEN_ID) references NEWREPORTTEST_STAMEN(ID)^
alter table NEWREPORTTEST_STAMEN_PONDER_LINK add constraint FK_NSPL_PONDER foreign key (PONDER_ID) references NEWREPORTTEST_PONDER(ID)^
-- end NEWREPORTTEST_STAMEN_PONDER_LINK
-- begin NEWREPORTTEST_REF_ENTITY_LITERATURE_TYPE_LINK
alter table NEWREPORTTEST_REF_ENTITY_LITERATURE_TYPE_LINK add constraint FK_NRELTL_REF_ENTITY foreign key (REF_ENTITY_ID) references NEWREPORTTEST_REF_ENTITY(ID)^
alter table NEWREPORTTEST_REF_ENTITY_LITERATURE_TYPE_LINK add constraint FK_NRELTL_LITERATURE_TYPE foreign key (LITERATURE_TYPE_ID) references NEWREPORTTEST_LITERATURE_TYPE(ID)^
-- end NEWREPORTTEST_REF_ENTITY_LITERATURE_TYPE_LINK