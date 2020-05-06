DROP TABLE mspr_adresse;

CREATE SEQUENCE mspr_seq_adresse start with 1 increment by 1;

CREATE TABLE mspr_adresse(
  id NUMBER(10) not null,
  no_rue NUMBER(3),
  rue VARCHAR(50),
  cp NUMBER(5) not null,
  ville VARCHAR(50) not null,
  CONSTRAINT PK_ADRESSE PRIMARY KEY (id)
);

CREATE OR REPLACE TRIGGER mspr_adresse_on_insert
  BEFORE INSERT ON mspr_adresse
  FOR EACH ROW
BEGIN
  SELECT mspr_seq_adresse.nextval
  INTO :new.id
  FROM dual;
END;