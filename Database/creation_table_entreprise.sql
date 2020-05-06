DROP TABLE mspr_entreprise;

CREATE SEQUENCE mspr_seq_entreprise start with 1 increment by 1;

CREATE TABLE mspr_entreprise(
  id NUMBER(5) not null,
  id_adresse NUMBER(5) not null,
  raison_social VARCHAR(50) not null,
  siret NUMBER(20) not null,
  tel VARCHAR(15),
  nom_contact VARCHAR(20),
  CONSTRAINT PK_ENTREPRISE PRIMARY KEY (id),
  CONSTRAINT FK_ADRESSE_ENTREPRISE FOREIGN KEY (id_adresse) REFERENCES mspr_adresse(id)
);

CREATE OR REPLACE TRIGGER mspr_entreprise_on_insert
  BEFORE INSERT ON mspr_entreprise
  FOR EACH ROW
BEGIN
  SELECT mspr_seq_entreprise.nextval
  INTO :new.id
  FROM dual;
END;