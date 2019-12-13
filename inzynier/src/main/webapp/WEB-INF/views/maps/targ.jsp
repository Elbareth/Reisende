<h1> <b> Witaj na  targowisku ${uzytkownik.login}! </br> Co chcialbys nam sprzedac?</b></h1>
<table style ="border: none;">
    <tr style ="border: none;">
        <td style="display: flex; border: none;">
            <img title="drewno" src="/resources/drewno.png"/>
            <div class="slidecontainer" style="display: flex;">
                <input type="range" min="0" max="${uzytkownik.drewno}" value="0" class="slider" id="drewno" oninput="drewnoAmount.value=drewno.value">
                <output id="drewnoAmount" name="drewnoAmount" for="drewno"><b>0 (${uzytkownik.drewno})</b></output>
            </div>
        </td>
    </tr>
    <tr style ="border: none;">
        <td style="display: flex; border: none;">
            <img title="glina" src="/resources/glina.png"/>
            <div class="slidecontainer" style="display: flex;">
                <input type="range" min="0" max="${uzytkownik.grudkaGliny}" value="0" class="slider" id="glina" oninput="glinaAmount.value=glina.value">
                <output id="glinaAmount" name="glinaAmount" for="glina"><b>0 (${uzytkownik.grudkaGliny})</b></output>
            </div>
        </td>
    </tr>
    <tr style ="border: none;">
        <td style="display: flex; border: none;">
            <img title="zelazo" src="/resources/grudkaZelaza.png"/>
            <div class="slidecontainer" style="display: flex;">
                <input type="range" min="0" max="${uzytkownik.grudkaZelaza}" value="0" class="slider" id="zelazo" oninput="zelazoAmount.value=zelazo.value">
                <output id="zelazoAmount" name="zelazoAmount" for="zelazo"><b>0 (${uzytkownik.grudkaZelaza})</b></output>
            </div>
        </td>
    </tr>
    <tr style ="border: none;">
        <td style="display: flex; border: none;">
            <img title="zboze" src="/resources/zboze.png"/>
            <div class="slidecontainer" style="display: flex;">
                <input type="range" min="0" max="${uzytkownik.worekZboza}" value="0" class="slider" id="zboze" oninput="zbozeAmount.value=zboze.value">
                <output id="zbozeAmount" name="zbozeAmount" for="zboze"><b>0 (${uzytkownik.worekZboza})</b></output>
            </div>
        </td>
    </tr>
    <tr style ="border: none;">
        <td style="display: flex; border: none;">
            <img title="deski" src="/resources/deska.png"/>
            <div class="slidecontainer" style="display: flex;">
                <input type="range" min="0" max="${uzytkownik.deski}" value="0" class="slider" id="deski" oninput="deskiAmount.value=deski.value">
                <output id="deskiAmount" name="deskiAmount" for="deski"><b>0 (${uzytkownik.deski})</b></output>
            </div>
        </td>
    </tr>
    <tr style ="border: none;">
        <td style="display: flex; border: none;">
            <img title="cegly" src="/resources/cegla.png"/>
            <div class="slidecontainer" style="display: flex;">
                <input type="range" min="0" max="${uzytkownik.cegly}" value="0" class="slider" id="cegly" oninput="ceglyAmount.value=cegly.value">
                <output id="ceglyAmount" name="ceglyAmount" for="cegly"><b>0 (${uzytkownik.cegly})</b></output>
            </div>
        </td>
    </tr>
    <tr style ="border: none;">
        <td style="display: flex; border: none;">
            <img title="szatabka Zelaza" src="/resources/zelazo.png"/>
            <div class="slidecontainer" style="display: flex;">
                <input type="range" min="0" max="${uzytkownik.sztabkaZelaza}" value="0" class="slider" id="sztabkaZelaza" oninput="sztabkaZelazaAmount.value=sztabkaZelaza.value">
                <output id="sztabkaZelazaAmount" name="sztabkaZelazaAmount" for="sztabkaZelaza"><b>0 (${uzytkownik.sztabkaZelaza})</b></output>
            </div>
        </td>
    </tr>
    <tr style ="border: none;">
        <td style="display: flex; border: none;">
            <img title="chleb" src="/resources/chleb.png"/>
            <div class="slidecontainer" style="display: flex;">
                <input type="range" min="0" max="${uzytkownik.chleb}" value="0" class="slider" id="chleb" oninput="chlebAmount.value=chleb.value">
                <output id="chlebAmount" name="chlebAmount" for="chleb"><b>0 (${uzytkownik.chleb})</b></output>
            </div>
        </td>
    </tr>
</table>
<input type="submit" value="Sprzedaj" onclick="sprzedaj()">
<script>
    function sprzedaj(){
        var json = {};
        json.drewno = document.getElementById("drewno").value;
        json.glina = document.getElementById("glina").value;
        json.zelazo = document.getElementById("zelazo").value;
        json.zboze = document.getElementById("zboze").value;
        json.deski = document.getElementById("deski").value;
        json.cegla = document.getElementById("cegly").value;
        json.sztabkaZelaza = document.getElementById("sztabkaZelaza").value;
        json.chleb = document.getElementById("chleb").value;
        json.studnia = ${uzytkownik.pragnienie};
        var xhr = new XMLHttpRequest();
        xhr.open('POST', '/targ');
        xhr.setRequestHeader("Content-Type", "application/json");
        setTimeout(xhr.send(JSON.stringify(json)),5000);
        json = {};
        event.preventDefault();
        document.findElementById("drewno").value = 0;
        document.findElementById("glina").value = 0;
        document.findElementById("zelazo").value = 0;
        document.findElementById("zboze").value = 0;
        document.findElementById("deski").value = 0;
        document.findElementById("cegly").value = 0;
        document.findElementById("sztabkaZelaza").value = 0;
        document.findElementById("chleb").value = 0;
        alert("Wybrane przez Ciebie przedmioty zostaly sprzedane");
    }
</script>