DROP TABLE mspr_depot;

CREATE SEQUENCE mspr_seq_depot start with 1 increment by 1 nocache;

CREATE TABLE mspr_depot(
  id NUMBER(5) not null,
  id_tournee NUMBER(5) not null,
  id_centre_traitement NUMBER(5) not null,
  quantite NUMBER(5) not null,
  CONSTRAINT PK_DEPOT PRIMARY KEY (id),
  CONSTRAINT FK_TOURNEE_DEPOT FOREIGN KEY (id_tournee) REFERENCES mspr_tournee(id),
  CONSTRAINT FK_CENTRE_TRAITEMENT_DEPOT FOREIGN KEY (id_centre_traitement) REFERENCES mspr_centre_traitement(id)
);

CREATE OR REPLACE TRIGGER mspr_depot_on_insert
  BEFORE INSERT ON mspr_depot
  FOR EACH ROW
BEGIN
  SELECT mspr_seq_depot.nextval
  INTO :new.id
  FROM dual;
END;