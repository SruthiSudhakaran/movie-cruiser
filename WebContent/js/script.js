function validateMovieForm() {

    var name = document.forms["movieForm"]["title"].value;
    var nameRegExp = (/^[a-zA-Z ]{2,100}$/);
    if (name == "") {
        alert("Title is required");
        return false;
    }
    if (!name.match(nameRegExp)) {
        alert("Title should have 2 to 100 characters");
        return false;
    }

    var gross = document.forms["movieForm"]["boxOffice"].value;
    if (gross == "") {
        alert("Box Office is required");
        return false;
    }
    if (isNaN(gross)) {
        alert("Box Office has to be a number");
        return false;
    }

    var dateOfLaunch = document.forms["movieForm"]["dateOfLaunch"].value;
    if (dateOfLaunch == "") {
        alert("Date of Launch is required");
        return false;
    }

    var genre = document.forms["movieForm"]["genre"].value;
    if (genre == "") {
        alert("Select one genre");
        return false;
    }

}
