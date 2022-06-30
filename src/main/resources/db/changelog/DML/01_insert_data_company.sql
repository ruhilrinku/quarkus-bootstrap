--liquibase formatted sql
--changeset nishant_kumar:insert-data_company

INSERT INTO company VALUES(nextval('hibernate_sequence'), 'Brightly', 'Brightly', 'Brightly Software India Pvt. Ltd.');
INSERT INTO company VALUES(nextval('hibernate_sequence'), 'SHL', 'SHL', 'SHL Software India Pvt. Ltd.');