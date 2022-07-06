--liquibase formatted sql
--changeset nishant_kumar:insert-data-company-table-3

INSERT INTO company VALUES(nextval('hibernate_sequence'), 'Brightly', 'Brightly', 'Brightly Software Pvt. Ltd.');

--rollback delete from company where id < nextval('hibernate_sequence');