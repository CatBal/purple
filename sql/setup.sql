--subsription
drop table if exists subscriber;
drop table if exists forum;

create table subscriber (
	subscriber_id serial primary key,
	name varchar(10), 
	password varchar(15)
);

begin;
	insert into subscriber (name, "password") values ('Sara', 'ciaociao');
	insert into subscriber (name, "password") values ('Tatiana', 'buonasera');
	insert into subscriber (name, "password") values ('Beatrice', 'password');
commit;

create table forum (
	forum_id serial primary key,
	name varchar(25), 
	description varchar(75)
);

begin;
	insert into forum (name, description) values
		('Fumetti', 'Qui parliamo dei fumetti che ci sono piaciuti di più!'),
	 	('Cucina', 'Spazio per confrontarci sulle nostre ricette!');
commit;