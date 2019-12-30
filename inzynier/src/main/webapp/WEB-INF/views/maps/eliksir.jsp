<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
    <div class="main">
        <h1>Wazenie Eliksirow</h1>
        <table>
            <tr>
                <td>Nazwa</td>
                <td>Wyglad</td>
                <td>Cena</td>
                <td>Potrzebne skladniki</td>
                <td>Kup</td>
            </tr>
            <c:forEach var="element" items="${eliksir}" varStatus="status">
                <tr title="${eliksir[status.index].wlasciwosci}">
                    <td>${eliksir[status.index].nazwa}</td>
                    <td><img src="/resources/${eliksir[status.index].plik}"></td>
                    <td>${eliksir[status.index].cena}</td>
                    <td>${eliksir[status.index].przepis}</td>
                    <td><button onclick="kup(${eliksir[status.index]})"><img src="/resources/mlotek.png"></button></td>
                </tr>
            </c:forEach>
        </table>
        <h3>Ty posiadasz nastepujace skladniki</h3>
        <table>
            <tr>
                <td>Nazwa</td>
                <td>Ilosc</td>
            </tr>
            <c:forEach var="element" items="${wlasciciel}" varStatus="status">
                <tr>
                    <td>${wlasciciel[status.index].nazwa}</td>
                    <td>${wlasciciel[status.index].ilosc}</td>
                </tr>
            </c:forEach>
        </table>
        <script>
            function kup(eliksir){
                console.log("Tu");
                var allRight = {};
                var skladniki = eliksir.przepis.split(",");
                skladniki.forEach(function(it){
                    var liczba = it.match(/\d+/g).map(Number);
                    var nazwa = it.replace(/[0-9]/g, '');
                    "${wlasciciel}".forEach(function(at){
                        if(nazwa == at.nazwa && liczba <= at.ilosc){
                            allRight.push(true);
                        }
                    });
                });
                if(parseInt("${uzytkownik.zloteMonety}") <= parseInt(eliksir.cena)){
                    alert("Nie masz wystarczajacej ilosci pieniedzy");
                }
                else if(allRight.length < skladniki.length){
                    alert("Nie masz wszystkich wymaganych skladnikow");
                }
                else{
                    var xhr = new XMLHttpRequest();
                    xhr.open('POST', '/eliksir');
                    xhr.setRequestHeader("Content-Type", "application/json");
                    setTimeout(xhr.send(JSON.stringify(eliksir)),5000);
                }
            }
        </script>
    </div>
</body>