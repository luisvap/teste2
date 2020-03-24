create database navitateste2;

use navitateste2;

-- Table: marca

-- DROP TABLE marca;

CREATE TABLE marca
(
  marca_id integer NOT NULL,
  marca character varying(40) NOT NULL,
  CONSTRAINT marca_pk PRIMARY KEY (marca_id),
  CONSTRAINT marca_uk UNIQUE (marca)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE marca
  OWNER TO postgres;


-- Table: patrimonio

-- DROP TABLE patrimonio;

CREATE TABLE patrimonio
(
  nome character varying(40) NOT NULL,
  marca_id integer NOT NULL,
  descricao character varying(70),
  num_tombo serial NOT NULL,
  CONSTRAINT patrimonio_pk PRIMARY KEY (num_tombo),
  CONSTRAINT patrimonio_marca_fk FOREIGN KEY (marca_id)
      REFERENCES marca (marca_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE patrimonio
  OWNER TO postgres;


-- Table: usuario

-- DROP TABLE usuario;

CREATE TABLE usuario
(
  nome character varying(10) NOT NULL,
  email character varying(40) NOT NULL,
  senha character varying(20) NOT NULL,
  usuario_id serial NOT NULL,
  CONSTRAINT usuario_pk PRIMARY KEY (usuario_id),
  CONSTRAINT usuario_uk UNIQUE (email)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE usuario
  OWNER TO postgres;
