<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<body>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Parisienne&display=swap');
    </style>
    <div class="main">
        <h1> Reisende - Napisz wiadomosc </h1>
        <a href="/wiadomosc"><input type="submit" value="Wiadomosci odebrane"/></a>
        <a href="/wiadomosciNadawca"><input type="submit" value="Wyslane wiadomosci"/></a>
        <a href="/napiszWiadomosc"><input type="submit" value="Napisz wiadomosc"/></a>
        <div class="letter">
            <s:form action="/odpiszWiadomosc/${wiadomosc.odbiorca}" method="get" modelAttribute="wiadomosc" enctype="multipart/form-data">
                <div class="innerLetter">
                <br/><br/><br/>
                    <h3 style="color: black; font-weight: bold;">Odbiorca:  ${wiadomosc.odbiorca} </h3><br/>
                    <h3 style="color: black; font-weight: bold;">Tytul: ${wiadomosc.tytul} </h3><br/>
                    <h3 style="color: black; font-weight: bold;">Tresc: <textarea rows="10" cols="40" disabled="true">${wiadomosc.tresc}</textarea></h3>
                    <br/><br/>
                <input type="submit" value="Odpisz"/></br>
                <br/><br/><br/>
                </div>
            </s:form>
        </div>
    </div>
</body>