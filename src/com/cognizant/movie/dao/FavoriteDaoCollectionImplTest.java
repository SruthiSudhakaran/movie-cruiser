package com.cognizant.movie.dao;

import java.util.List;

import com.cognizant.movie.model.Movie;

public class FavoriteDaoCollectionImplTest {
    static FavoriteDao favoritedao = new FavoriteDaoCollectionImpl();

    public static void main(String[] args) {
        testAddFavorites();
        testGetAllFavorites();
        testRemoveFavorites();
        testGetAllFavorites();
    }

    public static void testAddFavorites() {
        System.out.println("Movie added into favorites");
        favoritedao.addFavoritesById(1, 2);
        favoritedao.addFavoritesById(1, 3);
    }

    public static void testRemoveFavorites() {
        System.out.println("Remove favorite movie");
        favoritedao.removeFavoritesById(1, 2);
    }

    public static void testGetAllFavorites() {

        try {
            System.out.println("Retrieving all the favorites");
            List<Movie> favavorite = favoritedao.getAllFavorites(1).getFavoriteList();
            for (Movie movie : favavorite) {
                System.out.println(movie);
            }
            System.out.println("No of favorites : " + favoritedao.getAllFavorites(1).getTotal());
        } catch (FavoriteEmptyException e) {
            System.out.println(e);
        }
    }

}
