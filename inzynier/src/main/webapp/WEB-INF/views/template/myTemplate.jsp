<%@ page language="java"%>
<%@ page contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
    <head>
        <title>Reisende</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" type="text/css" href="/resources/main.css">
        <link href="https://fonts.googleapis.com/css?family=Metal+Mania&display=swap" rel="stylesheet">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://unpkg.com/konva@4.0.5/konva.min.js"></script>
        <meta http-equiv="Refresh" content="60">
        <script>

            function createElement(index, source, dropElementOgrod){
                var myNewElement = document.createElement('img');
                myNewElement.setAttribute("class", "meble");
                myNewElement.setAttribute("id", index);
                myNewElement.src = source;
                myNewElement.style.top = event.pageY - 100;
                myNewElement.style.left = event.pageX - 440;
                myNewElement.style.position = 'absolute';
                dropElementOgrod.appendChild(myNewElement);
                return myNewElement;
            }

            function addingNewElement(index, source, zloteMonety, dropElementOgrod){
                var myNewElement = createElement(index, source, dropElementOgrod);
                var json = {};
                json.wymiarX = myNewElement.style.left;
                json.wymiarY = myNewElement.style.top;
                json.pieniadze = zloteMonety;
                json.nazwa = myNewElement.src;
                return json;
            }

            function updateElement(index, source, dropElementOgrod, staryWymiarX, staryWymiarY){
                var myNewElement = createElement(index, source, dropElementOgrod);
                var json = {};
                json.staraPozycjaX = staryWymiarX;
                json.staraPozycjaY = staryWymiarY;
                json.wymiarX = myNewElement.style.left;
                json.wymiarY = myNewElement.style.top;
                json.nazwa = myNewElement.src;
                return json;
            }

            function draged(name, cena, zloteMonety){
                var dragElement = name;
                var dropElementOgrod = document.getElementById("ogrod");
                var array = document.getElementsByClassName("meble");
                var usun = document.getElementById("usun");
                var xStart;
                var yStart;

                dropElementOgrod.style.backgroundImage = 'linear-gradient(rgba(0,153,51,.5), rgba(0,153,51,.5)), url("/resources/mojDomekWnetrze.jpg")';

                dragElement.ondragstart = function(event){
                    var dropItem = event.dataTransfer.setData('key',event.target.id);
                    dropElementOgrod.style.backgroundImage = 'linear-gradient(rgba(0,153,51,.5), rgba(0,153,51,.5)), url("/resources/mojDomekWnetrze.jpg")';
                    for(i = 0; i<array.length;i++){
                        array[i].style.backgroundImage = 'linear-gradient(rgba(204,0,0,.5), rgba(204,0,0,.5)), url(array[i].src)';
                    }
                }

                dragElement.ondragover = function(event){
                    event.preventDefault();
                }

                dropElementOgrod.ondragstart = function(event){
                    xStart = event.pageX - 425;
                    yStart = event.pageY - 70;
                    //for(i = 0; i<array.length;i++){
                       // array[i].style.backgroundImage = 'linear-gradient(rgba(204,0,0,.5), rgba(204,0,0,.5)), url(array[i].src)';
                    //}
                }

                dropElementOgrod.ondragover = function(event){
                    var dropItem = event.dataTransfer.getData('key');
                    event.preventDefault();
                }
                dropElementOgrod.ondrop = function(event){
                    var dropItem = event.dataTransfer.getData('key');
                    event.preventDefault();
                    dropElementOgrod.style.backgroundImage = 'url("/resources/mojDomekWnetrze.jpg")';
                    var allRight = true;
                    for(i = 0; i<array.length;i++){
                        array[i].style.backgroundImage = 'url(array[i].src)';
                        if((parseInt(array[i].style.left)) <= (event.pageX - 425) && (parseInt(array[i].style.left) + array[i].width) >= (event.pageX - 425) && (parseInt(array[i].style.top)) <= (event.pageY - 100) && (parseInt(array[i].style.top) + array[i].height) >= (event.pageY - 100)){
                            allRight = false;
                            break;
                        }
                    }
                    if(cena == 0 ){
                        for(i = 0; i< array.length; i++){
                            console.log(array[i].style.left);
                            console.log(xStart);
                            console.log(array[i].style.top);
                            console.log(yStart);
                            if((parseInt(array[i].style.left)) <= xStart && (parseInt(array[i].style.left) + array[i].width) >= xStart && (parseInt(array[i].style.top)) <= yStart && (parseInt(array[i].style.top) + array[i].height) >= yStart){
                                var json = updateElement(array.length, array[i].src, dropElementOgrod, array[i].style.left, array[i].style.top);
                                var xhr = new XMLHttpRequest();
                                xhr.open('PATCH', '/dom');
                                xhr.setRequestHeader("Content-Type", "application/json");
                                xhr.send(JSON.stringify(json));
                                console.log("usuwam "+array[i]);
                                array[i].remove();
                                break;
                            }
                        }
                    }
                    else if(array.length == 0 || allRight){
                        if(zloteMonety - cena >= 0 ){
                            zloteMonety = zloteMonety - cena;
                            var json = addingNewElement(array.length, dragElement.src, zloteMonety, dropElementOgrod);
                            var xhr = new XMLHttpRequest();
                            xhr.open('POST', '/dom');
                            xhr.setRequestHeader("Content-Type", "application/json");
                            xhr.send(JSON.stringify(json));
                        }
                        else{
                            alert("Nie masz dostatecznej ilosci pieniedzy!");
                        }
                    }
                }

                usun.ondragenter = function(event){
                    var dropItem = event.dataTransfer.getData('key');
                    event.preventDefault();
                    for(i = 0; i< array.length; i++){
                        if((parseInt(array[i].style.left)) <= xStart && (parseInt(array[i].style.left) + array[i].width) >= xStart && (parseInt(array[i].style.top)) <= yStart && (parseInt(array[i].style.top) + array[i].height) >= yStart){
                            json = {};
                            json.wymiarX = array[i].style.left;
                            json.wymiarY = array[i].style.top;
                            json.nazwa = array[i].src;
                            var xhr = new XMLHttpRequest();
                            xhr.open('DELETE', '/dom');
                            xhr.setRequestHeader("Content-Type", "application/json");
                            xhr.send(JSON.stringify(json));
                            json = {};
                            array[i].remove();
                        }
                    }
                }
            }
        </script>
    </head>
    <body>
        <div class="menu">
            <a href="/maps"><input type="submit" value="Strona Glowna"/></a>
            <a href="/wyglad"><input type="submit" value="Wyglad Postaci"/></a>
            <a href="/dom"><input type="submit" value="Dom"/></a>
            <a href="/ranking"><input type="submit" value="Ranking"/></a>
            <a href="/arena"><input type="submit" value="Arena"/></a>
            <a href="/wiadomosc"><input type="submit" value="Wiadomosci"/></a>
            <a href="/wyloguj"><input type="submit" value="Wyloguj sie"/></a>
        </div>
        <div class="main">
            <tiles:insertAttribute name="content"></tiles:insertAttribute>
        </div>
    </body>
</html>
