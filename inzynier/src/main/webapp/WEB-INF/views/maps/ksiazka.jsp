<body>
    <div style="background-image: url('/resources/ksiazka.jpg'); background-repeat: no-repeat; word-wrap: break-word;">
        <h1>Witaj w bibliotece!</h1>
        <h3>Masz do wyboru nastepujace ksiazki</h3>
        <c:forEach var="element" items="${ksiazki}" varStatus="status">
            <h3 onclick="">${ksiazki[status.index].nazwa}</h3>
            <div class="tresc" id="tresc">
                <h3 onclick="hide('${ksiazki[status.index].id}', 'tresc')">${ksiazki[status.index].tresc}</h3>
            </div>
        </c:forEach>
    </div>
    <script>
        function hide(id, drag){
            var json = {};
            json.ksiazka = id;
            var xhr = new XMLHttpRequest();
            xhr.open('POST', '/ksiazka');
            xhr.setRequestHeader("Content-Type", "application/json");
            setTimeout(xhr.send(JSON.stringify(json)),5000);
            json = {};
            var e = document.getElementById(drag);
            if(!e)return true;
            if(e.style.display=="none"){
                e.style.display="block"
            }
            else{
                e.style.display="none"
            }
            return true;
        }
    </script>
</body>