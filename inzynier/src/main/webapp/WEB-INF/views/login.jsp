<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Reisende - strona glowna</title>
        <link rel="stylesheet" type="text/css" href="/resources/loginAndRegister.css">
        <link href="https://fonts.googleapis.com/css?family=Metal+Mania&display=swap" rel="stylesheet">
    </head>
    <body>
        <div class="main">
            <h1> Reisende - Strona logowania </h1>
            <c:if test="${not empty error}">
                <div id="mymodal" class="alert alert-info">
                    <p>${error}</p>
                </div>
            </c:if>
            <s:form action="/logowanie" method="post" modelAttribute="uzytkownik" enctype="multipart/form-data">
                <h3>Login:</h3> <s:input class="inp" required = "required" placeholder = "Wprowadz login" path = "login"/><br/>
                <h3>Haslo:</h3> <s:password class="inp" required = "required" placeholder = "Wprowadz haslo" path = "haslo"/><br/>
                <br/>
                <input type="submit" value="Zaloguj sie"/></br>
            </s:form>
             <h3> Nie posiadasz u nas jeszcze konta?</h3> <a href="/zarejestruj">Zarejestruj sie</a>
        </div>
    </body>
</html>