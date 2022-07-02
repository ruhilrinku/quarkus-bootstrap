--liquibase formatted sql
--changeset nishant_kumar:create-company-table-2

CREATE TABLE If NOT EXISTS company(
   id INT PRIMARY KEY,
   code VARCHAR(40),
   name VARCHAR(100),
   description VARCHAR(256)
);

CREATE SEQUENCE If NOT EXISTS public.hibernate_sequence
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1
    NO CYCLE;