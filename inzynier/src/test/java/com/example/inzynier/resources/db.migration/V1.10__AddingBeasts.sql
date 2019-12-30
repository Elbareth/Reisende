INSERT INTO d_bestie (nazwa, plik, polozenie, sila) VALUES ('Wilk', 'wilk.png', 'tlo2.jpg-1455x515;tlo2.jpg-655x1485;tlo2.jpg;862x654;tlo3.jpg-552x1358;tlo3.jpg-1246x986;tlo3.jpg-964x1253;tlo8.jpg-1535x522;tlo8.jpg-2512x699;tlo8.jpg-855x632', 500 );
INSERT INTO d_bestie (nazwa, plik, polozenie, sila) VALUES ('Duch', 'duch.png', 'domekAsiWnetrze3.jpg-160x100;domekAsiWnetrze3.jpg-560x260;domekAsiWnetrze3.jpg-230x300;domekAsiWnetrze3.jpg-380x100;domekAsiWnetrze3.jpg-250x190', 100 );
INSERT INTO d_bestie (nazwa, plik, polozenie, sila) VALUES ('Wandal', 'wandal.png', 'tlo2.jpg-545x963;tlo2.jpg-2436x1485;tlo2.jpg;1246x256;tlo3.jpg-1469x335;tlo3.jpg-2149x355;tlo3.jpg-122x366;tlo1.jpg-1535x522;tlo1.jpg-2512x699;tlo.jpg-855x632', 100 );
INSERT INTO d_bestie (nazwa, plik, polozenie, sila) VALUES ('Wampir', 'wampir.png', '', 1000 );
INSERT INTO d_bestie (nazwa, plik, polozenie, sila) VALUES ('Andvari', 'andvari.png', '', 10000 );
INSERT INTO d_bestie (nazwa, plik, polozenie, sila) VALUES ('Pajak', 'pajak.png', 'kopalniaWnetrze.jpg-230x117;kopalniaWnetrze.jpg-460x355;kopalniaWnetrze.jpg-140x327;kopalniaWnetrze.jpg-365x180;kopalniaWnetrze.jpg-536x231', 200 );
INSERT INTO d_bestie (nazwa, plik, polozenie, sila) VALUES ('Topielec', 'topielec.png', 'podwodnaGrotaWnetrze.jpg-233x100;podwodnaGrotaWnetrze.jpg-490x190;podwodnaGrotaWnetrze.jpg-200x277;podwodnaGrotaWnetrze.jpg-300x212;podwodnaGrotaWnetrze.jpg-300x373', 200 );
INSERT INTO d_bestie (nazwa, plik, polozenie, sila) VALUES ('Thrym', 'thrym.png', '', 5000);
INSERT INTO d_bestie (nazwa, plik, polozenie, sila) VALUES ('Krolik', 'krolik.png', 'tlo7.jpg-1585x694;tlo7.jpg-692x1236;tlo7.jpg-364x1447;tlo7.jpg-2147x345;tlo9.jpg-659x1453;tlo9.jpg-1246x1245;tlo9.jpg-147x155;tlo10.jpg-625x785;tlo10.jpg-1459x255;tlo10.jpg-2475x125', 10 );
INSERT INTO d_bestie (nazwa, plik, polozenie, sila) VALUES ('Szerszen', 'szerszen.png', 'tlo15.jpg-1585x694;tlo15.jpg-692x1236;tlo15.jpg-364x1447;tlo15.jpg-2147x345;tlo6.jpg-659x1453;tlo6.jpg-1246x1245;tlo6.jpg-147x155;tlo8.jpg-625x785;tlo8.jpg-1459x255;tlo8.jpg-2475x125', 50 );

CREATE TABLE d_zabite_bestie (
    id INT NOT NULL AUTO_INCREMENT,
    uzytkownik VARCHAR(50) NOT NULL,
    nazwa_bestii VARCHAR(50) NOT NULL,
    ilosc INT NOT NULL,
    PRIMARY KEY(id)
);