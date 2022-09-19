-- this script should run on postgres
--
-- psql -U postgres \i setup.sql

drop schema if exists purple cascade;
drop user if exists purple;

create user purple with password 'password';
create schema authorization purple;
