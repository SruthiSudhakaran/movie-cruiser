-- 1. View Movie List Admin (MVUC001)
-- a. Inserting movies 

insert into movie_cruiser.movie(mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser) values('Avatar', 2787965087, 'Yes', '2017-03-15' , 'Science Fiction' , 'Yes');
insert into movie_cruiser.movie(mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser) values('The Avengers', 1518812988, 'Yes', '2017-12-23' , 'Superhero' , 'No');
insert into movie_cruiser.movie(mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser) values('Titanic', 2187463944, 'Yes', '2017-08-21' , 'Romance' , 'No');
insert into movie_cruiser.movie(mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser) values('Jurassic World', 1671713208, 'No', '2017-07-02' , 'Science Fiction' , 'Yes');
insert into movie_cruiser.movie(mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser) values('Avengers:End Game', 2750760348, 'Yes', '2022-11-02' , 'Superhero' , 'Yes');

-- b. Retrieving records (admin view)
SELECT 
    *
FROM
    movie_cruiser.movie;
    
    
-- 2. View Movie List Customer (MVUC002)
-- a. Retrieving records (customer view)

SELECT 
    *
FROM
    movie_cruiser.movie
WHERE
    mv_active = 'Yes'
        AND mv_date_of_launch < (SELECT CURDATE());


-- 3. Edit Movie List (MVUC003)
-- a. Retrieving particular movie details for edit
SELECT 
    *
FROM
    movie_cruiser.movie
WHERE
    mv_id = 1;

-- b. Updating movie id=1
UPDATE movie_cruiser.movie 
SET 
    mv_title = 'FF9',
    mv_box_office = '1234567892',
    mv_active = 'No',
    mv_date_of_launch = '2018-03-15',
    mv_genre = 'Superhero',
    mv_has_teaser = 'No'
WHERE
    mv_id = 1;


-- 4. Add to Favorite (MVUC004)
-- a. Inserting user details and adding favorites in their user id
insert into movie_cruiser.customer(cus_name) values ('Andy');
insert into movie_cruiser.customer(cus_name) values ('Rubin');

insert into movie_cruiser.favorite(fav_cus_id,fav_mv_id) values (1,1);
insert into movie_cruiser.favorite(fav_cus_id,fav_mv_id) values (1,1);
insert into movie_cruiser.favorite(fav_cus_id,fav_mv_id) values (1,3);


-- 5. View Favorite (MVUC005)
-- a. Retrieving all the favorites from the particular user id
SELECT 
    mv.mv_id,
    mv.mv_title,
    mv.mv_box_office,
    mv.mv_active,
    mv.mv_date_of_launch,
    mv.mv_genre,
    mv.mv_has_teaser
FROM
    movie_cruiser.customer cus
        JOIN
    movie_cruiser.favorite fav ON cus.cus_id = fav.fav_cus_id
        JOIN
    movie_cruiser.movie mv ON fav.fav_mv_id = mv.mv_id
WHERE
    cus.cus_id = 1;



-- b. Total Count
SELECT 
    COUNT(mv.mv_id) AS No_of_Favorites
FROM
    movie_cruiser.favorite fav
        JOIN
    movie_cruiser.movie mv ON fav.fav_mv_id = mv.mv_id
        JOIN
    movie_cruiser.customer cus ON cus.cus_id = fav.fav_cus_id
WHERE
    cus.cus_id = 1;


-- 6. Remove Item from Favorite (MVUC006)
-- a. Removing movie from the favorite
DELETE FROM movie_cruiser.favorite 
WHERE
    fav_cus_id = 1 AND fav_mv_id = 1 LIMIT 1;