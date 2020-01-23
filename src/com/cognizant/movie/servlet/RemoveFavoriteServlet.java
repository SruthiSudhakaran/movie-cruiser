package com.cognizant.movie.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.dao.FavoriteDao;
import com.cognizant.movie.dao.FavoriteDaoCollectionImpl;
import com.cognizant.movie.dao.FavoriteEmptyException;
import com.cognizant.movie.model.Favorite;
import com.cognizant.movie.model.Movie;

@WebServlet("/RemoveFavorite")
public class RemoveFavoriteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            long userId = 1L;
            FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
            long movieId = Long.parseLong(request.getParameter("movieId"));
            favoriteDao.removeFavoritesById(userId, movieId);
            Favorite favorite = favoriteDao.getAllFavorites(userId);
            List<Movie> movieList = favorite.getFavoriteList();
            int noOfFavorites = 0;
            noOfFavorites = favorite.getFavoriteList().size();
            favorite.setNoOfFavorites(noOfFavorites);
            request.setAttribute("movie", movieList);
            request.setAttribute("favorite", favorite);
            request.setAttribute("removeFavoriteStatus", true);
            request.getRequestDispatcher("favorites.jsp").forward(request, response);
        } catch (FavoriteEmptyException e) {
            request.getRequestDispatcher("favorites-empty.jsp").forward(request, response);
        }
    }

}
