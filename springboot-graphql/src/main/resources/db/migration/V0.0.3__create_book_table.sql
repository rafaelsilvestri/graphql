CREATE TABLE book(
	id bigint PRIMARY KEY,
	isbn varchar (100),
	title varchar(255),
	author_id bigint,
	FOREIGN KEY (author_id) REFERENCES author (id)
);
