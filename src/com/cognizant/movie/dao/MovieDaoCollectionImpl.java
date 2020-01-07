package com.cognizant.movie.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.movie.model.Movie;
import com.cognizant.movie.util.DateUtil;

public class MovieDaoCollectionImpl implements MovieDao {
    public static List<Movie> movieitemList;

    public MovieDaoCollectionImpl() {
        if (movieitemList == null || movieitemList.isEmpty()) {
            Movie movie1 = new Movie(1, "Avatar", 2787965087L, true,
                    DateUtil.convertToDate("15/03/2017"), "Science Fiction", true);
            Movie movie2 = new Movie(2, "The Avengers", 1518812988L, true,
                    DateUtil.convertToDate("23/12/2017"), "Super Hero", false);
            Movie movie3 = new Movie(3, "Titanic", 2187463944L, true,
                    DateUtil.convertToDate("21/08/2017"), "Romance", false);
            Movie movie4 = new Movie(4, "Jurassic Park", 1671713208L, false,
                    DateUtil.convertToDate("02/07/2017"), "Science Fiction", true);
            Movie movie5 = new Movie(5, "Avengers: End Game", 2750760348L, true,
                    DateUtil.convertToDate("02/11/2022"), "Super Hero", true);
            movieitemList = new ArrayList<Movie>();
            movieitemList.add(movie1);
            movieitemList.add(movie2);
            movieitemList.add(movie3);
            movieitemList.add(movie4);
            movieitemList.add(movie5);

        }
    }

    @Override
    public Movie getMovieById(long movieId) {
        for (Movie movie : movieitemList) {
            if (movie.getMovieId() == movieId) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public void modifyMovieList(Movie movieLists) {
        for (int i = 0; i < movieitemList.size(); i++) {
            if (movieitemList.get(i).getMovieId() == movieLists.getMovieId()) {
                movieitemList.set(i, movieLists);
            }

        }
    }

    @Override
    public List<Movie> getMovieListAdmin() {

        return movieitemList;
    }

    @Override
    public List<Movie> getMovieListCustomer() {
        ArrayList<Movie> movieItems = new ArrayList<Movie>();
        for (Movie movie : movieitemList) {
            if ((movie.getDateOfLaunch().before(new Date())
                    || movie.getDateOfLaunch().equals(new Date())) && movie.isActive() == true) {
                movieItems.add(movie);

            }
        }
        return movieItems;
    }
}
