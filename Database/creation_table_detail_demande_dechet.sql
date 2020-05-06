DROP TABLE mspr_detail_demande_dechet;

CREATE SEQUENCE mspr_seq_detail_demande_dechet start with 1 increment by 1 nocache;

CREATE TABLE mspr_detail_demande_dechet (
  id NUMBER(5) not null,
  id_detail_demande NUMBER(5) not null,
  id_dechet NUMBER(5) not null,
  CONSTRAINT PK_DETAIL_DEMANDE_DECHET PRIMARY KEY (id),
  CONSTRAINT FK_DETAIL_DEMANDE_DETAIL_DEMANDE_DECHET FOREIGN KEY (id_detail_demande) REFERENCES mspr_detail_demande(id),
  CONSTRAINT FK_DECHET_DETAIL_DEMANDE_DECHET FOREIGN KEY (id_dechet) REFERENCES mspr_dechet(id)
);

CREATE OR REPLACE TRIGGER mspr_detail_demande_dechet_on_insert
  BEFORE INSERT ON mspr_detail_demande_dechet
  FOR EACH ROW
BEGIN
  SELECT mspr_seq_detail_demande_dechet.nextval
  INTO :new.id
  FROM dual;
END;