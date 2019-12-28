function validateForm() {
  var uname = document.forms["loginForm"]["uname"].value;
  var pass = document.forms["loginForm"]["pass"].value;
  if (uname == "" || uname == null) {
    alert("Enter Username");
    return false;
  }
  else if (pass == "" || pass == null) {
	    alert("Enter Password");
	    return false;
  }
}