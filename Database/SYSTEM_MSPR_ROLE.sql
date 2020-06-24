create table MSPR_ROLE
(
    ID   NUMBER        not null,
    TYPE VARCHAR2(256) not null
)
/

comment on table MSPR_ROLE is 'Role table'
/

create unique index MSPR_ROLE_ID_UINDEX
    on MSPR_ROLE (ID)
/

alter table MSPR_ROLE
    add constraint MSPR_ROLE_PK
        primary key (ID)
/

