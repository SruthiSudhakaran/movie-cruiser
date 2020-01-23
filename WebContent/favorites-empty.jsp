<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Favorites Empty</title>
<link rel="stylesheet" type="text/css" href="styles/style.css" />
<link rel="shortcut icon" href="images/logo.png" />
</head>
<body>
    <header> <label id="movie-cruiser">Movie Cruiser</label> <img id="movie-cruiser-img"
        src="images/logo.png" width="50" height="50" /> <nav> <a href="ShowMovieListCustomer">Movies</a>
    <a id="favorites" href="ShowFavorite">Favorites</a> </nav> </header>
    <label id="heading">Favorites</label>
    <p id="favorites-p">
        <b>No items in Favorites. Use 'Add to Favorite' option in <a id="empty-favorite"
            href="ShowMovieListCustomer">Movie List</a>.
        </b>
    </p>
    <footer> <label id="copy-right">Copyright &copy; 2019</label> </footer>
</body>
</html>