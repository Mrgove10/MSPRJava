DROP TABLE mspr_site;

CREATE SEQUENCE mspr_seq_site start with 1 increment by 1;

CREATE TABLE mspr_site(
  id NUMBER(5) not null,
  id_adresse NUMBER(5) not null,
  nom VARCHAR(20) not null,
  CONSTRAINT PK_SITE PRIMARY KEY (id),
  CONSTRAINT FK_ADRESSE_SITE FOREIGN KEY (id_adresse) REFERENCES mspr_adresse(id)
);

CREATE OR REPLACE TRIGGER mspr_site_on_insert
  BEFORE INSERT ON mspr_site
  FOR EACH ROW
BEGIN
  SELECT mspr_seq_site.nextval
  INTO :new.id
  FROM dual;
END;