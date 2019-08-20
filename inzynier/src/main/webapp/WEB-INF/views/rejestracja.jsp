<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Reisende - rejestracja</title>
        <link rel="stylesheet" type="text/css" href="/resources/loginAndRegister.css">
        <link href="https://fonts.googleapis.com/css?family=Metal+Mania&display=swap" rel="stylesheet">
    </head>
    <body>
        <div class="main">
            <h1> Reisende - Rejestracja </h1>
            <c:if test="${not empty error}">
                <div id="mymodal" class="alert alert-info">
                    <p>${error}</p>
                </div>
            </c:if>
            <s:form action="/register" method="post" modelAttribute="uzytkownik" enctype="multipart/form-data">
                <h3>Login:</h3> <s:input class="inp" required = "required" placeholder = "Wprowadz login" path = "login"/><br/>
                <h3>Haslo:</h3> <s:password class="inp" required = "required" placeholder = "Wprowadz haslo" path = "haslo"/><br/>
                <h3>Nick:</h3> <s:input class="inp" required = "required" placeholder = "Wprowadz nick" path = "nick"/><br/>
                <h3>Wybierz klase postaci:</h3>
                <tr>
                   <td> <img src="/resources/mag.PNG"/> </td>
                   <td><form:radiobutton value="Mag" path="klasaPostaci" label="Mag"/> <td>
                </tr>
                <tr>
                    <td> <img src="/resources/wojownik.png"/> </td>
                    <td><form:radiobutton value="Wojownik" path="klasaPostaci" label="Wojownik"/></td>
                </tr>
                <tr>
                    <td> <img src="/resources/lotrzyk.png"/> </td>
                    <td> <form:radiobutton value="Lotrzyk" path="klasaPostaci" label="Lotrzyk"/></td><br/>
                </tr>
                <h3>Wybierz plec postaci:</h3>
                <form:radiobutton value="K" path="plec" label="K"/>
                <form:radiobutton value="M" path="plec" label="M"/><br/>
                <br/>
                <input type="submit" value="Zarejestruj"/></br>
            </s:form>
        </div>
    </body>
</html>