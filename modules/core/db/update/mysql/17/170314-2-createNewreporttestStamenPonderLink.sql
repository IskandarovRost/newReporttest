alter table NEWREPORTTEST_STAMEN_PONDER_LINK add constraint FK_NSPL_STAMEN foreign key (STAMEN_ID) references NEWREPORTTEST_STAMEN(ID);
alter table NEWREPORTTEST_STAMEN_PONDER_LINK add constraint FK_NSPL_PONDER foreign key (PONDER_ID) references NEWREPORTTEST_PONDER(ID);