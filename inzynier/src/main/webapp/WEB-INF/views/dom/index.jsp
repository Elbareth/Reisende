<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <body>
        <div class="main">
            <div class="domek">
                <div class="scrollbar my-custom-scrollbar-primary" style="height: 400px;">
                    <div class="innerHome" id="drop" ondragover="return false">
                        <div class="ogrod" id= "ogrod" style = "position: relative; left: 0; top: 0; visibility: visible; height: 500px; background-image: url('/resources/image.jpg');"> </div>
                        <div class="dom" id= "dom" style = "position: absolute; left: ${pomieszczenia.x}; top: ${pomieszczenia.y}; z-index: 15; visibility: visible; height: 200px; width: 200px; background-image: url('/resources/pom.png');"></div>
                    </div>
                </div>
                <script>
                    function hide(drag){
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
                <br/>
                <input type="submit" value="VV" onclick="return hide('drag')">
                <div class="drag" id ="drag" style="display:none; background-color: rgba(255,255,255,0.5);">
                    <div class="w3-bar w3-black w3-card" style="width:750px; height: 50px;">
                      <button class="w3-bar-item w3-button tablink" onclick="openLink(event, 'Dom')">Dom</button>
                      <button class="w3-bar-item w3-button tablink" onclick="openLink(event, 'Kuchnia')">Kuchnia</button>
                      <button class="w3-bar-item w3-button tablink" onclick="openLink(event, 'Sypialnia')">Sypialnia</button>
                      <button class="w3-bar-item w3-button tablink" onclick="openLink(event, 'Lazienka')">Lazienka</button>
                      <button class="w3-bar-item w3-button tablink" onclick="openLink(event, 'Dodatki')">Dodatki</button>
                    </div>
                    <div style="background-color: rgba(255,255,255,0.5);">
                         <div id="Dom" class="w3-container pokoje w3-animate-opacity" style="display:none">
                            <div class="scrollbar my-custom-scrollbar-primary" style="height: 400px;">
                                <img src="/resources/pom.png" id="room" draggable="true"/>
                            </div>
                         </div>
                         <div id="Kuchnia" class="w3-container pokoje w3-animate-opacity" style="display:none">
                            <div class="scrollbar my-custom-scrollbar-primary" style="height: 400px;">
                                <img src="/resources/Health.contrast-white.ico" id="kuchnia" draggable="true" class="furniture"/>
                                <script>
                                    var furniture = document.getElementById("kuchnia");
                                    draged("kuchnia");
                                </script>
                            </div>
                         </div>
                         <div id="Sypialnia" class="w3-container pokoje w3-animate-opacity" style="display:none">
                            <div class="scrollbar my-custom-scrollbar-primary" style="height: 400px;">
                                <img src="/resources/Health.contrast-white.ico" id="sypialnia" draggable="true" class="furniture"/>
                                <script>
                                    var furniture = document.getElementById("sypialnia");
                                    draged("sypialnia");
                                </script>
                            </div>
                         </div>
                         <div id="Lazienka" class="w3-container pokoje w3-animate-opacity" style="display:none">
                            <div class="scrollbar my-custom-scrollbar-primary" style="height: 400px;">
                                <img src="/resources/Health.contrast-white.ico" id="lazienka" draggable="true" class="furniture"/>
                                <script>
                                    var furniture = document.getElementById("lazienka");
                                    draged("lazienka");
                                </script>
                            </div>
                         </div>
                         <div id="Dodatki" class="w3-container pokoje w3-animate-opacity" style="display:none">
                            <div class="scrollbar my-custom-scrollbar-primary" style="height: 400px;">
                                <img src="/resources/Health.contrast-white.ico" id="dodatki" draggable="true" class="furniture"/>
                                <script>
                                    var furniture = document.getElementById("dodatki");
                                    draged("dodatki");
                                </script>
                            </div>
                         </div>
                    </div>
                </div>
                <script>
                    function openLink(evt, animName) {
                        var i, x, tablinks;
                        x = document.getElementsByClassName("pokoje");
                        for (i = 0; i < x.length; i++) {
                            x[i].style.display = "none";
                        }
                        tablinks = document.getElementsByClassName("tablink");
                        for (i = 0; i < x.length; i++) {
                            tablinks[i].className = tablinks[i].className.replace(" w3-red", "");
                        }
                        document.getElementById(animName).style.display = "block";
                        evt.currentTarget.className += " w3-red";
                    }
                </script>
            </div>
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
                                <div class="w3-container w3-round w3-blue" style="width:${uzytkownik.pragnienie}%; height: 20px;">${uzytkownik.pragnienie}%</div>
                            </div>
                        </td>
                        <td title="Drewno">
                            <img src="/resources/drewno.png"/> <p>${uzytkownik.drewno}</p>
                        </td>
                        <td title="Grudka gliny">
                            <img src="/resources/glina.png"/> <p>${uzytkownik.grudkaGliny}</p>
                        </td>
                        <td title="Grudka zelaza">
                            <img src="/resources/grudkaZelaza.png"/> <p>${uzytkownik.grudkaZelaza}</p>
                        </td>
                        <td title="Worek zboza">
                            <img src="/resources/zboze.png"/> <p>${uzytkownik.worekZboza}</p>
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
                            <img src="/resources/deska.png"/> <p>${uzytkownik.deski}</p>
                        </td>
                        <td title="Cegly">
                            <img src="/resources/cegla.png"/> <p>${uzytkownik.cegly}</p>
                        </td>
                        <td title="Sztabka zelaza">
                            <img src="/resources/zelazo.png"/> <p>${uzytkownik.sztabkaZelaza}</p>
                        </td>
                        <td title="Chleb">
                            <img src="/resources/chleb.png"/> <p>${uzytkownik.chleb}</p>
                        </td>
                        <td title="Doswiadczenie">
                            <img src="/resources/ksiazka.png"/> <p style="color:black; font-weight: bold; font-size:20px;">${uzytkownik.doswiadczenie}</p>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>