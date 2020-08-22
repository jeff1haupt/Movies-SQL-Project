CREATE database IF NOT EXISTS movies;

USE movies;

DROP TABLE IF EXISTS critic_rating;
DROP TABLE IF EXISTS movie;
DROP TABLE IF EXISTS genre;

CREATE table genre(
id int (11) not null auto_increment,
genre_name VARCHAR(255) not null,
PRIMARY KEY (id) 
);

CREATE table movie(
Id int (11) not null auto_increment,
movie_title varchar(250) not null,
movie_length int,
release_date date,
director VARCHAR(50),
lead_actor VARCHAR(50),
revenue_made VARCHAR(50),
genre_id int(11) not null,
PRIMARY KEY (id),
FOREIGN KEY (genre_id) references genre(id)
);

CREATE table rating(
id int (11) not null auto_increment,
star_rating int not null,
movie_id int(11) not null,
PRIMARY KEY (id),
FOREIGN KEY (movie_id) references movie(id)
);
