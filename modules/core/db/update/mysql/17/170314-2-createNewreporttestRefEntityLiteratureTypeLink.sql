alter table NEWREPORTTEST_REF_ENTITY_LITERATURE_TYPE_LINK add constraint FK_NRELTL_REF_ENTITY foreign key (REF_ENTITY_ID) references NEWREPORTTEST_REF_ENTITY(ID);
alter table NEWREPORTTEST_REF_ENTITY_LITERATURE_TYPE_LINK add constraint FK_NRELTL_LITERATURE_TYPE foreign key (LITERATURE_TYPE_ID) references NEWREPORTTEST_LITERATURE_TYPE(ID);
