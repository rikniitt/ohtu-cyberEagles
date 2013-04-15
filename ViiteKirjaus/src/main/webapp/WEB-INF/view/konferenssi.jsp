<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>konferenssiviitteen lisäys</title>
    </head>
    <body>
	<h1>Lisää konferenssiviite</h1>
	<form method="POST" action="">
	  <label>ID: <input type="text" name="ID" /></label><p>
	  <label>Kirjoittaja: <input type="text" name="author" /></label><p>
	  <label>Otsikko: <input type="text" name="title" /></label><p>
          <label>Kirjaotsikko: <input type="text" name="booktitle" /></label><p>
 	  <label>Vuosi: <input type="text" name="year" /></label><p>
 	  <label>Sivut: <input type="text" name="pages" /></label><p>
 	  <label>Osoite: <input type="text" name="address" /></label><p>
	  <input type="submit" name="add" value="Lisää" />
	</form>
        
        <p>
            <pre id="parsed-output">${parsed}</pre> 
        </p>
        
        <p><a href="/home">Takaisin</a></p>
    </body>
</html>

