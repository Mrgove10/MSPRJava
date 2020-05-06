DROP TABLE mspr_camion;

CREATE SEQUENCE mspr_seq_camion start with 1 increment by 1;

CREATE TABLE mspr_camion(
  id NUMBER(5) not null,
  id_site NUMBER(5) not null,
  no_matricule VARCHAR(50) not null,
  date_achat DATE DEFAULT (sysdate) not null,
  modele VARCHAR(30) not null,
  marque VARCHAR(20) not null,
  CONSTRAINT PK_CAMION PRIMARY KEY (id),
  CONSTRAINT FK_SITE_CAMION FOREIGN KEY (id_site) REFERENCES mspr_adresse(id)
);

CREATE OR REPLACE TRIGGER mspr_camion_on_insert
  BEFORE INSERT ON mspr_camion
  FOR EACH ROW
BEGIN
  SELECT mspr_seq_camion.nextval
  INTO :new.id
  FROM dual;
END;