drop table if exists subscriber;

create table subscriber (
	subscriber_id serial primary key,
	name varchar(10), 
	password varchar(15)
);

insert into subscriber (name, "password") values ('Sara', 'ciaociao');
insert into subscriber (name, "password") values ('Tatiana', 'buonasera');
insert into subscriber (name, "password") values ('Beatrice', 'password');
