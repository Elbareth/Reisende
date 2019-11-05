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
                var array = document.getElementsByClassName("meble");
                var usun = document.getElementById("usun");
                var xStart;
                var yStart;

                dragElement.ondragstart = function(event){
                    var dropItem = event.dataTransfer.setData('key',event.target.id);
                    dropElementOgrod.style.backgroundImage = 'linear-gradient(rgba(0,153,51,.5), rgba(0,153,51,.5)), url("/resources/image.jpg")';
                    for(i = 0; i<array.length;i++){
                        array[i].style.backgroundImage = 'linear-gradient(rgba(204,0,0,.5), rgba(204,0,0,.5)), url("/resources/Health.contrast-white.ico")';
                    }
                }

                dragElement.ondragover = function(event){
                    event.preventDefault();
                }

                dropElementOgrod.ondragstart = function(event){
                    xStart = event.pageX - 425;
                    yStart = event.pageY - 70;
                }

                dropElementOgrod.ondragover = function(event){
                    var dropItem = event.dataTransfer.getData('key');
                    event.preventDefault();
                }
                dropElementOgrod.ondrop = function(event){
                    var dropItem = event.dataTransfer.getData('key');
                    event.preventDefault();
                    dropElementOgrod.style.backgroundImage = 'url("/resources/image.jpg")';
                    var allRight = true;
                    for(i = 0; i<array.length;i++){
                        array[i].style.backgroundImage = 'url("/resources/Health.contrast-white.ico")';
                        if((parseInt(array[i].style.left)) <= (event.pageX - 425) && (parseInt(array[i].style.left) + array[i].width) >= (event.pageX - 425) && (parseInt(array[i].style.top)) <= (event.pageY - 100) && (parseInt(array[i].style.top) + array[i].height) >= (event.pageY - 100)){
                            allRight = false;
                            break;
                        }
                    }
                    if(dropItem == "" ){
                        for(i = 0; i< array.length; i++){
                            if((parseInt(array[i].style.left)) <= xStart && (parseInt(array[i].style.left) + array[i].width) >= xStart && (parseInt(array[i].style.top)) <= yStart && (parseInt(array[i].style.top) + array[i].height) >= yStart){
                                array[i].remove();
                            }
                        }
                    }
                    if(array.length == 0 || allRight){
                        var myNewElement = document.createElement('img');
                        myNewElement.setAttribute("class", "meble");
                        myNewElement.setAttribute("id", array.length);
                        myNewElement.src = dragElement.src;
                        myNewElement.style.top = event.pageY - 100;
                        myNewElement.style.left = event.pageX - 440;
                        myNewElement.style.position = 'absolute';
                        dropElementOgrod.appendChild(myNewElement);
                    }
                }

                usun.ondragenter = function(event){
                    var dropItem = event.dataTransfer.getData('key');
                    event.preventDefault();
                    for(i = 0; i< array.length; i++){
                        if((parseInt(array[i].style.left)) <= xStart && (parseInt(array[i].style.left) + array[i].width) >= xStart && (parseInt(array[i].style.top)) <= yStart && (parseInt(array[i].style.top) + array[i].height) >= yStart){
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
