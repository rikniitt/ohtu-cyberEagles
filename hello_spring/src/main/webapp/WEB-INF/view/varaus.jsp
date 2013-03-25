<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Varauspalvelu</title>        
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h1>Varauspalvelu</h1>

        <h2>Lisää henkilö huoneesen</h2>
        <form action="varaus/lisaa" method="POST">
            Huone: 
            <select name="huoneId">
                <c:forEach var="huone" items="${huoneet}">
                    <option value="${huone.id}">${huone.kerros}. kerros, kapasiteetti: ${huone.kapasiteetti}</option>
                </c:forEach>
            </select>
            <br />
            Henkilo: 
            <select name="henkiloId">
                <c:forEach var="henkilo" items="${henkilot}">
                    <option value="${henkilo.id}">${henkilo.nimi}</option>
                </c:forEach>
            </select>
            <br />
            <input type="submit" value="Lisää">            
        </form>

        <h2>Varaukset</h2>
        <ul>
            <c:forEach var="varaus" items="${varaukset}">
                <li>Huone: ${varaus.huoneId}. Henkilö ${varaus.henkiloId}, <a href="varaus/poista/${varaus.id}">poista</a></li>
            </c:forEach>
        </ul>
    </body>
</html>
