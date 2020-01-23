package com.cognizant.movie.model;

import java.util.List;

public class Favorite {
    private List<Movie> favoriteList;
    private int noOfFavorites;

    public Favorite() {
        super();
    }

    public Favorite(List<Movie> favoriteList, int total) {
        super();
        this.favoriteList = favoriteList;
        this.noOfFavorites = total;
    }

    public List<Movie> getFavoriteList() {
        return favoriteList;
    }

    public void setFavoriteList(List<Movie> favoriteList) {
        this.favoriteList = favoriteList;
    }
    
    public int getNoOfFavorites() {
        return noOfFavorites;
    }

    public void setNoOfFavorites(int noOfFavorites) {
        this.noOfFavorites = noOfFavorites;
    }

    @Override
    public String toString() {
        return "Favorite [favoriteList=" + favoriteList + ", noOfFavorites=" + noOfFavorites + "]";
    }

}
