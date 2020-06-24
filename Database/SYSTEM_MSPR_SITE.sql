create table MSPR_SITE
(
    ID         NUMBER(5)    not null
        constraint PK_SITE
            primary key,
    ID_ADRESSE NUMBER(5)    not null
        constraint FK_ADRESSE_SITE
            references MSPR_ADRESSE,
    NOM        VARCHAR2(20) not null
)
/

INSERT INTO SYSTEM.MSPR_SITE (ID, ID_ADRESSE, NOM) VALUES (1, 6, 'Site Paris');
INSERT INTO SYSTEM.MSPR_SITE (ID, ID_ADRESSE, NOM) VALUES (2, 7, 'Site Lille');