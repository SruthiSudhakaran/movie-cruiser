<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Movie List Admin</title>
<link rel="shortcut icon" href="images/logo.png" />
<link rel="stylesheet" type="text/css" href="styles/style.css" />
</head>
<body>
    <header> <label id="movie-cruiser">Movie Cruiser</label> <img id="movie-cruiser-img"
        src="images/logo.png" width="50" height="50" /> <nav> <a href="ShowMovieListAdmin">Movies</a>
    </nav> </header>
    <label id="heading">Movies</label>
    <table class="table">
        <col width="200"></col>
        <col width="75"></col>
        <col width="75"></col>
        <col width="125"></col>
        <col width="100"></col>
        <col width="100"></col>
        <col width="75"></col>
        <tr>
            <th align="left">Title</th>
            <th align="right">Box Office</th>
            <th align="center">Active</th>
            <th align="center">Date of Launch</th>
            <th align="center">Genre</th>
            <th align="center">Has Teaser</th>
            <th align="center">Action</th>
        </tr>
        <c:forEach var="movie" items="${movies}">
            <tr>
                <td align="left">${movie.getTitle()}</td>
                <td align="right">${movie.getBoxOffice()}</td>
                <c:choose>
                    <c:when test="${movie.isActive()==true}">
                        <td align="center"><c:out value="Yes"></c:out></td>
                    </c:when>
                    <c:otherwise>
                        <td align="center"><c:out value="No"></c:out></td>
                    </c:otherwise>
                </c:choose>
                <td align="center"><f:formatDate value="${movie.getDateOfLaunch()}"
                        pattern="dd/MM/yyyy" /></td>
                <td align="center">${movie.getGenre()}</td>
                <c:choose>
                    <c:when test="${movie.isHasTeaser()==true}">
                        <td align="center"><c:out value="Yes"></c:out></td>
                    </c:when>
                    <c:otherwise>
                        <td align="center"><c:out value="No"></c:out></td>
                    </c:otherwise>
                </c:choose>
                <td align="center"><a href="ShowEditMovie?movieId=${movie.getMovieId()}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
    <footer> <label id="copy-right">Copyright &copy; 2019</label> </footer>
</body>
</html>