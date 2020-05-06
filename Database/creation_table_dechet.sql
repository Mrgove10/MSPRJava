DROP TABLE mspr_dechet;

CREATE SEQUENCE mspr_seq_dechet start with 1 increment by 1 nocache;

CREATE TABLE mspr_dechet (
  id NUMBER(5) not null,
  type_dechet VARCHAR(20) not null,
  unite_dechet VARCHAR(5) not null,
  limite_forfait DECIMAL(3,2) not null,
  tarif_forfait DECIMAL(3,2) not null,
  tarif_lot DECIMAL(3,2) not null,
  nb_lot DECIMAL(3,2) not null,
  niv_danger NUMBER(2) not null,
  CONSTRAINT PK_DECHET PRIMARY KEY (id)
);

CREATE OR REPLACE TRIGGER mspr_dechet_on_insert
  BEFORE INSERT ON mspr_dechet
  FOR EACH ROW
BEGIN
  SELECT mspr_seq_dechet.nextval
  INTO :new.id
  FROM dual;
END;