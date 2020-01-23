package com.cognizant.movie.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.dao.MovieDao;
import com.cognizant.movie.dao.MovieDaoCollectionImpl;
import com.cognizant.movie.model.Movie;

@WebServlet("/ShowEditMovie")
public class ShowEditMovieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long movieId = Long.parseLong(request.getParameter("movieId"));
        MovieDao movieDao = new MovieDaoCollectionImpl();
        Movie movie = movieDao.getMovieById(movieId);
        request.setAttribute("movie", movie); // it has only one movie info
        request.getRequestDispatcher("edit-movie.jsp").forward(request, response);
    }

}
