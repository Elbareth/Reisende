<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
    <div class="main" id="main">
        <h1>W tym miejscu mozesz sprzedac swoj zbedny orez</h1>
        <input type="submit" value="Kup" onclick="window.location.href = 'zbrojownia';"/>
        <input type="submit" value="Licytuj" onclick="window.location.href = 'licytujZbroje';"/>
        <input type="submit" value="Wystaw na sprzedaz" onclick="window.location.href = 'wystawZbroje';"/>
        <s:form action="/wystawZbroje" method="post" modelAttribute="zbroja" enctype="multipart/form-data">
            <h3>Nazwa przedmiotu: </h3>
            <form:select class="inp" path="nazwa">
                <form:options items="${mojaZbroja}"/>
            </form:select></br>
            <h3>Cena mininmalna: </h3>
            <s:input class="inp" required = "required" placeholder = "Wprowadz cene minimalna" path = "cena"/><br/>
            <input type="submit" value="Wystaw na aukcje"/></br>
        </s:form>
        <h1>Twoje aktualne aukcje</h1>
        </br>
        <table>
            <tr>
                <td>Wyglad</td>
                <td>Nazwa</td>
                <td>Cena</td>
                <td>Klasa</td>
                <td>Ilosc Licytujacych</td>
                <td>Data Zakonczenia</td>
                <td>Anuluj</td>
            </tr>
            <c:forEach var="element" items="${mojeAukcje}" varStatus="status">
                <tr title="${mojeAukcje[status.index].opis}">
                    <td><img src="/resources/${mojeAukcje[status.index].plik}"></td>
                    <td>${mojeAukcje[status.index].nazwa}</td>
                    <td>${mojeAukcje[status.index].aktualnaCena}</td>
                    <td>${mojeAukcje[status.index].klasa}</td>
                    <td>${mojeAukcje[status.index].iloscLicytujacych}</td>
                    <td>${mojeAukcje[status.index].dataZakonczenia}</td>
                    <td> <button onclick="anuluj('${mojeAukcje[status.index].nazwa}', '${mojeAukcje[status.index].aktualnaCena}', '${mojeAukcje[status.index].id}')"><img src="/resources/delete1.png"></button></td>
                </tr>
            </c:forEach>
        </table>
        <script>
            function anuluj(nazwa, cena, id){
                var json = {};
                json.nazwa = nazwa;
                json.cena = cena;
                var xhr = new XMLHttpRequest();
                xhr.open('DELETE', '/wystawZbroje/'+parseInt(id));
                xhr.setRequestHeader("Content-Type", "application/json");
                setTimeout(xhr.send(JSON.stringify(json)),5000);
                json = {};
                event.preventDefault();
            }
        </script>
    </div>
</body>