create table MSPR_DECHET
(
    ID          NUMBER(5)    not null
        constraint PK_DECHET
            primary key,
    TYPE_DECHET VARCHAR2(50) not null,
    NIV_DANGER  NUMBER(2)    not null
)
/

INSERT INTO SYSTEM.MSPR_DECHET (ID, TYPE_DECHET, NIV_DANGER) VALUES (1, 'Papier', 0);
INSERT INTO SYSTEM.MSPR_DECHET (ID, TYPE_DECHET, NIV_DANGER) VALUES (2, 'Verre', 1);
INSERT INTO SYSTEM.MSPR_DECHET (ID, TYPE_DECHET, NIV_DANGER) VALUES (3, 'Plastique', 0);
INSERT INTO SYSTEM.MSPR_DECHET (ID, TYPE_DECHET, NIV_DANGER) VALUES (4, 'Luminaires', 1);
INSERT INTO SYSTEM.MSPR_DECHET (ID, TYPE_DECHET, NIV_DANGER) VALUES (5, 'Piles', 2);
INSERT INTO SYSTEM.MSPR_DECHET (ID, TYPE_DECHET, NIV_DANGER) VALUES (6, 'Encre', 0);
INSERT INTO SYSTEM.MSPR_DECHET (ID, TYPE_DECHET, NIV_DANGER) VALUES (7, 'Métal', 0);
INSERT INTO SYSTEM.MSPR_DECHET (ID, TYPE_DECHET, NIV_DANGER) VALUES (8, 'Déchets verts', 0);
INSERT INTO SYSTEM.MSPR_DECHET (ID, TYPE_DECHET, NIV_DANGER) VALUES (9, 'Gravats', 0);
INSERT INTO SYSTEM.MSPR_DECHET (ID, TYPE_DECHET, NIV_DANGER) VALUES (10, 'Appareils électriques', 2);
INSERT INTO SYSTEM.MSPR_DECHET (ID, TYPE_DECHET, NIV_DANGER) VALUES (11, 'Huile et peinture', 5);
INSERT INTO SYSTEM.MSPR_DECHET (ID, TYPE_DECHET, NIV_DANGER) VALUES (12, 'Aérosols', 5);