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
            <s:form action="/wyslijWiadomosc" method="post" modelAttribute="wiadomosc" enctype="multipart/form-data">
                <div class="innerLetter">
                <br/><br/><br/>
                    <h3>Odbiorca:</h3><s:input required = "required" placeholder = "Do kogo chcesz napisac list?" path = "odbiorca"/><br/>
                    <h3>Tytul:</h3><s:input required = "required" placeholder = "Wprowadz tytul" path = "tytul"/><br/>
                    <h3>Tresc:</h3><form:textarea path="tresc" maxlength="1000" rows="10" cols="40"/>
                    <br/><br/>
                <input type="submit" value="Wyslij"/></br>
                <br/><br/><br/>
                </div>
            </s:form>
        </div>
    </div>
</body>