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
        
        <%@include file="mainnavi.jsp" %>
        
        <h2>Kaikki viitteet</h2>
        <p>
            <textarea cols="32" rows="12" id="parsed-output">${all}</textarea>
        </p>
        
        <p><a href="/home">Takaisin</a></p>
    </body>
</html>