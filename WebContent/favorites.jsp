<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Favorites</title>
<link rel="stylesheet" type="text/css" href="styles/style.css" />
<link rel="shortcut icon" href="images/logo.png" />
</head>
<body>
    <header> <label id="movie-cruiser">Movie Cruiser</label> <img id="movie-cruiser-img"
        src="images/logo.png" width="50" height="50" /> <nav> <a href="ShowMovieListCustomer">Movies</a>
    <a id="favorites" href="ShowFavorite">Favorites</a> </nav> </header>
    <label id="heading">Favorites</label>
    <c:if test="${removeFavoriteStatus==true}">
        <p class=item-status>Item Added Into Favorite Successfully</p>
    </c:if>
    <c:set var="favorite" value="${favorite}"></c:set>
    <table class="table">
        <col width="150"></col>
        <col width="100"></col>
        <col width="125"></col>
        <col width="75"></col>
        <tr>
            <th align="left">Title</th>
            <th align="right">Box Office</th>
            <th align="center">Genre</th>
            <th align="center"></th>
        </tr>
        <c:forEach items="${movie}" var="movie">
            <tr>
                <td align="left">${movie.getTitle()}</td>
                <td align="right"><f:setLocale value="en_US" /> <f:formatNumber
                        type="currency" value="${movie.getBoxOffice()}"></f:formatNumber></td>
                <td align="right">${movie.getGenre()}</td>

                <td align="center"><a href="RemoveFavorite?movieId=${movie.getMovieId()}">Delete</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
            <th>No of Favorites</th>
            <th>${favorite.getNoOfFavorites()}</th>
        </tr>
    </table>
    <footer> <label id="copy-right">Copyright &copy; 2019</label> </footer>
</body>
</html>