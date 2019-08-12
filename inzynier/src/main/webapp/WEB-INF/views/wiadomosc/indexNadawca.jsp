<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <body>
        <div class="main">
            <h1> Reisende - Wiadomosci wyslane </h1>
            <a href="/wiadomosc"><input type="submit" value="Wiadomosci odebrane"/></a>
            <a href="/wiadomosciNadawca"><input type="submit" value="Wyslane wiadomosci"/></a>
            <a href=""><input type="submit" value="Napisz wiadomosc"/></a>
            <table>
                <tr>
                    <td><h3>Index</h3></td>
                    <td><h3>Odbiorca</h3></td>
                    <td><h3>Tytul</h3></td>
                    <td><h3>Data</h3></td>
                    <td><h3>Odpisz</h3></td>
                    <td><h3>Usun</h3></td>
                </tr>
            <c:forEach var="element" items="${wiadomosciList}" varStatus="status">
                    <tr>
                        <td><h3>${status.index+1}</h3></td>
                        <td><h3>${wiadomosciList[status.index].odbiorca}</h3></td>
                        <td><h3><a href="/otworz/${wiadomosciList[status.index].id}">${wiadomosciList[status.index].tytul}</a></h3></td>
                        <td><h3>${wiadomosciList[status.index].data}</h3></td>
                        <td><h3><a href="/delete/nadawca/${wiadomosciList[status.index].id}">X</a></h3></td>
                    </tr>
            </c:forEach>
            </table>
            <div id="pagination">
                <c:url value="/wiadomosciNadawca" var="prev">
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
                            <c:url value="/wiadomosciNadawca" var="url">
                                <c:param name="page" value="${i.index}"/>
                            </c:url>
                            <h3><a href='<c:out value="${url}" />'>${i.index}</a></h3>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:url value="/wiadomosciNadawca" var="next">
                    <c:param name="page" value="${page + 1}"/>
                </c:url>
                <c:if test="${page + 1 <= maxPages}">
                    <h3><a href='<c:out value="${next}" />' class="pn next">Next</a></h3>
                </c:if>
            </div>
        </div>