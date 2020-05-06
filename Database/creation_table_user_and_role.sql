create table MSPR_ROLE
(
    ID   NUMBER        not null,
    TYPE VARCHAR2(256) not null
);

comment on table MSPR_ROLE is 'Role table';

create unique index MSPR_ROLE_ID_UINDEX
    on MSPR_ROLE (ID);

alter table MSPR_ROLE
    add constraint MSPR_ROLE_PK
        primary key (ID);

create table MSPR_USER
(
    ID         NUMBER not null,
    USERNAME   VARCHAR2(256),
    PASSWORD   VARCHAR2(2048),
    FK_ID_ROLE NUMBER
        constraint MSPR_USER_MSPR_ROLE_ID_FK
            references MSPR_ROLE
);

comment on table MSPR_USER is 'Users that can connect to the application';

create unique index MSPR_USER_ID_UINDEX
    on MSPR_USER (ID);

alter table MSPR_USER
    add constraint MSPR_USER_PK
        primary key (ID);