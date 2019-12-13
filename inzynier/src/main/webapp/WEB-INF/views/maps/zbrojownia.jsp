<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
    <div class="main" id ="main" style="width: 75em; margin-left: -200px;">
        <h1>Kup wybrany element zbroi:</h1>
        <input type="submit" value="Kup" onclick="window.location.href = 'zbrojownia';"/>
        <input type="submit" value="Licytuj" onclick="window.location.href = 'licytujZbroje';"/>
        <input type="submit" value="Wystaw na sprzedaz" onclick="window.location.href = 'wystawZbroje';"/>
        </br></br>
        <table>
            <tr>
                <td>Wyglad</td>
                <td>Nazwa</td>
                <td>Cena</td>
                <td>Klasa</td>
                <td>Typ</td>
                <td>Punkty Ataku</td>
                <td>Punkty Obrony</td>
                <td>Wymagany Poziom</td>
                <td>Punkty Doswiadczenia</td>
                <td>Kup</td>
            </tr>
            <c:forEach var="element" items="${listaZbroja}" varStatus="status">
                <tr>
                    <td> <img src="/resources/${listaZbroja[status.index].plik}"></td>
                    <td> ${listaZbroja[status.index].nazwa} </td>
                    <td> ${listaZbroja[status.index].punktyDoswiadczenia + 200} </td>
                    <td> ${listaZbroja[status.index].klasa} </td>
                    <td> ${listaZbroja[status.index].typ} </td>
                    <td> ${listaZbroja[status.index].punktyAtaku} </td>
                    <td> ${listaZbroja[status.index].punktyObrony} </td>
                    <td> ${listaZbroja[status.index].wymaganyPoziom} </td>
                    <td> ${listaZbroja[status.index].punktyDoswiadczenia} </td>
                    <td> <button onclick="kup('${uzytkownik.zloteMonety}', '${listaZbroja[status.index].nazwa}', '${listaZbroja[status.index].punktyDoswiadczenia + 200}')"> <img src="/resources/kup.png"> </button> </td>
                </tr>
            </c:forEach>
        </table>
        <div id="pagination" style="display: flex;">
            <c:url value="/zbrojownia" var="prev">
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
                    <c:url value="/zbrojownia" var="url">
                        <c:param name="page" value="${i.index}"/>
                    </c:url>
                        <h3><a href='<c:out value="${url}" />'>${i.index}</a></h3>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:url value="/zbrojownia" var="next">
                <c:param name="page" value="${page + 1}"/>
            </c:url>
            <c:if test="${page + 1 <= maxPages}">
                <h3><a href='<c:out value="${next}" />' class="pn next">Next</a></h3>
            </c:if>
        </div>
        <script>
            function kup(pieniadze, nazwa, cena){
                if(parseInt(pieniadze) < parseInt(cena)){
                    alert("Nie masz wystarczajacej ilosci pieniedzy");
                }
                else{
                    var json = {};
                    json.nazwa = nazwa;
                    json.cena = cena;
                    var xhr = new XMLHttpRequest();
                    xhr.open('POST', '/zbrojownia');
                    xhr.setRequestHeader("Content-Type", "application/json");
                    setTimeout(xhr.send(JSON.stringify(json)),5000);
                    json = {};
                    event.preventDefault();
                    alert("Wlasnie kupiles "+nazwa+". Znajdziesz ten przedmiot w ekwipunku");
                }
            }
        </script>
    </div>
</body>