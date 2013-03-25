<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Henkilöhallinta</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h1>Henkilöhallinta</h1>

        <h2>Lisää henkilö</h2>
        <form action="henkilo/lisaa" method="p">
            Nimi: <input type="text" name="nimi"><br/>
            Osoite: <input type="text" name="osoite"><br/>
            Puhelinnumero: <input type="text" name="puhNumero"><br/>
            <input type="submit" value="Lisää">            
        </form>

        <h2>Henkilöt</h2>
        <ul>
            <c:forEach var="henkilo" items="${henkilot}">
                <li>${henkilo.nimi}, ${henkilo.osoite}, ${henkilo.puhNumero}, <a href="henkilo/poista/${henkilo.id}">poista</a></li>
            </c:forEach>
        </ul>
    </body>
</html>
