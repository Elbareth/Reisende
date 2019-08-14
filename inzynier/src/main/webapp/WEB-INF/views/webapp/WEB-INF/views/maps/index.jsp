<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="com.example.inzynier.BasicService.*" %>
<body>
<center>
<%
   response.setIntHeader("Refresh", 5);
%>
</center>
    <div class="main">
        <div class="map">
            <div class="my-custom-scrollbar my-custom-scrollbar-primary">
                <div class="innerMap">
                    <img style ="position: relative; left: 0; top: 0;" src="/resources/img10.jpg"/>
                    <img div="postac" id="postac" style =" position: absolute; left: ${lewo}; top: ${gora};" src="/resources/me.png"/>
                </div>
            </div>
        </div>
        <script>
            importPackage(com.example.inzynier.BasicService.PozycjaPostaci);
            var saveArrow = new com.example.inzynier.BasicService.PozycjaPostaci();
            document.addEventListener('keydown', function(event) {
              if (event.code == 'ArrowLeft') {
              saveArrow.savePosition(${lewo}-2,${gora});
                document.getElementById("postac").innerHTML = "<style> left: ${lewo}; top: ${gora}; </style>";
              }
              if (event.code == 'ArrowRight') {
              saveArrow.savePosition(${lewo}+2,${gora});
                document.getElementById("postac").innerHTML = "<style> left: ${lewo}; top: ${gora}; </style>";
              }
              if (event.code == 'ArrowUp') {
              saveArrow.savePosition(${lewo},${gora}-2);
                document.getElementById("postac").innerHTML = "<style> left: ${lewo}; top: ${gora}; </style>";
              }
              if (event.code == 'ArrowDown') {
              saveArrow.savePosition(${lewo},${gora}+2);
                document.getElementById("postac").innerHTML = "<style> left: ${lewo}; top: ${gora}; </style>";
              }
            });
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
        <table>
                <tr>
                    <td>
                        Glod:
                         <div class="w3-light-grey w3-round">
                          <div class="w3-container w3-round w3-blue" style="width:${uzytkownik.glod}%; width: 200px; height: 20px;">${uzytkownik.glod}%</div>
                        </div>
                    </td>
                    <td>
                        Pragnienie:
                        <div class="w3-light-grey w3-round">
                            <div class="w3-container w3-round w3-blue" style="width:${uzytkownik.pragnienie}%; width: 200px; height: 20px;">${uzytkownik.pragnienie}%</div>
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
                            <div class="w3-container w3-round w3-blue" style="width:${uzytkownik.higiena}%; width: 200px; height: 20px;">${uzytkownik.higiena}%</div>
                        </div>
                    </td>
                    <td>
                        Sen:
                        <div class="w3-light-grey w3-round">
                            <div class="w3-container w3-round w3-blue" style="width:${uzytkownik.sen}%; width: 200px; height: 20px;">${uzytkownik.sen}%</div>
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