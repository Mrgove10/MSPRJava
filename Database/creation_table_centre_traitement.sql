DROP TABLE mspr_centre_traitement;

CREATE SEQUENCE mspr_seq_centre_traitement start with 1 increment by 1;

CREATE TABLE mspr_centre_traitement(
  id NUMBER(5) not null,
  id_adresse NUMBER(5) not null,
  nom VARCHAR(20) not null,
  CONSTRAINT PK_CENTRE_TRAITEMENT PRIMARY KEY (id),
  CONSTRAINT FK_ADRESSE_CENTRE_TRAITEMENT FOREIGN KEY (id_adresse) REFERENCES mspr_adresse(id)
);

CREATE OR REPLACE TRIGGER mspr_centre_traitement_on_insert
  BEFORE INSERT ON mspr_centre_traitement
  FOR EACH ROW
BEGIN
  SELECT mspr_seq_centre_traitement.nextval
  INTO :new.id
  FROM dual;
END;