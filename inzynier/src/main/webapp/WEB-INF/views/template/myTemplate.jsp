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
            function dragAndDrop(furniture){
                let currentDroppable = null;
                furniture.onmousedown = function(event){
                    let shiftX = event.clientX - furniture.getBoundingClientRect().left;
                    let shiftY = event.clientY - furniture.getBoundingClientRect().top;
                    furniture.style.position = 'absolute';
                    furniture.style.zIndex = 1000;
                    document.body.append(furniture);

                    function moveAt(pageX, pageY) {
                        furniture.style.left = pageX - shiftX + 'px';
                        furniture.style.top = pageY - shiftY + 'px';
                    }

                    function onMouseMove(event){
                        moveAt(event.pageX, event.pageY);
                        furniture.hidden = true;
                        let elemBelow = document.elementFromPoint(event.clientX, event.clientY);
                        furniture.hidden = false;
                        if (!elemBelow) return;
                        let droppableBelow = $(this).closest(elemBelow);
                        console.log(droppableBelow);
                        console.log(currentDroppable);
                        if (currentDroppable != droppableBelow) {
                            if (currentDroppable) { // null when we were not over a droppable before this event
                                enterDroppable(currentDroppable[0]);
                            }
                            currentDroppable = droppableBelow;
                            if (currentDroppable) { // null if we're not coming over a droppable now
                                // (maybe just left the droppable)
                                currentDroppable[0].style.background = 'red';
                                furniture.ondragstart = function() {
                                    return true;
                                };
                            }
                            furniture.ondragstart = function() {
                                return false;
                            };
                            currentDroppable[0].style.background = 'none';
                        }
                    }

                    document.addEventListener('mousemove', onMouseMove);
                    furniture.onmouseup = function() {
                        document.removeEventListener('mousemove', onMouseMove);
                        furniture.onmouseup = null;
                    };
                };
                function enterDroppable(elem) {
                    elem.style.background = 'green';
                    console.log("null when we were not over a droppable before this event");
                }
                furniture.ondragstart = function() {
                    return false;
                };
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
