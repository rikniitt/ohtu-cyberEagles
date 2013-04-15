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
        <h1>Kirja viitteet</h1>

        <table>
            <thead>
                <tr>
                    <td>Tyyppi</td>
                    <td>Sisältö</td>    
                    <td>ID</td>    
                </tr>
            </thead>
            <tbody>
                <c:forEach var="viite" items="${viitteet}">
                    
                    
                    <tr>
                        <td>${viite.tyyppi}</td>
                        <td>
                            <c:forEach var="attr" items="${viite.attribuutit}">
                                ${attr.nimi} = ${attr.arvo}<br />
                            </c:forEach>
                        </td>
                        <td><a href="viite/${viite.id}" >Näytä</a></td>
                    </tr>
                   
                 </c:forEach>
            </tbody>
                
        </table>

        
        <p><a href="/home">Takaisin</a></p>
    </body>
</html>