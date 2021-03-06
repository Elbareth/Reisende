<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <body>
        <div class="main">
            <h1> Reisende - ranking </h1>
            <form action="/search" method="post">
                <c:if test="${not empty error}">
                    <div id="mymodal" class="alert alert-info">
                        <p>${error}</p>
                    </div>
                </c:if>
                <input type="text" placeholder = "Wyszukaj" name ="search"/><br/>
                <input type="submit" value="Wyszukaj"/>
            <form>
            <table>
                <tr>
                    <td><h3>Index</h3></td>
                    <td><h3>Login</h3></td>
                    <td><h3>Nick</h3></td>
                    <td><h3>Klasa postaci</h3></td>
                    <td><h3>Punkty doswiadczenia</h3></td>
                    <td><h3>Poziom</h3></td>
                    <td><h3>Napisz wiadomosc</h3></td>
                    <td><h3>Wyzwij na arene</h3></td>
                </tr>
            <c:forEach var="element" items="${uzytkownikLista}" varStatus="status">
            <c:choose>
                <c:when test="${login eq uzytkownikLista[status.index].login }">
                    <tr style="background-color: green;">
                        <td><h3>${(status.index)+((page*15)-14)}</h3></td>
                        <td><h3>${uzytkownikLista[status.index].login}</h3></td>
                        <td><h3>${uzytkownikLista[status.index].nick}</h3></td>
                        <td><h3>${uzytkownikLista[status.index].klasaPostaci}</h3></td>
                        <td><h3>${uzytkownikLista[status.index].doswiadczenie}</h3></td>
                        <td><h3>${uzytkownikLista[status.index].poziom}</h3></td>
                        <td><h3><a href="/odpiszWiadomosc/${uzytkownikLista[status.index].login}">Napisz wiadomosc</a></h3></td>
                        <td><h3><a href="">Wyzywam na arene</a></h3></td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td><h3>${(status.index)+((page*15)-14)}</h3></td>
                        <td><h3>${uzytkownikLista[status.index].login}</h3></td>
                        <td><h3>${uzytkownikLista[status.index].nick}</h3></td>
                        <td><h3>${uzytkownikLista[status.index].klasaPostaci}</h3></td>
                        <td><h3>${uzytkownikLista[status.index].doswiadczenie}</h3></td>
                        <td><h3>${uzytkownikLista[status.index].poziom}</h3></td>
                        <td><h3><a href="/odpiszWiadomosc/${uzytkownikLista[status.index].login}">Napisz wiadomosc</a></h3></td>
                        <td><h3><a href="">Wyzywam na arene</a></h3></td>
                    </tr>
                </c:otherwise>
            </c:choose>
            </c:forEach>
            </table>
            <div id="pagination">
                <c:url value="/ranking" var="prev">
                    <c:param name="page" value="${page-1}"/>
                </c:url>
                <c:if test="${page > 1}">
                    <h3><a href="<c:out value="${prev}" />" class="pn prev">Prev</a></h3>
                </c:if>

                <c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
                    <c:choose>
                        <c:when test="${page == i.index}">
                            <h3><span>${i.index}</span></h3>
                        </c:when>
                        <c:otherwise>
                            <c:url value="/ranking" var="url">
                                <c:param name="page" value="${i.index}"/>
                            </c:url>
                            <h3><a href='<c:out value="${url}" />'>${i.index}</a></h3>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:url value="/ranking" var="next">
                    <c:param name="page" value="${page + 1}"/>
                </c:url>
                <c:if test="${page + 1 <= maxPages}">
                    <h3><a href='<c:out value="${next}" />' class="pn next">Next</a></h3>
                </c:if>
            </div>
        </div>
