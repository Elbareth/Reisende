<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
    <div style="background-image: url('/resources/ksiazka.jpg'); background-repeat: no-repeat; word-wrap: break-word;">
        <div class="w3-bar w3-black w3-card">
            <button class="w3-bar-item w3-button tablink" onclick="openLink(event, 'rozwiazane')">Zadania rozwiazane</button>
            <button class="w3-bar-item w3-button tablink" onclick="openLink(event, 'nierozwiazane')">Zadania nieroziwazane</button>
        </div>
        <div id="rozwiazane" class="w3-container opcja w3-animate-opacity" style="display:none">
            <h1>Zadania rozwiazane</h1>
            <table>
                <tr>
                    <td>Index</td>
                    <td>Nazwa</td>
                    <td>Tresc</td>
                    <td>Nagroda</td>
                </tr>
                <c:forEach var="element" items="${rozwiazaneZadania}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${rozwiazaneZadania[status.index].noweZadanie}</td>
                        <td>${rozwiazaneZadania[status.index].tresc}</td>
                        <td>${rozwiazaneZadania[status.index].nagroda}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="nierozwiazane" class="w3-container opcja w3-animate-opacity">
            <h1>Zadania nierozwiazane</h1>
            <table>
                <tr>
                    <td>Index</td>
                    <td>Nazwa</td>
                    <td>Tresc</td>
                    <td>Nagroda</td>
                </tr>
                <c:forEach var="element" items="${nierozwiazaneZadania}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${nierozwiazaneZadania[status.index].noweZadanie}</td>
                        <td>${nierozwiazaneZadania[status.index].tresc}</td>
                        <td>${nierozwiazaneZadania[status.index].nagroda}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <script>
        function openLink(evt, opcja){
             var i, x, tablinks;
             x = document.getElementsByClassName("opcja");
             for (i = 0; i < x.length; i++) {
                x[i].style.display = "none";
             }
             tablinks = document.getElementsByClassName("tablink");
             for (i = 0; i < x.length; i++) {
                tablinks[i].className = tablinks[i].className.replace(" w3-red", "");
             }
             document.getElementById(opcja).style.display = "block";
             evt.currentTarget.className += " w3-red";
        }
    </script>
</body>