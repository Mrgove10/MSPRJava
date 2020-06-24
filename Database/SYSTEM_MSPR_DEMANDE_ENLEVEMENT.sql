create table MSPR_DEMANDE_ENLEVEMENT
(
    ID              NUMBER(5)              not null
        constraint PK_DEMANDE_ENLEVEMENT
            primary key,
    ID_ENTREPRISE   NUMBER(5)              not null
        constraint FK_ENTREPRISE_DEMANDE_ENLEVEMENT
            references MSPR_ENTREPRISE,
    ID_TOURNEE      NUMBER(5)
        constraint FK_TOURNEE_DEMANDE_ENLEVEMENT
            references MSPR_TOURNEE,
    DATE_DEMANDE    DATE default (sysdate) not null,
    DATE_ENLEVEMENT DATE default (sysdate) not null
)
/

INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (43, 11, 2, TO_DATE('2018-11-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-11-16 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (1, 1, 1, TO_DATE('2018-08-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-09-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (2, 4, 1, TO_DATE('2018-08-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-09-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (3, 11, 1, TO_DATE('2018-08-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-09-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (4, 7, 2, TO_DATE('2018-08-15 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-08-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (5, 9, 2, TO_DATE('2018-08-15 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-08-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (6, 10, 3, TO_DATE('2018-08-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-08-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (7, 9, 3, TO_DATE('2018-08-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-08-18 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (8, 15, 4, TO_DATE('2018-08-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-08-16 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (9, 13, 4, TO_DATE('2018-08-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-08-15 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (10, 8, 4, TO_DATE('2018-08-13 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-08-16 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (11, 6, 4, TO_DATE('2018-08-13 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2019-08-17 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (12, 1, 5, TO_DATE('2018-08-08 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-08-12 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (13, 4, 5, TO_DATE('2018-08-08 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-08-13 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (14, 3, 6, TO_DATE('2018-08-03 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-08-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (15, 2, 6, TO_DATE('2018-08-03 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-08-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (16, 15, 7, TO_DATE('2018-08-03 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-08-16 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (17, 13, 7, TO_DATE('2018-08-16 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2078-08-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (18, 15, 1, TO_DATE('2018-09-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-09-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (19, 14, 2, TO_DATE('2018-09-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-09-15 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (20, 11, 3, TO_DATE('2018-09-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-09-15 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (21, 10, 4, TO_DATE('2018-09-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-09-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (22, 5, 6, TO_DATE('2018-09-11 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-09-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (23, 6, 7, TO_DATE('2018-09-11 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-09-21 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (24, 4, 7, TO_DATE('2018-09-17 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (25, 5, 5, TO_DATE('2018-09-17 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (26, 7, 3, TO_DATE('2018-09-17 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-09-27 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (27, 13, 2, TO_DATE('2018-09-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-09-30 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (28, 5, 1, TO_DATE('2018-09-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-09-30 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (29, 6, 4, TO_DATE('2018-09-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-09-30 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (30, 15, 4, TO_DATE('2018-09-28 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-10-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (31, 14, 6, TO_DATE('2018-10-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-10-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (32, 1, 7, TO_DATE('2018-10-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-10-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (33, 3, 5, TO_DATE('2018-10-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-10-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (34, 5, 3, TO_DATE('2018-10-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-10-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (35, 6, 2, TO_DATE('2018-10-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-10-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (36, 10, 2, TO_DATE('2018-10-09 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-10-15 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (37, 6, 1, TO_DATE('2018-10-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-10-15 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (38, 8, 4, TO_DATE('2018-10-11 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-10-15 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (39, 9, 6, TO_DATE('2018-10-14 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-10-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (40, 14, 7, TO_DATE('2018-10-15 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-10-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (41, 10, 3, TO_DATE('2018-10-14 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-10-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO SYSTEM.MSPR_DEMANDE_ENLEVEMENT (ID, ID_ENTREPRISE, ID_TOURNEE, DATE_DEMANDE, DATE_ENLEVEMENT) VALUES (42, 5, 2, TO_DATE('2018-11-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2018-11-16 00:00:00', 'YYYY-MM-DD HH24:MI:SS'));