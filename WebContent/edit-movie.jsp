<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit Movie</title>
<link rel="shortcut icon" href="images/logo.png" />
<link rel="stylesheet" type="text/css" href="styles/style.css" />
<script src="js/script.js"></script>
</head>
<body>
    <c:set var="movie" value="${movie}"></c:set>
    <header> <label id="movie-cruiser">Movie Cruiser</label> <img id="movie-cruiser-img"
        src="images/logo.png" width="50" height="50" /> <nav> <a href="ShowMovieListAdmin">Movies</a>
    </nav> </header>
    <label id="heading">Edit Movie</label>
    <form action="EditMovie" method="post" name="movieForm" onsubmit="return validateMovieForm()">
        <input type="hidden" name="id" value="${movie.getMovieId()}" />
        <table cellspacing="5">
            <tr>
                <th align="left"><label class="grey" for="name">Title</label></th>
            </tr>
            <tr>
                <td colspan="4"><input type="text" name="title" value="${movie.getTitle()}"
                    autocomplete="off" id="name" /></td>
            </tr>
            <tr></tr>
            <tr>
                <th align="left"><label class="grey" for="boxOffice">Gross ($)</label></th>
                <th align="left"><label class="grey" for="active">Active</label></th>
                <th align="left"><label class="grey" for="dol">Date of Launch</label></th>
                <th align="left"><label class="grey" for="cat">Genre</label></th>
            </tr>
            <tr>
                <td><input type="text" autocomplete="off" value="${movie.getBoxOffice()}"
                    name="boxOffice" id="box-office" /></td>
                <td><c:choose>
                        <c:when test="${movie.isActive()==true}">
                            <input type="radio" value="Yes" name="active" checked />Yes
                <input type="radio" value="No" name="active" />No
                </c:when>
                        <c:otherwise>
                            <input type="radio" value="Yes" name="active" />Yes
                <input type="radio" value="No" name="active" checked />No
                </c:otherwise>
                    </c:choose></td>
                <td><f:formatDate value="${movie.getDateOfLaunch()}" var="dateOfLaunch"
                        pattern="dd/MM/yyyy" /><input type="text" autocomplete="off"
                    value="${dateOfLaunch}" name="dateOfLaunch" id="date-of-launch" /></td>
                <td><select name="genre">
                        <option value="${movie.getGenre()}">${movie.getGenre()}</option>
                        <option value="science fiction">Science Fiction</option>
                        <option value="superhero">Superhero</option>
                        <option value="romance">Romance</option>
                        <option value="comedy">Comedy</option>
                        <option value="adventure">Adventure</option>
                        <option value="thriller">Thriller</option>
                </select></td>
            </tr>
            <tr></tr>
            <tr>
                <c:choose>
                    <c:when test="${movie.isHasTeaser()==true}">
                        <td colspan="4"><input type="checkbox" checked name="hasTeaser"
                            id="hasTeaser" /><label for="hasTeaser"><b class="grey">Has
                                    Teaser</b></label></td>
                    </c:when>
                    <c:otherwise>
                        <td colspan="4"><input type="checkbox" name="hasTeaser" id="hasTeaser" />
                            <label for="hasTeaser"><b class="grey">Has Teaser</b></label></td>
                    </c:otherwise>
                </c:choose>
            </tr>
            <tr>
                <td colspan="4"><input type="submit" value="Save" name="submit" id="submit" /></td>
            </tr>
        </table>
    </form>
    <footer> <label id="copy-right">Copyright &copy; 2019</label> </footer>
</body>
</html>