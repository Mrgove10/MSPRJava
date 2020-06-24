create table MSPR_USER
(
    ID         NUMBER not null,
    USERNAME   VARCHAR2(256),
    PASSWORD   VARCHAR2(2048),
    FK_ID_ROLE NUMBER
        constraint MSPR_USER_MSPR_ROLE_ID_FK
            references MSPR_ROLE
)
/

comment on table MSPR_USER is 'Users that can connect to the application'
/

create unique index MSPR_USER_ID_UINDEX
    on MSPR_USER (ID)
/

alter table MSPR_USER
    add constraint MSPR_USER_PK
        primary key (ID)
/

INSERT INTO SYSTEM.MSPR_USER (ID, USERNAME, PASSWORD, FK_ID_ROLE) VALUES (1, 'wolfla', '123345', null);
INSERT INTO SYSTEM.MSPR_USER (ID, USERNAME, PASSWORD, FK_ID_ROLE) VALUES (2, 'test', '54321', null);
INSERT INTO SYSTEM.MSPR_USER (ID, USERNAME, PASSWORD, FK_ID_ROLE) VALUES (4, 'azer', '$2a$12$YFuo1bhtquyYULsKOb7.Fucl7Ql/JTwAYmG4NM.ZNYDWs6k4yOaIO', null);
INSERT INTO SYSTEM.MSPR_USER (ID, USERNAME, PASSWORD, FK_ID_ROLE) VALUES (5, 'azer', '$2a$12$2K02nh1wakaHZzbglhbXOOABoE/H.7gplcLt/U8ITkk2I7b/N3sfK', null);
INSERT INTO SYSTEM.MSPR_USER (ID, USERNAME, PASSWORD, FK_ID_ROLE) VALUES (6, 'azer', '$2a$12$QfTJUwMWXoXULOaKXTo4quS98ZiOs8Dq4NVm0ULFzavpwISrHT4Ou', null);
INSERT INTO SYSTEM.MSPR_USER (ID, USERNAME, PASSWORD, FK_ID_ROLE) VALUES (7, 'adrien', '$2a$12$JfX2M4yGQVQkD7/9Ll3WNepNcaHxQDsEegdwQFurcHd2mA17AahYa', null);