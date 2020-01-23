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
import com.cognizant.movie.dao.MovieDao;
import com.cognizant.movie.dao.MovieDaoCollectionImpl;
import com.cognizant.movie.model.Movie;

@WebServlet("/AddToFavorite")
public class AddToFavoriteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long movieId = Long.parseLong(request.getParameter("movieId"));
        long userId = 1L;
        FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
        favoriteDao.addFavoritesById(userId, movieId);
        MovieDao movieDao = new MovieDaoCollectionImpl();
        List<Movie> movie = movieDao.getMovieListCustomer();
        request.setAttribute("addFavoriteStatus", true);
        request.setAttribute("movie", movie);
        request.getRequestDispatcher("movie-list-customer.jsp").forward(request, response);
    }

}
