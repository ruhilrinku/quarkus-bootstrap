--liquibase formatted sql
--changeset nishant_kumar:insert-data-company-table-3

INSERT INTO company VALUES(nextval('hibernate_sequence'), 'Brightly', 'Brightly', 'Brightly Software India Pvt. Ltd.');
INSERT INTO company VALUES(nextval('hibernate_sequence'), 'SIEMANS', 'SIEMANS', 'SIEMANS Software India Pvt. Ltd.');