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

insert into genre (genre_name) values ('Action');
insert into genre (genre_name) values ('Animation');
insert into genre (genre_name) values ('Comedy');
insert into genre (genre_name) values ('Crime');
insert into genre (genre_name) values ('Drama');
insert into genre (genre_name) values ('Romance');
insert into genre (genre_name) values ('War');


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

insert into movie (movie_title, movie_length, release_date, director, lead_actor, revenue_made, genre_id) values ('Body, The', 216, '1968-01-13', 'Ursola Goldin', 'Arlene Taffs', '$75813599.61', 5);
insert into movie (movie_title, movie_length, release_date, director, lead_actor, revenue_made, genre_id) values ('Victim', 214, '1973-03-20', 'Issiah Stollenhof', 'Tiphani Capron', '$83336144.40', 7);
insert into movie (movie_title, movie_length, release_date, director, lead_actor, revenue_made, genre_id) values ('Skylab, Le', 207, '1975-10-23', 'Tammy Bartel', 'Dawn Delacroux', '$16223413.73', 4);
insert into movie (movie_title, movie_length, release_date, director, lead_actor, revenue_made, genre_id) values ('Bill Burr: Let It Go', 200, '2011-05-27', 'Maryann Dowty', 'Kory Gradwell', '$56969453.58', 5);
insert into movie (movie_title, movie_length, release_date, director, lead_actor, revenue_made, genre_id) values ('Brown''s Requiem', 221, '1966-02-18', 'Jodee Fellgatt', 'Derrick Benns', '$77645294.44', 3);
insert into movie (movie_title, movie_length, release_date, director, lead_actor, revenue_made, genre_id) values ('Monte Carlo', 250, '1951-01-13', 'Dorri Rozsa', 'Lyndsay Valiant', '$52108775.28', 2);
insert into movie (movie_title, movie_length, release_date, director, lead_actor, revenue_made, genre_id) values ('Knowing', 211, '2017-12-30', 'Gianni Philippou', 'Camala Giveen', '$48047588.07', 1);
insert into movie (movie_title, movie_length, release_date, director, lead_actor, revenue_made, genre_id) values ('Good Neighbor Sam', 216, '2000-04-22', 'Oswald Gunney', 'Anne-corinne Harcombe', '$57522129.92', 3);
insert into movie (movie_title, movie_length, release_date, director, lead_actor, revenue_made, genre_id) values ('Fantasia', 218, '2016-06-07', 'Michal Cadany', 'Elianora Samber', '$44481610.98', 5);
insert into movie (movie_title, movie_length, release_date, director, lead_actor, revenue_made, genre_id) values ('Hunger', 213, '2002-07-07', 'Oneida Geffe', 'Cristiano Hawlgarth', '$30008468.70', 6);


CREATE table critic_rating(
id int (11) not null auto_increment,
star_rating int not null,
movie_id int(11) not null,
PRIMARY KEY (id),
FOREIGN KEY (movie_id) references movie(id)
);

insert into critic_rating (star_rating, movie_id) values (4, 1);
insert into critic_rating (star_rating, movie_id) values (3, 2);
insert into critic_rating (star_rating, movie_id) values (2, 3);
insert into critic_rating (star_rating, movie_id) values (5, 4);
insert into critic_rating (star_rating, movie_id) values (4, 5);
insert into critic_rating (star_rating, movie_id) values (4, 6);
insert into critic_rating (star_rating, movie_id) values (1, 7);
insert into critic_rating (star_rating, movie_id) values (2, 8);
insert into critic_rating (star_rating, movie_id) values (1, 9);
insert into critic_rating (star_rating, movie_id) values (5, 10);