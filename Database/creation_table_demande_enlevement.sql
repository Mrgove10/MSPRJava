DROP TABLE mspr_demande_enlevement;

CREATE SEQUENCE mspr_seq_demande_enlevement start with 1 increment by 1;

CREATE TABLE mspr_demande_enlevement(
  id NUMBER(5) not null,
  id_entreprise NUMBER(5) not null,
  id_tournee NUMBER(5) not null,
  no_demande NUMBER(30) not null,
  date_demande DATE DEFAULT (sysdate) not null,
  date_enlevement DATE DEFAULT (sysdate) not null,
  CONSTRAINT PK_DEMANDE_ENLEVEMENT PRIMARY KEY (id),
  CONSTRAINT FK_ENTREPRISE_DEMANDE_ENLEVEMENT FOREIGN KEY (id_entreprise) REFERENCES mspr_entreprise(id),
  CONSTRAINT FK_TOURNEE_DEMANDE_ENLEVEMENT FOREIGN KEY (id_tournee) REFERENCES mspr_tournee(id)
);

CREATE OR REPLACE TRIGGER mspr_demande_enlevement_on_insert
  BEFORE INSERT ON mspr_demande_enlevement
  FOR EACH ROW
BEGIN
  SELECT mspr_seq_demande_enlevement.nextval
  INTO :new.id
  FROM dual;
END;