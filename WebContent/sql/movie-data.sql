use movie_cruiser;

-- 1. View Movie List Admin (MVUC001)
-- a. Inserting movies 

insert into movie_cruiser.movie(mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser)
values('Avatar', 2787965087, 'Yes', '2017-03-15' , 'Science Fiction' , 'Yes');
insert into movie_cruiser.movie(mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser) 
values('The Avengers', 1518812988, 'Yes', '2017-12-23' , 'Superhero' , 'No');
insert into movie_cruiser.movie(mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser) 
values('Titanic', 2187463944, 'Yes', '2017-08-21' , 'Romance' , 'No');
insert into movie_cruiser.movie(mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser) 
values('Jurassic World', 1671713208, 'No', '2017-07-02' , 'Science Fiction' , 'Yes');
insert into movie_cruiser.movie(mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser) 
values('Avengers:End Game', 2750760348, 'Yes', '2022-11-02' , 'Superhero' , 'Yes');

-- b. Retrieving records (admin view)

select 
    *
from
    movie_cruiser.movie;
    
    
-- 2. View Movie List Customer (MVUC002)
-- a. Retrieving records (customer view)

select 
    *
from
    movie_cruiser.movie
where
    mv_active = 'Yes' and mv_date_of_launch < (select CurDate());


-- 3. Edit Movie List (MVUC003)
-- a. Retrieving particular movie details for edit

select 
    *
from
    movie_cruiser.movie
where
    mv_id = 1;


-- b. Updating movie id=1

update movie_cruiser.movie set mv_title = 'FF9' ,
mv_box_office = '1234567892' , mv_active = 'No' , 
mv_date_of_launch = '2018-03-15' , mv_genre = 'Superhero' , 
mv_has_teaser = 'No' where mv_id = 1;


-- 4. Add to Favorite (MVUC004)
-- a. Inserting user details and adding favorites in their user id
insert into movie_cruiser.customer(cus_name) values ('Andy');
insert into movie_cruiser.customer(cus_name) values ('Rubin');

insert into movie_cruiser.favorite(fav_cus_id,fav_mv_id) values (1,1);
insert into movie_cruiser.favorite(fav_cus_id,fav_mv_id) values (1,1);
insert into movie_cruiser.favorite(fav_cus_id,fav_mv_id) values (1,3);


-- 5. View Favorite (MVUC005)
-- a. Retrieving all the favorites from the particular user id
select 
    mv.mv_id,
    mv.mv_title,
    mv.mv_box_office,
    mv.mv_active,
    mv.mv_date_of_launch,
    mv.mv_genre,
    mv.mv_has_teaser
from
    movie_cruiser.customer cus
        join
    movie_cruiser.favorite fav ON cus.cus_id = fav.fav_cus_id
        join
    movie_cruiser.movie mv ON fav.fav_mv_id = mv.mv_id
where
    cus.cus_id = 1;



-- b. Total Count

select 
    count(mv.mv_id) as No_of_Favorites
from
    movie_cruiser.favorite fav
        join
    movie_cruiser.movie mv ON fav.fav_mv_id = mv.mv_id
        join
    movie_cruiser.customer cus ON cus.cus_id = fav.fav_cus_id
where
    cus.cus_id = 1;


-- 6. Remove Item from Favorite (MVUC006)
-- a. Removing movie from the favorite

delete from movie_cruiser.favorite where fav_cus_id = 1 and  fav_mv_id = 1 limit 1;
