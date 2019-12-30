<%@ page language="java"%>
<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="com.example.inzynier.BasicService.PozycjaPostaci" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<body>
    <div class="main" id ="main">
        <div class="map">
            <div class="my-custom-scrollbar my-custom-scrollbar-primary" id="my-custom-scrollbar">
                <script>
                    function center(lewy, gora){
                        var element = document.getElementById('my-custom-scrollbar');
                        element.scrollTop = gora - 300;
                        element.scrollLeft = lewy - 375;
                    }
                </script>
                <div class="innerMap" id="innerMap">
                    <img id="mapka" style ="position: relative; left: 0; top: 0;" src="/resources/${plansza}" onloadstart="center(${lewo}, ${gora})"/>
                    <img div="postac" id="postac" style ="position: absolute; left: ${lewo}; top: ${gora};" src="/resources/me.png"/>
                    <c:forEach var="element" items="${listInside}" varStatus="status">
                        <img id ="${listInside[status.index].plik}" src="/resources/${listInside[status.index].plik}" style="position: absolute; left: ${listInside[status.index].polozenieX}; top: ${listInside[status.index].polozenieY};"/>
                    </c:forEach>
                    <c:forEach var="element" items="${listOnClick}" varStatus="status">
                        <button onclick="wDomu('${listOnClick[status.index].plik}')" id ="${listOnClick[status.index].plik}" ><img src="/resources/${listOnClick[status.index].plik}" style="position: absolute; left: ${listOnClick[status.index].polozenieX}; top: ${listOnClick[status.index].polozenieY};"></button>
                    </c:forEach>
                    <c:forEach var="element" items="${listaPostaci}" varStatus="status">
                        <button onclick="dialog('${listaPostaci[status.index].plik}', '')" id ="${listaPostaci[status.index].plik}" ><img src="/resources/${listaPostaci[status.index].plik}" style="position: absolute; left: ${listaPostaci[status.index].polozenieX}px; top: ${listaPostaci[status.index].polozenieY}px;"></button>
                        <c:if test="${not empty dialog}">
                            <div class="dymek" style="position: absolute; left: ${listaPostaci[status.index].polozenieX - 500}px; top: ${listaPostaci[status.index].polozenieY - 300}px; background-image: url('/resources/chmurka.png'); height: 500px;  background-repeat: no-repeat;">
                                <c:set var="dialogParts" value="${fn:split(dialog, '/')}" />
                                <c:forEach var="element2" items="${dialogParts}" varStatus="status2">
                                    <button onclick="dialog('${listaPostaci[status.index].plik}','${dialogParts[status2.index]}')" style="width: 400px; word-wrap: break-word; top: ${(status2.index + 1) * 100}px; left: 100px; position: relative; font-weight: bold;">${dialogParts[status2.index]}</button>
                                    <c:if test="${listaPostaci[status.index].plik == 'widzmaJagma.png' || listaPostaci[status.index].plik == 'zielarka.png'}">
                                        <button onclick="window.location.href = 'eliksir';" style="width: 400px; word-wrap: break-word; top: ${(status2.index + 1) * 100}px; left: 100px; position: relative; font-weight: bold;">Ty: Chce uwazyc eliksir</button>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </c:if>
                    </c:forEach>
                    <c:forEach var="element" items="${rosliny}" varStatus="status">
                       <c:forEach var="element2" items="${rosliny[status.index].plansza}" varStatus="status2">
                            <img id="${(status.index+1)*(status2.index+1)}" src="/resources/${rosliny[status.index].plik}"  onclick="ziola('${(status.index+1)*(status2.index+1)}', '${rosliny[status.index].plik}')" style="position: absolute; left: ${rosliny[status.index].polozenieX[status2.index]}px; top: ${rosliny[status.index].polozenieY[status2.index]}px;"/>
                       </c:forEach>
                    </c:forEach>
                    <c:forEach var="element" items="${bestie}" varStatus="status">
                        <c:forEach var="element2" items="${bestie[status.index].plansza}" varStatus="status2">
                            <img id="${(status.index+1)*(status2.index+1)}" src="/resources/${bestie[status.index].plik}"  onclick="alert('bestia');" style="position: absolute; left: ${bestie[status.index].polozenieX[status2.index]}px; top: ${bestie[status.index].polozenieY[status2.index]}px;"/>
                        </c:forEach>
                    </c:forEach>
                </div>
            </div>
        </div>
        <script type="text/javascript" >
            var onlyOnce = true;
            function ziola(index, plik){
                console.log(index);
                document.getElementById(index).style.visibility = "hidden";
                var json = {};
                json.roslina = plik;
                var xhr = new XMLHttpRequest();
                xhr.open('POST', '/maps/roslina');
                xhr.setRequestHeader("Content-Type", "application/json");
                setTimeout(xhr.send(JSON.stringify(json)),5000);
                json = {};
                event.preventDefault();
                setTimeout(function(){
                    document.getElementById(index).style.visibility = "visible";
                },1200000);
            }
            function dialog(plik, dialog){
                if(dialog == "Ty: Witaj! Chce wypozyczyc ksiazke"){
                   window.location.href = 'ksiazka';
                }
                else if(dialog == "Ty: Tak" && plik == "pokerzysta.png"){
                    window.location.href = 'gra';
                }
                var json = {};
                console.log(plik);
                json.postac = plik;
                json.dialog = dialog;
                var xhr = new XMLHttpRequest();
                xhr.open('POST', '/maps/dialog');
                xhr.setRequestHeader("Content-Type", "application/json");
                setTimeout(xhr.send(JSON.stringify(json)),5000);
                json = {};
                event.preventDefault();
                setTimeout(function(){location.reload(true);}, 1000);
            }
            function createJsonSurowe(json){
                json.drewno =  ${uzytkownik.drewno};
                json.glina = ${uzytkownik.grudkaGliny};
                json.zelazo = ${uzytkownik.grudkaZelaza};
                json.zboze = ${uzytkownik.worekZboza};
                json.deski = ${uzytkownik.deski};
                json.cegla = ${uzytkownik.cegly};
                json.sztabkaZelaza = ${uzytkownik.sztabkaZelaza};
                json.chleb = ${uzytkownik.chleb};
                json.studnia = ${uzytkownik.pragnienie};
            }
            function sendSurowce(json){
                var xhr = new XMLHttpRequest();
                xhr.open('PUT', '/maps');
                xhr.setRequestHeader("Content-Type", "application/json");
                setTimeout(xhr.send(JSON.stringify(json)),5000);
                json = {};
                event.preventDefault();
            }
            function wDomu(plik){
                var json = {};
                if(plik == "lasDrewno.png"){
                   createJsonSurowe(json);
                   json.drewno =  ${uzytkownik.drewno} + 1;
                   sendSurowce(json);
                }
                if(plik == "kopalniaGliny.png"){
                    createJsonSurowe(json);
                    json.glina =  ${uzytkownik.grudkaGliny} + 1;
                    sendSurowce(json);
                }
                if(plik == "kopalniaZelaza.png"){
                    createJsonSurowe(json);
                    json.zelazo =  ${uzytkownik.grudkaZelaza} + 1;
                    sendSurowce(json);
                }
                if(plik == "poleZboza.png"){
                    createJsonSurowe(json);
                    json.zboze =  ${uzytkownik.worekZboza} + 1;
                    sendSurowce(json);
                }
                if(plik == "tartak.png"){
                    createJsonSurowe(json);
                    json.deski =  ${uzytkownik.deski} + 1;
                    sendSurowce(json);
                }
                if(plik == "cegielnia.png"){
                    createJsonSurowe(json);
                    json.cegla =  ${uzytkownik.cegly} + 1;
                    sendSurowce(json);
                }
                if(plik == "kuznia.png"){
                    createJsonSurowe(json);
                    json.sztabkaZelaza =  ${uzytkownik.sztabkaZelaza} + 1;
                    sendSurowce(json);
                }
                if(plik == "piekarnia.png"){
                    createJsonSurowe(json);
                    json.chleb =  ${uzytkownik.chleb} + 1;
                    sendSurowce(json);
                }
                if(plik == "studnia.png"){
                    createJsonSurowe(json);
                    json.studnia =  ${uzytkownik.pragnienie} + 1;
                    sendSurowce(json);
                }
                if(plik == "targ.png"){
                    window.location.href = "targ";
                }
                if(plik == "zbrojownia.png"){
                    window.location.href = "zbrojownia";
                }
            }
            function zaspokajaniePotrzeb(glod, pragnienie, sen, higiena){
                glod = parseInt(${uzytkownik.glod}) + (parseInt(glod) % 100);
                pragnienie = parseInt(${uzytkownik.pragnienie}) + (parseInt(pragnienie) % 100);
                sen = parseInt(${uzytkownik.sen}) + (parseInt(sen) % 100);
                higiena = parseInt(${uzytkownik.higiena}) + (parseInt(higiena) % 100);
                var json = {};
                var xhr = new XMLHttpRequest();
                xhr.open('PATCH', '/maps');
                xhr.setRequestHeader("Content-Type", "application/json");
                json.glod = glod;
                json.pragnienie = pragnienie;
                json.sen = sen;
                json.higiena = higiena;
                setTimeout(xhr.send(JSON.stringify(json)),5000);
                json = {};
                event.preventDefault();
            }
            function insideHouse(lewo, gora, json){
                //wyjatkowa sytuacja w przypadku domku Asi i mojego domu
                nameOfInsideHome = ["asgardWnetrze.jpg", "bibliotekaWnetrze.jpg", "chataJagmyWnetrze.jpg", "domekAsiWnetrze.jpg","domekMalgosiWnetrze.jpg", "chataZielarkiWnetrze.jpg", "domKolekcjoneraWnetrze.jpg", "jaskiniaWnetrze.jpg", "kopalniaWnetrze.jpg", "kryptaWampiraWnetrze.jpg", "mojDomekWnetrze.jpg", "podwodnaGrotaWnetrze.jpg", "pubWnetrze.jpg", "ratuszWnetrze.jpg","wiezaAstronomicznaWnetrze.jpg","wiezaCzarodziejaWnetrze.jpg", "krawiecWnetrze.jpg"];
                if("${plansza}" == "mojDomekWnetrze.jpg"){
                    var map = document.getElementById('innerMap');
                    <c:forEach var="element" items="${listaMebliDoWyswietlenia}" varStatus="status">
                        map.innerHTML = map.innerHTML + "<img src='${listaMebliDoWyswietlenia[status.index].plik}' id ='${listaMebliDoWyswietlenia[status.index].plik}' class='meble' style ='position: absolute; left: ${listaMebliDoWyswietlenia[status.index].wymiarX}px; top: ${listaMebliDoWyswietlenia[status.index].wymiarY}px;' onclick='zaspokajaniePotrzeb(${listaMebliDoWyswietlenia[status.index].glod}, ${listaMebliDoWyswietlenia[status.index].pragnienie}, ${listaMebliDoWyswietlenia[status.index].sen}, ${listaMebliDoWyswietlenia[status.index].higiena})'/>"
                    </c:forEach>
                }
                if("${plansza}" == "domekAsiWnetrze.jpg" || "${plansza}" == "domekAsiWnetrze3.jpg"){
                    if(parseInt(lewo) >= 527 && parseInt(lewo) <= 610 && parseInt(gora) >= 160 && parseInt(gora) <= 242){
                        json.plansza = "domekAsiWnetrze2.jpg";
                        json.top = 110;
                        location.reload(true);
                    }
                }
                if("${plansza}" == "domekAsiWnetrze2.jpg"){
                    if(parseInt(lewo) >= 527 && parseInt(lewo) <= 610 &&parseInt(gora) >= 160 && parseInt(gora) <= 200){
                        json.plansza = "domekAsiWnetrze3.jpg";
                        json.top = 110;
                        location.reload(true);
                    }
                    if(parseInt(lewo) >= 527 && parseInt(lewo) <= 610 &&parseInt(gora) >= 200 && parseInt(gora) <= 242){
                        json.plansza = "domekAsiWnetrze.jpg";
                        json.top = 110;
                        location.reload(true);
                    }
                }
                if(nameOfInsideHome.indexOf("${plansza}") > -1){
                    if(parseInt(lewo) <= 49 || parseInt(lewo) >= 650 || parseInt(gora) <= 49 || parseInt(gora) >= 480){
                        json.plansza = "${plansza}".replace("Wnetrze.jpg",".png");
                        location.reload(true);
                    }
                }
                else{
                    <c:forEach var="element" items="${listInside}" varStatus="status">
                        var wymiar = "${listInside[status.index].wymiary}".split("x");
                        if(parseInt("${listInside[status.index].polozenieX}") <= parseInt(lewo) && (parseInt("${listInside[status.index].polozenieX}") + parseInt(wymiar[0])) >= parseInt(lewo) && parseInt("${listInside[status.index].polozenieY}") <= parseInt(gora) && (parseInt("${listInside[status.index].polozenieY}") + parseInt(wymiar[1])) >= parseInt(gora)){
                            json.plansza = "${listInside[status.index].plik}".replace(".png","Wnetrze.jpg");
                            json.left = 50;
                            json.top = 50;
                            location.reload(true);
                        }
                    </c:forEach>
                 }
            }
            function listener(event){
                var json = {};
                var xhr = new XMLHttpRequest();
                xhr.open('POST', '/maps');
                xhr.setRequestHeader("Content-Type", "application/json");
                switch(event.key){
                    case 'ArrowLeft':
                        var stojWMiejscu = true;
                        document.getElementById("postac").style.left =  ${lewo} - 10;
                        document.getElementById("postac").style.top =  ${gora};
                        if(${lewo} <= 20){
                            document.getElementById("postac").style.left =  ${lewo};
                            stojWMiejscu = false;
                        }
                        json.left = document.getElementById("postac").style.left;
                        json.top = document.getElementById("postac").style.top;
                        json.plansza = "${plansza}";
                        insideHouse(document.getElementById("postac").style.left, document.getElementById("postac").style.top, json);
                        setTimeout(xhr.send(JSON.stringify(json)),5000);
                        $('#postac').empty().load(window.location.href + '#postac');
                        json = {};
                        event.preventDefault();
                        document.removeEventListener('keydown', listener);
                        if(${lewo} - 10 <= 49 && stojWMiejscu){
                            location.reload(true);
                        }
                        break;
                    case 'ArrowRight':
                        var stojWMiejscu = true;
                        document.getElementById("postac").style.left =  ${lewo} + 10;
                        document.getElementById("postac").style.top =  ${gora};
                        if(${lewo} >= 2580){
                            document.getElementById("postac").style.left =  ${lewo};
                            stojWMiejscu = false;
                        }
                        json.left = document.getElementById("postac").style.left;
                        json.top = document.getElementById("postac").style.top;
                        json.plansza = "${plansza}";
                        insideHouse(document.getElementById("postac").style.left, document.getElementById("postac").style.top, json);
                        setTimeout(xhr.send(JSON.stringify(json)),5000);
                        $('#postac').empty().load(window.location.href + '#postac');
                        json = {};
                        event.preventDefault();
                        document.removeEventListener('keydown', listener);
                        if(${lewo} + 10 >= 2500 && stojWMiejscu){
                            location.reload(true);
                        }
                        break;
                    case 'ArrowUp':
                        var stojWMiejscu = true;
                        document.getElementById("postac").style.left =  ${lewo};
                        document.getElementById("postac").style.top =  ${gora} - 10;
                        if(${gora} <= 20){
                            document.getElementById("postac").style.top =  ${gora};
                            stojWMiejscu = false;
                        }
                        json.left = document.getElementById("postac").style.left;
                        json.top = document.getElementById("postac").style.top;
                        json.plansza = "${plansza}";
                        insideHouse(document.getElementById("postac").style.left, document.getElementById("postac").style.top, json);
                        setTimeout(xhr.send(JSON.stringify(json)),5000);
                        $('#postac').empty().load(window.location.href + '#postac');
                        json = {};
                        event.preventDefault();
                        document.removeEventListener('keydown', listener);
                        if(${gora} - 10 <= 49 && stojWMiejscu){
                            location.reload(true);
                        }
                        break;
                    case 'ArrowDown':
                        var stojWMiejscu = true;
                        document.getElementById("postac").style.left =  ${lewo};
                        document.getElementById("postac").style.top =  ${gora} + 10;
                        if(${gora} >= 1920){
                            document.getElementById("postac").style.top =  ${gora};
                            stojWMiejscu = false;
                        }
                        json.left = document.getElementById("postac").style.left;
                        json.top = document.getElementById("postac").style.top;
                        json.plansza = "${plansza}";
                        insideHouse(document.getElementById("postac").style.left, document.getElementById("postac").style.top, json);
                        setTimeout(xhr.send(JSON.stringify(json)),5000);
                        $('#postac').empty().load(window.location.href + '#postac');
                        json = {};
                        event.preventDefault();
                        document.removeEventListener('keydown', listener);
                        if(${gora} + 10 >= 1900 && stojWMiejscu){
                            location.reload(true);
                        }
                        break;
                }
            }
            if(document.addEventListener){
                document.addEventListener('keydown', listener, false);
            }
        </script>
    <div class="info">
    <style>
        table {
            border: transparent;
        }
        th{
            border: transparent;
        }
        td{
            border: transparent;
        }
        tr{
            border: transparent;
        }
        p{
            color: black;
        }
        .main{
            height: 60em;
        }
    </style>
    <h3 style="font-weight: bold; color: black;">Witaj ${uzytkownik.login}!</h3>
        <button onclick="window.location.href = 'zadania'"><img src="/resources/zadania.png"</button>
        <table>
                <tr>
                    <td>
                        Glod:
                         <div class="w3-light-grey w3-round">
                          <div class="w3-container w3-round w3-blue" style="width:${uzytkownik.glod}%; height: 20px;">${uzytkownik.glod}%</div>
                        </div>
                    </td>
                    <td>
                        Pragnienie:
                        <div class="w3-light-grey w3-round">
                            <div id="pragnienie" class="w3-container w3-round w3-blue" style="width:${uzytkownik.pragnienie}%; height: 20px;">${uzytkownik.pragnienie}%</div>
                        </div>
                    </td>
                    <td title="Drewno">
                        <img src="/resources/drewno.png"/> <p id="drewno">${uzytkownik.drewno}</p>
                    </td>
                    <td title="Grudka gliny">
                        <img src="/resources/glina.png"/> <p id="glina">${uzytkownik.grudkaGliny}</p>
                    </td>
                    <td title="Grudka zelaza">
                        <img src="/resources/grudkaZelaza.png"/> <p id="zelazo">${uzytkownik.grudkaZelaza}</p>
                    </td>
                    <td title="Worek zboza">
                        <img src="/resources/zboze.png"/> <p id="zboze">${uzytkownik.worekZboza}</p>
                    </td>
                    <td title="Zlote monety">
                        <img src="/resources/moneta.png"/> <p style="color:black; font-weight: bold; font-size:20px;">${uzytkownik.zloteMonety}</p>
                    </td>
                </tr>
                <tr>
                    <td>
                        Higiena:
                        <div class="w3-light-grey w3-round">
                            <div class="w3-container w3-round w3-blue" style="width:${uzytkownik.higiena}%; height: 20px;">${uzytkownik.higiena}%</div>
                        </div>
                    </td>
                    <td>
                        Sen:
                        <div class="w3-light-grey w3-round">
                            <div class="w3-container w3-round w3-blue" style="width:${uzytkownik.sen}%; height: 20px;">${uzytkownik.sen}%</div>
                        </div>
                    </td>
                    <td title="Deski">
                        <img src="/resources/deska.png"/> <p div="deski">${uzytkownik.deski}</p>
                    </td>
                    <td title="Cegly">
                        <img src="/resources/cegla.png"/> <p id="cegly">${uzytkownik.cegly}</p>
                    </td>
                    <td title="Sztabka zelaza">
                        <img src="/resources/zelazo.png"/> <p id="sztablkaZelaza">${uzytkownik.sztabkaZelaza}</p>
                    </td>
                    <td title="Chleb">
                        <img src="/resources/chleb.png"/> <p id="chleb">${uzytkownik.chleb}</p>
                    </td>
                    <td title="Doswiadczenie">
                        <img src="/resources/ksiazka.png"/> <p style="color:black; font-weight: bold; font-size:20px;">${uzytkownik.doswiadczenie}</p>
                    </td>
                </tr>
            </table>
    </div>
    </div>
</body>