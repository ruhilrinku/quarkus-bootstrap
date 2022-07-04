--liquibase formatted sql
--changeset nishant_kumar:create-parts-table-4

CREATE TABLE If NOT EXISTS parts(
   id INT PRIMARY KEY,
   code VARCHAR(40),
   name VARCHAR(100),
   description VARCHAR(256)
);

--rollback drop table if exists parts;

--changeset nishant_kumar:create-parts_new-table-5

CREATE TABLE If NOT EXISTS parts_new(
   id INT PRIMARY KEY,
   code VARCHAR(40),
   name VARCHAR(100),
   description VARCHAR(256)
);

--rollback drop table if exists parts_new;