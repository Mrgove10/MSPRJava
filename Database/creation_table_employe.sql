DROP TABLE mspr_employe;

CREATE SEQUENCE mspr_seq_employe start with 1 increment by 1;

CREATE TABLE mspr_employe(
  id NUMBER(5) not null,
  id_site NUMBER(5) not null,
  nom VARCHAR(50) not null,
  prenom VARCHAR(50) not null,
  date_naissance DATE DEFAULT (sysdate) not null,
  date_embauche DATE DEFAULT (sysdate) not null,
  salaire NUMBER(10) not null,
  fonction VARCHAR(50) not null,
  CONSTRAINT PK_EMPLOYE PRIMARY KEY (id),
  CONSTRAINT FK_SITE_EMPLOYE FOREIGN KEY (id_site) REFERENCES mspr_site(id)
);

CREATE OR REPLACE TRIGGER mspr_employe_on_insert
  BEFORE INSERT ON mspr_employe
  FOR EACH ROW
BEGIN
  SELECT mspr_seq_employe.nextval
  INTO :new.id
  FROM dual;
END;