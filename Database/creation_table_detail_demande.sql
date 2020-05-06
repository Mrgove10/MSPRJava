DROP TABLE mspr_detail_demande;

CREATE SEQUENCE mspr_seq_detail_demande start with 1 increment by 1;

CREATE TABLE mspr_detail_demande(
  id NUMBER(5) not null,
  id_demande_enlevement NUMBER(5) not null,
  quantite NUMBER(10) not null,
  CONSTRAINT PK_DETAIL_DEMANDE PRIMARY KEY (id),
  CONSTRAINT FK_DETAIL_DEMANDE_DEMANDE_ENLEVEMENT FOREIGN KEY (id_demande_enlevement) REFERENCES mspr_demande_enlevement(id)
);

CREATE OR REPLACE TRIGGER mspr_detail_demande_on_insert
  BEFORE INSERT ON mspr_detail_demande
  FOR EACH ROW
BEGIN
  SELECT mspr_seq_detail_demande.nextval
  INTO :new.id
  FROM dual;
END;