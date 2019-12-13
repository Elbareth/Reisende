<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
    <div class="main" id="main" style="width: 75em; margin-left: -200px;">
        <h1>Licytacje</h1>
        <input type="submit" value="Kup" onclick="window.location.href = 'zbrojownia';"/>
        <input type="submit" value="Licytuj" onclick="window.location.href = 'licytujZbroje';"/>
        <input type="submit" value="Wystaw na sprzedaz" onclick="window.location.href = 'wystawZbroje';"/>
        <c:if test="${not empty error}">
            <div id="mymodal" class="alert alert-info">
                <p style="color: red;">${error}</p>
            </div>
        </c:if>
        <table>
            <tr>
                <td>Wyglad</td>
                <td>Nazwa</td>
                <td>Aktualna Cena</td>
                <td>Twoja Cena</td>
                <td>Klasa</td>
                <td>Ilosc Licytujacych</td>
                <td>Data Zakonczenia</td>
                <td>Licytuj</td>
            </tr>
            <c:forEach var="element" items="${listaKuznia}" varStatus="status">
                <s:form action="/licytujZbroje/${listaKuznia[status.index].id}" method="post" modelAttribute="licytuj" enctype="multipart/form-data">
                    <td><img src="/resources/${listaKuznia[status.index].plik}"</td>
                    <td>${listaKuznia[status.index].nazwa}</td>
                    <td>${listaKuznia[status.index].aktualnaCena}</td>
                    <td><s:input id="${listaKuznia[status.index].id}" style="width: 50px; color: black;" class="inp" required = "required" placeholder = "Twoja cena" path = "cena"/></td>
                    <td>${listaKuznia[status.index].klasa}</td>
                    <td>${listaKuznia[status.index].iloscLicytujacych}</td>
                    <td>${listaKuznia[status.index].dataZakonczenia}</td>
                    <td><button type="submit"><img src="/resources/mlotek.png"></button></td>
                </s:form>
            </c:forEach>
        </table>
        <div id="pagination" style="display: flex;">
            <c:url value="/licytujZbroje" var="prev">
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
                        <c:url value="/licytujZbroje" var="url">
                            <c:param name="page" value="${i.index}"/>
                        </c:url>
                            <h3><a href='<c:out value="${url}" />'>${i.index}</a></h3>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:url value="/licytujZbroje" var="next">
                <c:param name="page" value="${page + 1}"/>
            </c:url>
            <c:if test="${page + 1 <= maxPages}">
                <h3><a href='<c:out value="${next}" />' class="pn next">Next</a></h3>
            </c:if>
        </div>
    </div>
</body>%>