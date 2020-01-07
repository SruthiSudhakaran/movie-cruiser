package com.cognizant.movie.dao;

import java.util.List;
import com.cognizant.movie.util.DateUtil;
import com.cognizant.movie.model.Movie;

public class MovieDaoCollectionImplTest {
    static MovieDao mdao = new MovieDaoCollectionImpl();

    public static void main(String[] args) {
        testGetMovieListAdmin();
        testGetMovieListCustomer();
        testEditMovie();
        testGetMovieListAdmin();
        testGetMovieListCustomer();
        testGetMovie();
    }

    public static void testEditMovie() {
        System.out.println("\nModify Menu Item");
        Movie movieItem = new Movie(1, "X-men", 1215444L, true,
                DateUtil.convertToDate("15/02/2016"), "Super Hero", false);
        mdao.modifyMovieList(movieItem);
    }

    public static void testGetMovieListAdmin() {
        System.out.println("Admin View");
        List<Movie> menu = mdao.getMovieListAdmin();
        System.out.printf("%-10s%-20s%-15s%-10s%-17s%-15s%-15s\n", "Id", "Title", "Box Office",
                "Active", "Date of Launch", "Genre", "Has Teaser");
        for (Movie movie : menu) {
            System.out.println(movie);
        }

    }

    public static void testGetMovieListCustomer() {
        System.out.println("\nCustomer View");
        List<Movie> movieItem = mdao.getMovieListCustomer();
        System.out.printf("%-10s%-20s%-15s%-10s%-17s%-15s%-15s\n", "Id", "Title", "Box Office",
                "Active", "Date of Launch", "Genre", "Has Teaser");
        for (Movie movie : movieItem) {
            System.out.println(movie);
        }
    }

    public static void testGetMovie() {
        System.out.println("\nGet Menu Item");
        System.out.printf("%-10s%-20s%-15s%-10s%-17s%-15s%-15s\n", "Id", "Title", "Box Office",
                "Active", "Date of Launch", "Genre", "Has Teaser");
        Movie movie = mdao.getMovieById(1);
        System.out.println(movie);

    }

}
