<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

        <h2>Lisää (validi) henkilö</h2>
        <form:form commandName="henkilo" action="${pageContext.request.contextPath}/validi_henkilo" method="POST">
            Nimi: <form:input path="nimi" /><form:errors path="nimi" /><br/>
            Osoite: <form:input path="osoite" /><form:errors path="osoite" /><br/>
            Puhelinnumero: <form:input path="puhNumero" /><form:errors path="puhNumero" /><br/>
            <input type="submit" value="Lisää">            
        </form:form>

    </body>
</html>