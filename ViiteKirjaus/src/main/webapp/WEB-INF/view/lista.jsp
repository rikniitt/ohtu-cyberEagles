<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <td>ID</td>
                    <td>Kirjoittaja</td>    
                    <td>Nimi</td>    
                    <td>Vuosi</td>    
                    <td>Julkaisija</td>    
                </tr>
            </thead>
            <tbody>
                <c:forEach var="kirja" items="${kirjat}">
                    <tr>
                        <td>${kirja.ID}</td>
                        <td>${kirja.kirjoittaja}</td>
                        <td>${kirja.nimi}</td>
                        <td>${kirja.vuosi}</td>
                        <td>${kirja.julkaisija}</td>
                    </tr>
                   
                 </c:forEach>
            </tbody>
                
        </table>

        </ul
    </body>
</html>