package com.cognizant.movie.dao;

import java.util.List;

import com.cognizant.movie.model.Movie;

public class FavoriteDaoCollectionImplTest {
    static FavoriteDao fdao = new FavoriteDaoCollectionImpl();

    public static void main(String[] args) {
        testAddFavorites();
        testGetAllFavorites();
        testRemoveFavorites();
        testGetAllFavorites();
    }

    public static void testAddFavorites() {
        System.out.println("Movie added into favorites");
        fdao.addFavoritesById(1, 2);
        fdao.addFavoritesById(1, 3);
    }

    public static void testRemoveFavorites() {
        System.out.println("Remove favorite movie");
        fdao.removeFavoritesById(1, 2);
    }

    public static void testGetAllFavorites() {

        try {
            System.out.println("Retrieving all the favorites");
            List<Movie> fav = fdao.getAllFavorites(1).getFavoriteList();
            for (Movie movie : fav) {
                System.out.println(movie);
            }
            System.out.println("No of favorites : " + fdao.getAllFavorites(1).getTotal());
        } catch (FavoriteEmptyException e) {
            System.out.println(e);
        }
    }

}
