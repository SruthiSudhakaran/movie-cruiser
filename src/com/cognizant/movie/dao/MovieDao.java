package com.cognizant.movie.dao;

import java.util.List;

import com.cognizant.movie.model.Movie;

public interface MovieDao {
    public Movie getMovieById(long movieId);

    public void modifyMovieList(Movie movieLists);

    public List<Movie> getMovieListAdmin();

    public List<Movie> getMovieListCustomer();
}
