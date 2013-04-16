<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kirja viitteet</title>
    </head>
    <body>
        <h1>Viite ${viite.id}</h1>
        
        <h2>Tyyppi</h2>
        <p>${viite.tyyppi}</p>
        
        <h2>Sisältö</h2>
        <p>
            <c:forEach var="attr" items="${viite.attribuutit}">
                ${attr.nimi} = ${attr.arvo}<br />
            </c:forEach>
        </p>
        
        <h2>Bibtex</h2>
        <p>
            <textarea cols="32" rows="12" id="parsed-output">${parsed}</textarea>
        </p>
        
        <p><a href="/home">Takaisin</a></p>
    </body>
</html>