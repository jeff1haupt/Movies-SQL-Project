CREATE database IF NOT EXISTS movies;

USE movies;

DROP TABLE IF EXISTS critic_rating;
DROP TABLE IF EXISTS movie;
DROP TABLE IF EXISTS genre;

CREATE table genre(
id int (11) not null auto_increment,
genre_name varchar(20) not null,
PRIMARY KEY (id) 
);

CREATE table movie(
Id int (11) not null auto_increment,
movie_title varchar(25) not null,
movie_length char(4),
film_rating char(6),
release_date date,
genre_id int(11) not null,
PRIMARY KEY (id),
FOREIGN KEY (genre_id) references genre(id)
);

CREATE table critic_rating(
id int (11) not null auto_increment,
star_rating char(5) not null,
movie_id int(11) not null,
PRIMARY KEY (id),
FOREIGN KEY (movie_id) references movie(id)
);