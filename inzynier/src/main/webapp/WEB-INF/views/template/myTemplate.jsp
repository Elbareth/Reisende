<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
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
            function draged(name){
                var dragElement = document.getElementById(name);
                var dropElementOgrod = document.getElementById("ogrod");
                var dropElementDom = document.getElementById("dom");
                var array = document.getElementsByClassName("meble");

                dragElement.ondragstart = function(event){
                    var dropItem = event.dataTransfer.setData('key',event.target.id);
                    dropElementOgrod.style.backgroundImage = 'linear-gradient(rgba(0,153,51,.5), rgba(0,153,51,.5)), url("/resources/image.jpg")';
                    dropElementDom.style.backgroundImage = 'linear-gradient(rgba(0,153,51,.5), rgba(0,153,51,.5)), url("/resources/pom.png")';
                    for(i = 0; i<array.length;i++){
                        array[i].style.backgroundImage = 'linear-gradient(rgba(204,0,0,.5), rgba(204,0,0,.5)), url("/resources/Health.contrast-white.ico")';
                    }
                }

                dragElement.ondragover = function(event){
                    event.preventDefault();
                }
                dropElementOgrod.ondragover = function(event){
                    var dropItem = event.dataTransfer.getData('key');
                    event.preventDefault();
                }
                dropElementOgrod.ondrop = function(event){
                    var dropItem = event.dataTransfer.getData('key');
                    console.log(dropItem.class);
                    event.preventDefault();
                    dropElementOgrod.style.backgroundImage = 'url("/resources/image.jpg")';
                    dropElementDom.style.backgroundImage = 'url("/resources/pom.png")';
                    var allRight = true;
                    for(i = 0; i<array.length;i++){
                        array[i].style.backgroundImage = 'url("/resources/Health.contrast-white.ico")';
                        console.log(parseInt(array[i].style.left)+330);
                        var tmp1 = parseInt(array[i].style.left) + array[i].width +330;
                        console.log(tmp1);
                        console.log(event.pageX);
                        console.log(parseInt(array[i].style.top)+90);
                        var tmp2 = parseInt(array[i].style.top) + array[i].height+90;
                        console.log(tmp2);
                        console.log(event.pageY);
                        console.log(" ");
                        if(array[i].style.left >= event.pageX && (parseInt(array[i].style.left) + array[i].width) <=  event.pageX && array[i].style.top >= event.pageY && (parseInt(array[i].style.top) + array[i].height) <= event.pageY){
                            array[i].style.backgroundImage = 'linear-gradient(rgba(0,0,0,1), rgba(0,0,0,1)), url("/resources/Health.contrast-white.ico")';
                            allRight = false;
                            break;
                        }
                    }
                    if(array.length == 0 || allRight){
                        var myNewElement = document.createElement('img');
                        myNewElement.setAttribute("class", "meble");
                        myNewElement.src = dragElement.src;
                        myNewElement.style.top = event.pageY-300;
                        myNewElement.style.left = event.pageX-900;
                        myNewElement.style.position = 'absolute';
                        dropElementOgrod.appendChild(myNewElement);
                    }
                }
                dropElementDom.ondragover = function(event){
                    var dropItem = event.dataTransfer.getData('key');
                    event.preventDefault();
                }
                dropElementDom.ondrop = function(event){
                    var dropItem = event.dataTransfer.getData('key');
                    event.preventDefault();
                    dropElementDom.style.backgroundImage = 'url("/resources/pom.png")';
                    dropElementOgrod.style.backgroundImage = 'url("/resources/image.jpg")';
                    for(i = 0; i<array.length;i++){
                        array[i].style.backgroundImage = 'url("/resources/Health.contrast-white.ico")';
                    }
                    var myNewElement = document.createElement('img');
                    myNewElement.setAttribute("class", "meble");
                    myNewElement.src = dragElement.src;
                    myNewElement.style.top = event.pageY-90;
                    myNewElement.style.left = event.pageX-330;
                    console.log(event.pageX+" "+event.pageY);
                    myNewElement.style.position = 'absolute';
                    dropElementDom.appendChild(myNewElement);
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
