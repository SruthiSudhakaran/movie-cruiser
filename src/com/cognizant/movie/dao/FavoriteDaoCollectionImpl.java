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
        Favorite fav = userFavorite.get(userId);
        if (fav == null || fav.getFavoriteList().isEmpty()) {
            throw new FavoriteEmptyException();
        }
        // List<Movie> favorite = fav.getFavoriteList();
        int total = fav.getFavoriteList().size();
        fav.setTotal(total);
        return fav;
    }

    @Override
    public void addFavoritesById(long userId, long movieId) {
        MovieDao mdao = new MovieDaoCollectionImpl();
        Movie movie = mdao.getMovieById(movieId);
        if (userFavorite.containsKey(userId)) {
            userFavorite.get(userId).getFavoriteList().add(movie);
        } else {
            Favorite fav = new Favorite();
            List<Movie> movielist = new ArrayList<Movie>();
            movielist.add(movie);
            fav.setFavoriteList(movielist);
            userFavorite.put(userId, fav);
        }
    }

    @Override
    public void removeFavoritesById(long userId, long movieId) {
        List<Movie> fav = userFavorite.get(userId).getFavoriteList();
        for (int i = 0; i < fav.size(); i++) {
            if (fav.get(i).getMovieId() == movieId) {
                fav.remove(i);
                break;
            }
        }
    }
}
