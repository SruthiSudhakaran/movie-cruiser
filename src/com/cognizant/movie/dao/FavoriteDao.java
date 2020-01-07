package com.cognizant.movie.dao;

import com.cognizant.movie.model.Favorite;

public interface FavoriteDao {
    public Favorite getAllFavorites(long userId) throws FavoriteEmptyException;

    public void addFavoritesById(long userId, long movieId);

    public void removeFavoritesById(long userId, long movieId);
}
