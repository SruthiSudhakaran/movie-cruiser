package com.cognizant.movie.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.movie.model.Favorite;
import com.cognizant.movie.model.Movie;

public class FavoriteDaoCollectionImpl implements FavoriteDao {
    public static HashMap<Long, Favorite> userFavorite;

    public FavoriteDaoCollectionImpl() {
        if (userFavorite == null) {
            HashMap<Long, Favorite> favorites = new HashMap<Long, Favorite>();
            userFavorite = favorites;
        }
    }

    @Override
    public Favorite getAllFavorites(long userId) throws FavoriteEmptyException {
        Favorite favorite = userFavorite.get(userId);
        if (favorite == null || favorite.getFavoriteList().isEmpty()) {
            throw new FavoriteEmptyException();
        }
        int total = favorite.getFavoriteList().size();
        favorite.setNoOfFavorites(total);
        return favorite;
    }

    @Override
    public void addFavoritesById(long userId, long movieId) {
        MovieDao moviedao = new MovieDaoCollectionImpl();
        Movie movie = moviedao.getMovieById(movieId);
        if (userFavorite.containsKey(userId)) {
            userFavorite.get(userId).getFavoriteList().add(movie);
        } else {
            Favorite favorite = new Favorite();
            List<Movie> movielist = new ArrayList<Movie>();
            movielist.add(movie);
            favorite.setFavoriteList(movielist);
            userFavorite.put(userId, favorite);
        }
    }

    @Override
    public void removeFavoritesById(long userId, long movieId) {
        List<Movie> favorite = userFavorite.get(userId).getFavoriteList();
        for (int i = 0; i < favorite.size(); i++) {
            if (favorite.get(i).getMovieId() == movieId) {
                favorite.remove(i);
                break;
            }
        }
    }
}
