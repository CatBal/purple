drop table if exists "user";

create table "user" (
	user_id serial primary key,
	name varchar(10), 
	password varchar(15)
);