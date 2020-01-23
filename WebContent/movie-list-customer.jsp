<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Movie List Customer</title>
<link rel="shortcut icon" href="images/logo.png" />
<link rel="stylesheet" type="text/css" href="styles/style.css" />
</head>
<body>
    <header> <label id="movie-cruiser">Movie Cruiser</label> <img id="movie-cruiser-img"
        src="images/logo.png" width="50" height="50" /> <nav> <a href="ShowMovieListCustomer">Movies</a>
    <a id="favorites" href="ShowFavorite">Favorites</a> </nav> </header>
    <label id="heading">Movies</label>
    <c:if test="${addFavoriteStatus==true}">
        <p class=item-status>Item Added Into Favorite Successfully</p>
    </c:if>
    <table class="table">
        <col width="150"></col>
        <col width="100"></col>
        <col width="125"></col>
        <col width="100"></col>
        <col width="125"></col>
        <tr>
            <th align="left">Title</th>
            <th align="right">Box Office</th>
            <th align="center">Genre</th>
            <th align="center">Has Teaser</th>
            <th align="center">Action</th>
        </tr>
        <c:forEach items="${movie}" var="movie">
            <tr>
                <td align="left">${movie.getTitle()}</td>
                <td align="right"><f:setLocale value="en_US" /> <f:formatNumber
                        type="currency" value="${movie.getBoxOffice()}"></f:formatNumber></td>
                <td align="center">${movie.getGenre()}</td>
                <c:choose>
                    <c:when test="${movie.isHasTeaser()==true}">
                        <td align="center"><c:out value="Yes"></c:out></td>
                    </c:when>
                    <c:otherwise>
                        <td align="center"><c:out value="No"></c:out></td>
                    </c:otherwise>
                </c:choose>
                <td align="center"><a href="AddToFavorite?movieId=${movie.getMovieId()}">Add
                        to Favorite</a></td>
            </tr>
        </c:forEach>
    </table>
    <footer> <label id="copy-right">Copyright &copy; 2019</label> </footer>
</body>
</html>