package com.cognizant.movie.dao;

import java.util.List;

import com.cognizant.movie.model.Movie;
import com.cognizant.movie.util.DateUtil;

public class MovieDaoCollectionImplTest {
    static MovieDao moviedao = new MovieDaoCollectionImpl();

    public static void main(String[] args) {
        testGetMovieListAdmin();
        testGetMovieListCustomer();
        testEditMovie();
        testGetMovieListAdmin();
        testGetMovieListCustomer();
        testGetMovie();
    }

    public static void testEditMovie() {
        System.out.println("\nModify Movie");
        Movie movie = new Movie(1, "X-men", 9562314789L, true, DateUtil.convertToDate("15/02/2016"),
                "Super Hero", false);
        moviedao.modifyMovieList(movie);
    }

    public static void testGetMovieListAdmin() {
        System.out.println("Admin View");
        List<Movie> movie = moviedao.getMovieListAdmin();
        System.out.printf("%-10s%-20s%-15s%-10s%-17s%-15s%-15s\n", "Id", "Title", "Box Office",
                "Active", "Date of Launch", "Genre", "Has Teaser");
        for (Movie movie1 : movie) {
            System.out.println(movie1);
        }

    }

    public static void testGetMovieListCustomer() {
        System.out.println("\nCustomer View");
        List<Movie> movie = moviedao.getMovieListCustomer();
        System.out.printf("%-10s%-20s%-15s%-10s%-17s%-15s%-15s\n", "Id", "Title", "Box Office",
                "Active", "Date of Launch", "Genre", "Has Teaser");
        for (Movie movies : movie) {
            System.out.println(movies);
        }
    }

    public static void testGetMovie() {
        System.out.println("\nGet Movie");
        System.out.printf("%-10s%-20s%-15s%-10s%-17s%-15s%-15s\n", "Id", "Title", "Box Office",
                "Active", "Date of Launch", "Genre", "Has Teaser");
        Movie movie = moviedao.getMovieById(1);
        System.out.println(movie);

    }

}
