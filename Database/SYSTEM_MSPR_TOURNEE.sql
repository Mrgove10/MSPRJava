create table MSPR_TOURNEE
(
    ID           NUMBER(5)              not null
        constraint PK_TOURNEE
            primary key,
    ID_CAMION    NUMBER(5)              not null
        constraint FK_CAMION_TOURNEE
            references MSPR_CAMION,
    ID_EMPLOYE   NUMBER(5)              not null
        constraint FK_EMPLOYE_TOURNEE
            references MSPR_EMPLOYE,
    DATE_TOURNEE DATE default (sysdate) not null
)
/

INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (1, 1, 1, TO_DATE('2018-09-03 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (2, 2, 2, TO_DATE('2020-06-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (3, 3, 3, TO_DATE('2018-09-03 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (4, 4, 4, TO_DATE('2018-09-03 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (5, 5, 5, TO_DATE('2018-09-03 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (6, 6, 6, TO_DATE('2018-09-03 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (7, 7, 7, TO_DATE('2018-09-03 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (8, 2, 1, TO_DATE('2018-09-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (9, 3, 2, TO_DATE('2018-09-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (10, 4, 3, TO_DATE('2018-09-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (11, 5, 4, TO_DATE('2018-09-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (12, 7, 7, TO_DATE('2018-09-21 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (13, 2, 7, TO_DATE('2020-06-24 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (14, 3, 5, TO_DATE('2018-09-27 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (15, 4, 3, TO_DATE('2018-09-27 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (16, 5, 2, TO_DATE('2018-09-30 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (17, 6, 1, TO_DATE('2018-09-30 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (18, 7, 4, TO_DATE('2018-09-30 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (19, 2, 4, TO_DATE('2020-06-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (20, 3, 6, TO_DATE('2018-10-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (21, 4, 7, TO_DATE('2018-10-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (22, 5, 5, TO_DATE('2018-10-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (23, 6, 3, TO_DATE('2018-10-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (24, 7, 2, TO_DATE('2018-10-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (25, 2, 2, TO_DATE('2018-10-15 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (26, 3, 1, TO_DATE('2018-10-15 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (27, 4, 4, TO_DATE('2018-10-15 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (28, 5, 6, TO_DATE('2018-10-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (29, 6, 7, TO_DATE('2018-10-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_TOURNEE (ID, ID_CAMION, ID_EMPLOYE, DATE_TOURNEE) VALUES (30, 7, 3, TO_DATE('2018-10-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));