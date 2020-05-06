DROP TABLE mspr_dechet_depot;

CREATE SEQUENCE mspr_seq_dechet_depot start with 1 increment by 1 nocache;

CREATE TABLE mspr_dechet_depot (
  id NUMBER(5) not null,
  id_depot NUMBER(5) not null,
  id_dechet NUMBER(5) not null,
  CONSTRAINT PK_DECHET_DEPOT PRIMARY KEY (id),
  CONSTRAINT FK_DEPOT_DECHET_DEPOT FOREIGN KEY (id_depot) REFERENCES mspr_depot(id),
  CONSTRAINT FK_DECHET_DECHET_DEPOT FOREIGN KEY (id_dechet) REFERENCES mspr_dechet(id)
);

CREATE OR REPLACE TRIGGER mspr_dechet_depot_on_insert
  BEFORE INSERT ON mspr_dechet_depot
  FOR EACH ROW
BEGIN
  SELECT mspr_seq_dechet_depot.nextval
  INTO :new.id
  FROM dual;
END;