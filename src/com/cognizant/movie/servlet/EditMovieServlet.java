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
import com.cognizant.movie.util.DateUtil;

@WebServlet("/EditMovie")
public class EditMovieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long movieId = Long.parseLong(request.getParameter("id"));
        String title = request.getParameter("title");
        long boxOffice = Long.parseLong(request.getParameter("boxOffice"));
        String isactive = request.getParameter("active");
        String dateOfLaunch = request.getParameter("dateOfLaunch");
        String genre = request.getParameter("genre");
        String isHasTeaser = request.getParameter("hasTeaser");

        boolean active = false;
        boolean hasTeaser = false;
        if (isactive.equals("No")) {
            active = false;
        } else {
            active = true;
        }
        if (isHasTeaser == null) {
            hasTeaser = false;
        } else {
            hasTeaser = true;
        }

        Movie movie = new Movie(movieId, title, boxOffice, active,
                DateUtil.convertToDate(dateOfLaunch), genre, hasTeaser);
        MovieDao movieDao = new MovieDaoCollectionImpl();
        movieDao.modifyMovieList(movie);
        request.getRequestDispatcher("edit-movie-status.jsp").forward(request, response);
    }

}
