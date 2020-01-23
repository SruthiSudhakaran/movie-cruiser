package com.cognizant.movie.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.dao.MovieDao;
import com.cognizant.movie.dao.MovieDaoCollectionImpl;
import com.cognizant.movie.model.Movie;

@WebServlet("/ShowMovieListCustomer")
public class ShowMovieListCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MovieDao movieDao = new MovieDaoCollectionImpl();
        List<Movie> movie = movieDao.getMovieListCustomer();
        request.setAttribute("movie", movie);
        request.getRequestDispatcher("movie-list-customer.jsp").forward(request, response);
    }

}
