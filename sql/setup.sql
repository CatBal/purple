drop table if exists message;
drop table if exists "subscription";
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

create table message (
	message_id serial primary key,
	text varchar(200), 
	subscriber_id int not null,
	forum_id int not null,
	constraint message_subscriber_fk foreign key (subscriber_id) references subscriber (subscriber_id),
	constraint message_forum_fk foreign key (forum_id) references forum (forum_id)
);

insert into message (text, subscriber_id, forum_id) values 
	('ciao, buona giornata!', 1, 2),
	('arrivederci!', 1, 1);

create table "subscription" (
	subscriber_id int not null,
	forum_id int not null,
	constraint subscription_subscriber_fk foreign key (subscriber_id) references subscriber (subscriber_id),
	constraint subscription_forum_fk foreign key (forum_id) references forum (forum_id)
);

insert into "subscription" (subscriber_id, forum_id) values
	(1, 2),
	(1, 1),
	(2, 2);




