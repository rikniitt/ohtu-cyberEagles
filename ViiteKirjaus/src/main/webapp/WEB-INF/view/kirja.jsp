<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kirjaviitekirjaus</title>
    </head>
    <body>
        
        <%@include file="mainnavi.jsp" %>
        
	<h1>Lisää kirjaviite</h1>
	<form method="POST" action="">
	  <label>ID: <input type="text" name="ID" /></label><p>
	  <label>Kirjailija: <input type="text" name="kirjailija" /></label><p>
	  <label>Titteli: <input type="text" name="titteli" /></label><p>
 	  <label>Vuosi: <input type="text" name="vuosi" /></label><p>
	  <label>julkaisija: <input type="text" name="julkaisija" /></label><p>
	  <label>osoite: <input type="text" name="osoite" /></label><p>
	  <input type="submit" />
	</form>
        
        <p>
            <pre id="parsed-output">${parsed}</pre> 
        </p>
        
        <p><a href="/home">Takaisin</a></p>
    </body>
</html>

