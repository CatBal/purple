drop table if exists message;
drop table if exists "subscription";
drop table if exists subscriber;
drop table if exists forum;

create table subscriber (
	subscriber_id serial primary key,
	name varchar(10) unique, 
	password varchar(15)
);

begin;
	insert into subscriber (name, "password") values ('Sara', 'ciaociao');
	insert into subscriber (name, "password") values ('Tatiana', 'buonasera');
	insert into subscriber (name, "password") values ('Beatrice', 'password');
    insert into subscriber (name,"password") values ('Giulia', 'pastina');
commit;

create table forum (
	forum_id serial primary key,
	name varchar(25), 
	description varchar(75)
);

begin;
	insert into forum (name, description) values
		('Presentazione', 'Qui presentiamo i nostri dipendenti'),
	 	('News', 'Spazio per confrontarci sulle novità del mondo informatico!'),
	    ('Segnalazioni', 'Supporto tecnico');
commit;

create table message (
	message_id serial primary key,
	text varchar(200), 
	creation timestamp,
	subscriber_id int not null,
	forum_id int not null,
	constraint message_subscriber_fk foreign key (subscriber_id) references subscriber (subscriber_id),
	constraint message_forum_fk foreign key (forum_id) references forum (forum_id)
);

insert into message (text, creation, subscriber_id, forum_id) values 
	('ciao, per windows 11 aggiornamento disponibile', current_timestamp,1, 2),
	('Buongiorno, sono Sara Colagrossi e da oggi faccio parte della vostra azienda', current_timestamp,1, 1),
	('Ciao a tutti, sono Tatiana Rampini e da oggi anche io faccio parte di questa azienda',current_timestamp, 2,1),
    ('Buongiorno, sono Beatrice Masucci e faccio parte di questo Team',current_timestamp, 3, 1),
    ('Salve, sono Giulia Sandulli Colosimo e sono una vostra nuova collega', current_timestamp,4,1),
    ('Buongiorno, vorrei segnalare la mia collega Sabrina Martinelli perchè mi da fastidio',current_timestamp, 4,3);

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
