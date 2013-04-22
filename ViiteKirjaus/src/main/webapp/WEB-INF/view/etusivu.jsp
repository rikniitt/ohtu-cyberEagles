<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Etusivu</title>
    </head>
    <body>
        
 
        <%@include file="mainnavi.jsp" %>

        
        <h1 id="welcome-text">Arton viite kirjaus</h1>

        
        <h2>Kirja viitteet</h2>
        
        <p><a href="/listaaKaikki">generoi bibtex viitteet kaikista</a></p>
        

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


    </body>
</html>