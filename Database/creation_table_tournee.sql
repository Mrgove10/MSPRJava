DROP TABLE mspr_tournee;

CREATE SEQUENCE mspr_seq_tournee start with 1 increment by 1;

CREATE TABLE mspr_tournee(
  id NUMBER(5) not null,
  id_camion NUMBER(5) not null,
  id_employe NUMBER(5) not null,
  date_tournee DATE DEFAULT (sysdate) not null,
  CONSTRAINT PK_TOURNEE PRIMARY KEY (id),
  CONSTRAINT FK_CAMION_TOURNEE FOREIGN KEY (id_camion) REFERENCES mspr_camion(id),
  CONSTRAINT FK_EMPLOYE_TOURNEE FOREIGN KEY (id_employe) REFERENCES mspr_employe(id)
);

CREATE OR REPLACE TRIGGER mspr_tournee_on_insert
  BEFORE INSERT ON mspr_tournee
  FOR EACH ROW
BEGIN
  SELECT mspr_seq_tournee.nextval
  INTO :new.id
  FROM dual;
END;