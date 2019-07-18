CREATE TABLE Bestie (
    ID INT NOT NULL AUTO_INCREMENT,
    Nazwa VARCHAR(50) NOT NULL,
    Plik VARCHAR(50) NOT NULL,
    Polozenie VARCHAR(50) NOT NULL,
    Wymiary VARCHAR(50) NOT NULL,
    PRIMARY KEY(ID)
);

CREATE TABLE Budynki (
    Nazwa VARCHAR(50) NOT NULL,
    Polozenie VARCHAR(50) NOT NULL,
    Wymiary VARCHAR(50) NOT NULL,
    Plik VARCHAR(100) NOT NULL,
    PRIMARY KEY(Nazwa)
);

CREATE TABLE Czytelnik (
    ID INT NOT NULL AUTO_INCREMENT,
    Tytul VARCHAR(50) NOT NULL,
    Czytelnik VARCHAR(50) NOT NULL,
    PRIMARY KEY(ID)
);

CREATE TABLE DialogPostaci (
    ID INT NOT NULL AUTO_INCREMENT,
    NazwaQuesta VARCHAR(50) NOT NULL,
    Postac VARCHAR(50) NOT NULL,
    Tekst VARCHAR(200) NOT NULL,
    PRIMARY KEY(ID)
);

CREATE TABLE Domek(
    Wlasciciel VARCHAR(50) NOT NULL,
    Pomieszczenia VARCHAR(500) NOT NULL,
    Okna VARCHAR(500) NOT NULL,
    Drzwi VARCHAR(500) NOT NULL,
    Lozko VARCHAR(500) NOT NULL,
    Wanna VARCHAR(500) NOT NULL,
    Umywalka VARCHAR(500) NOT NULL,
    Toaeta VARCHAR(500) NOT NULL,
    Szafki VARCHAR(500) NOT NULL,
    Zlew VARCHAR(500) NOT NULL,
    Kuchenka VARCHAR(500) NOT NULL,
    Lodowka VARCHAR(500) NOT NULL,
    Szafa VARCHAR(500) NOT NULL,
    Obraz VARCHAR(500) NOT NULL,
    Dywany VARCHAR(500) NOT NULL,
    Kominki VARCHAR(500) NOT NULL,
    Kwiaty VARCHAR(500) NOT NULL,
    Wazony VARCHAR(500) NOT NULL,
    Trofea VARCHAR(500) NOT NULL,
    Kojec VARCHAR(500) NOT NULL,
    Krzesla VARCHAR(500) NOT NULL,
    Fotele VARCHAR(500) NOT NULL,
    Sofa VARCHAR(500) NOT NULl,
    Stoly VARCHAR(500) NOT NULL,
    Barek VARCHAR(500) NOT NULL,
    Podloga VARCHAR(500) NOT NULL,
    PRIMARY KEY(Wlasciciel)
);

CREATE TABLE Ekwipunek(
    ID INT NOT NULL AUTO_INCREMENT,
    Wlasciciel VARCHAR(50) NOT NULL,
    Nazwa VARCHAR(50) NOT NULL,
    Plik VARCHAR(50) NOT NULL,
    Opis VARCHAR(200) NOT NULL,
    PRIMARY KEY(ID)
);

CREATE TABLE Eliksir(
    Nazwa VARCHAR(50) NOT NULL,
    Cena DECIMAL(4,2) NOT NULL,
    Plik VARCHAR(50) NOT NULL,
    Wlasciwosci VARCHAR(200) NOT NULL,
    Przepis VARCHAR(100) NOT NULL,
    PRIMARY KEY(Nazwa)
);

INSERT INTO Eliksir VALUES ('EliksirBogactwa',	200,	'eliksirBogactwa.png',	'Ten eliksir spowoduje do Twojego magazynu przebedzie po jednym surowcu kzdego rodzaju',	'lwiapaszczka20,mlecz10');
INSERT INTO Eliksir VALUES ('EliksirCzyswosci',	100,	'eliksirCzystosci.png',	'Ten eliksir spowoduje ze staniesz sie czusciutki i pachnacy. Zaladuje Twoj pasek Higieny na max',	'mydelnica20');
INSERT INTO Eliksir VALUES ('EliksirDoswiadczenia',	200,	'eliksirDoswiadczenia.png',	'Ten eliksir zapewnia maly przyplyw doswiadczenia. Po wypiciu kazdej buteleczki bedziesz madrzejszy o 10 pkt',	'herbata5,lawenda10');
INSERT INTO Eliksir VALUES ('EliksirGlodu',	100,	'eliksirGlodu.png',	'Ten eliksir spowoduje ze calkowicie przestaniesz byc glodny. Zaladuje Twoj pasek glodu na max',	'jagody20,malina10,herbata5');
INSERT INTO Eliksir VALUES ('EliksirMadrosci',	300,	'eliksirMadrosci.png',	'Ten eliksir sprawi, ze po jego wypiciu staniesz sie o wiele madrzejszy. Zostanie dodane 100 pkt dosiwadczenia',	'herbata30,lawenda15');
INSERT INTO Eliksir VALUES ('EliksirWielosokowy',	200,	'eliksirWielosokowy.png',	'Ten eliksir spowoduje kompletna zmiane Twojego wygladu',	'sliaz10,redestptasi20');
INSERT INTO Eliksir VALUES ('EliksirWitalnosci',	100,	'eliksirWitalnosci.png',	'Ten eliksir spowoduje ze calkowicie przestaniesz byc zmeczony. Laduje pasek snu na max',	'jagody10');
INSERT INTO Eliksir VALUES ('EliksirZdrowia',	200,	'eliksirZdrowia.png',	'Ten eliksir spowoduje ze plaga, ktora nawiedzila Twoja wioske kompletnie zniknie i wszyscy chorzy na nia ludzie zostana uleczeni',	'rumianek10,lawenda5,szalwia15');
INSERT INTO Eliksir VALUES ('KremWiedzmy',	300,	'kremWiedzmy.png',	'Ta masc jest niezbedna kazdej czarownicy. Zapewnia dobry nastroj i niesamowita zabawe',	'czerwonymuchomor10,niebieskigrzyk15');
INSERT INTO Eliksir VALUES ('PlynneZloto',	300,	'plynneZloto.png',	'Ten eliksir zapewni Ci szybki przyplyw gotowki. Spowoduje, ze do Twojego mieszka przybedzie 500 sztuk zlota',	'lwiapaszczka50,mlecz5,lawenda10');

CREATE TABLE InnePrzedmioty(
    Nazwa VARCHAR(50) NOT NULL,
    Cena DECIMAL(4,2) NOT NULL,
    Plik VARCHAR(50) NOT NULL,
    Opis VARCHAR(200) NOT NUll,
    PRIMARY KEY(Nazwa)
);

INSERT INTO InnePrzedmioty VALUES('Ciasto Jagodowe',	5,	'ciastoJagodowe.png',	'Pyszne ciasto jagodowe. Zostalo upieczone wg. starego przepisu babki Asi. Gdy jest zjesz Twoje sily witalne troszke wzrosna');
INSERT INTO InnePrzedmioty VALUES('Jajo Smoka',	30,	'jajoSmoka.png',	'Ciekawe co znajduje sie w tym jajku? Stary medrzec twierdzi, ze prawdziwy smok! Mozesz sprobowac je wysiedziec w kojcu lub sprzedac kolekcjonerowi');
INSERT INTO InnePrzedmioty VALUES('Karta',	5,	'karta.png',	'Kolekcjonerska karta do gry. Bardzo rzadko spotykana. Mozesz ja sprzedac z zyskiem');
INSERT INTO InnePrzedmioty VALUES('Kolek',	15,	'kolek.png',	'Osikowy kolek wykonany przez Lesniczego');
INSERT INTO InnePrzedmioty VALUES('Lalka',	30,	'lalka.png',	'To jest ulubiona lalka Asi. Otrzymales ja za swoja odwage. Jest wykonana ze slomy i przyozdobiona kolorowymi wstazkami i miaterialami.');
INSERT INTO InnePrzedmioty VALUES('Luneta',	100,	'luneta.png',	'Dzieki tej drogocennej lunecie mozna zobaczyc w gwiazdy. Osoba o odpowiedniej wiedzy moze dzieki niej zobaczyc Twoja przyszlosc');
INSERT INTO InnePrzedmioty VALUES('Mieso',	10,	'mieso.png',	'Mieso ktore zdobyles z zabitego przez Ciebie zwierzecia. Gdy je zdjesz urosnie Ci troche sila witalna. Mozesz tez dac je smoku o ile go posiadasz');
INSERT INTO InnePrzedmioty VALUES('Palantir',	300,	'palantir.png',	'Ta niepozorna szklana kula to Palantir. Umozliwia on maga kontakty na odleglosc. Trzeba jednak z nim postepowac ostroznie! Lepiej go oddac jakiemus poteznemu Magowi!');
INSERT INTO InnePrzedmioty VALUES('Suknia Slubna',	200,	'sukniaSlubna.png',	'Piekna suknia slubna wykonana z najczystrzego jedwabiu, udekorowana kwiatami i swiecidelkami. Na pewno zachwyci kazda panne mloda');
INSERT INTO InnePrzedmioty VALUES('Sztabka Zlota',	1000,	'sztabkaZlota.png',	'Drogocenna sztabka zlota. Najlepiej od razu ja spieniejzyj!');

CREATE TABLE Ksiazki(
    Id INT NOT NULL AUTO_INCREMENT ,
    Nazwa VARCHAR(50) NOT NULL,
    Tresc VARCHAR(1000) NOT NULL,
    Doswiadczenia INT NOT NULL,
    PRIMARY KEY(Id)
);

INSERT INTO Ksiazki VALUES(1,	'Ksiazka z wrozbami',	'Księżyc symbolizującego ojczyznę, kobiecą stronę naszej natury, uczucia,dom, emocje.
Słońce jak wyraża się nasza energia, pewność siebie, świadomość,rys jaki postrzegają w nas inni.
Merkury symbolizuje umysł, komunikację,podróże, wiadomości,mowi o zdolnościach umysłowych i inteligencji.
Mars planeta wojny. Symbolizuje agresję, siłę, stres,szybkie akcje a także seksualność.',	20);
INSERT INTO Ksiazki VALUES(2,	'Zielnik',	'Jagody Zawierają witaminę C, która wzmacnia odporność. Wywary sporządzone z nich dodają sił.
Rumianek dobry do łagodzenia stanów zapalnych. Jest w stanie uleczyć przeziębienie czy ułatwić trawienie.
Tymianek przyprawa do mięs, posiada piekny zapach. Ma własciwosci wykrztusne.
Szałwia leczy nawet cieżkie stany zapalne. Idealna na infekcję gardła czy zapalenie dziąseł. ',	200);
INSERT INTO Ksiazki VALUES(3,	'Ksiazka o smokach',	'Jajko smoka jest cale czarne w czerwone plamki. Do tego jest olbrzymie! Kazdy kolekcjoner da Ci za niego krocie. Mozesz tez sam wychodowac smoka
Jajko nalezy wlozyc do kojca i natychmiast wykluje sie z niego smok. Po jajku jednak nie da sie stwierdzic jaki to bedzie smok.
Dlatego wyglad smoka bedzie dla Ciebie niespodzianka. Kazdy smok zachowuje sie jednak tak samo - kazdy daje Ci 100
punktow doswiadczenia dziennie. O smoka nalezy jednak dbac! Nalezy karmic go krolikami oraz poic woda. Jesli smok umrze
tracisz cale zloto oraz 1000 pkt doswiadczenia. ',	100);
INSERT INTO Ksiazki VALUES (4,	'Historia Krolestwa',	'Nasza kraina została stworzona przez starożytne bostwa. Potomkowie tych bostw nadal kraza po ziemi. Sa to m.in. Asowie jak Thor czy Odyn.
Możemy też wyroznc tez olbrzymy typu Loki czy Thrym.Olbrzymy mozna pogdzielic ze wzgledu na zywioly jakie kontroluja.
Wystepuja lodowe olbrzymy oraz ogniste olbrzymy. Mozna tez spotkac Krasoludy stworzone przez boga Aulego. Spotkamy tu: Brokka, Sindriego oraz Andvaliego
Dobrzy bogowie stworzyli rowniez ludzi oraz elfy. Elfy po wojnie z Morgothem odeszly w cien. Dziki Melkor stworzył caly bestariusz, a sam
Sauron potrafi sie przebrac za wampira. W centrum swiata rosnie wielki dab Yggdrasilu, a na krancu wszechswiata znajduje sie ocena w ktorym plywa Jormungand.',	50);
INSERT INTO Ksiazki VALUES(5,	'Ksiazka o Zbrojach',	'Kazdy uzytkownik ma do dyspozycji kilka rodzajow ekwipunku: helm, zbroja, bron, buty, tarcza, amulety i rekawice.
Niektore rodzaje broni moze miec kazdy, a inne tylko poszczegolne klasy(lotrzyk, wojownik i mag).
Nazwa  Punkty Ataku  Punkty Obrony  Wymagany Poziom Punkty Doswiadczenia Klasa
ButyWiedzmy	0	100	30	70	mag FikusneButyZPomponem	0	150	50	150	mag GotyckieRekawice	100	100	30	300	wojownik
HelmTopielcow	0	70	20	150	mag HelmZeSkrzydlami	0	30	5	50 mag HelmZRogami	0	100	30	300	lotrzyk LodowaTarcza	20	50	5	50	mag
MalySztylecik	50	20	1	30	lotrzyk MetaloweMinetki	150	150	50	400	wojownik Mithril	50	300	70	500	wojownik
Mjonir	500	300	150	300	wszystkieKlasy
PelerynaWampira	20	50	5	70	mag RekawicaThora	200	200	70	500	wszystkieKlasy SmoczaTarcza	30	100	30	70	lotrzyk
SmoczySygnet	50	30	5	50	mag SnieznaLaska	150	70	30	70 mag TarczaOgnia	50	150	50	100	mag
Zadlo	250	170	70	150 lotrzyk ZlotyPierscienKrasnoludaAndvari	150	120	50	400 wszystkieKlasy	',200);
INSERT INTO Ksiazki values (6,	'Podrecznik eliksirow',	'EliksirBogactwa	200 Ten eliksir dodaje po jednym surowcu kzdego rodzaju	lwiapaszczka20,mlecz10
EliksirCzyswosci	100	Ten eliksir zaladuje Twoj pasek Higieny na max	mydelnica20
EliksirDoswiadczenia	200	Ten eliksir zapewnia przyplyw 10 pkt doswiadczenia. herbata5,lawenda10
EliksirGlodu	100	Ten eliksir zaladuje Twoj pasek glodu na max	jagody20,malina10,herbata5
EliksirMadrosci	300	Ten eliksir sprawi, ze zostanie dodane 100 pkt dosiwadczenia	herbata30,lawenda15
EliksirWielosokowy	200	Ten eliksir spowoduje kompletna zmiane Twojego wygladu	sliaz10,redestptasi20
EliksirWitalnosci	100	Ten eliksir laduje pasek snu na max	jagody10
EliksirZdrowia	200	Ten eliksir spowoduje ze plaga kompletnie zniknie i wszyscy chorzy zostana uleczeni	rumianek10,lawenda5,szalwia15
KremWiedzmy	300	Ta masc jest niezbedna kazdej czarownicy. czerwonymuchomor10,niebieskigrzyk15
PlynneZloto	300 Ten eliksir spowoduje, ze do Twojego mieszka przybedzie 500 sztuk zlota	lwiapaszczka50,mlecz5,lawenda10	',	200);
INSERT INTO Ksiazki VALUES(7,	'Plotki ploteczki',	'Medrzec - jego zadaniem jest pokazanie Ci tej krainy.
Wiedzma Jagna - potrafi uwazyc kazdy eliksir o ile sie dobrze zaplaci
Burmistrz miasta - kompetetny urzednik ktory zawsze dba o dobro miasta
Mala Asia - ot zwykla dziewczynka
Wedrowiec - wasciwie nikt o nim nic nie wie
Kolekcjoner - posiada najwiesza na swiecei kolecje lalek
Lesnik - dba o porzadek w lesie
Astrolog - stary dziwak
Bibliotekarz - cichy i spokojny. W jego bibliotece znajdziesz najwazniejsze informacje o grze
Pokerzysta - gracz, ktory spedza wiekszosc czasu w barze
Zielarka - ma ogromena wiedze na temat wszystkich ziol
Loki - bog klamstwa i ognia. Raczej nie mozna mu ufac
Andvari - chciwy krsnolud. Kolekcjonuje zloto niczym smok.
Sindrii i Brokk - bracia krasnoludy
Wedkarz - podczciwy stary pan, ktory lubi opowiadac legendy.
Chomik - slodki i puchaty. Przynosi szczescie
Mag - potezny ale nikt go zbyt nie lubi
Thor - bog piorunow. Czesto ma problemy ze swym wujem Lokim
Szwaczka - dobra w swoim fachu. ',	100);
INSERT INTO Ksiazki VALUES(8,	'Bestariusz',	'Wilki - grasuja w lesie, strasza podroznych i morduja zwierzeta hodowlane.
Duchy - uwielbiaja straszyc szczegolnie male dzieci.
Wandale z lasu - grubka uciekinierow z wiezenia, ktore grasuja po lesie. Zasmiecaja las, podpalaja drzewa i strasza turystow.
Wampir - niektorzy twerdza, ze to Sauron w przebraiu. Prawda jest taka, ze to bardzo trudny przeciwnik. Moze zabic go tylko kolek osikowy od Lesnika
Andvari - chciwy krasnolud, kolekcjoner zlota i  innych swiecidelek. Ma pierscien na ktorego rzucil klatwe. Wszysto co dotchnie
zmienia w zloto. Ale zwykly smiertelnik moze mrzec od tego kontaktu. Jeden z grozniejszych przeciwnikow
Topiciele - ozywione trupy osob, ktore utonely. W ramach zemsty topia kazdego kogo napotkaja na swojej drodze
Thrym - lodowy olbrzym zakochany w Frei. Kradnie on mlot Thora w ramach okupu. Nie mozna dopuscic by jego plan sie udal
Kroliki - slodkie i puchate. Przekaska smoka
Szerszenie - strasza wioske gawiedzi. ',	150);
INSERT INTO Ksiazki VALUES(9,	'Wystroj wnetrz',	'W naszym asortymecie znajdziesz bogaty wybor mebli wykonanych ze somy, gliny, drewna, kafli, metalu... W kazdym stylu na kazda kieszen
Kazdy mebel dodaje Ci roche doswiadczenia. Urzadz swoj dom by byl funkcjonaly i wygodny.
Sen: Lozka
Pragnienie: Barek, Studnia (element mapy)
Higiena: Umywalka, Toaleta, Zlew
Kojec - mozna w nim hodowac smoka
Garderoba - otwiera panel zmiany wygladu postaci',	50);
INSERT INTO Ksiazki VALUES(10,	'Podrecznik poczatkujacego',	'Witaj nowy! Witaj w naszej krainie! Podazaj za samouczkiem Merdca. W ten sposb poznasz tajemnice tej krainy. By zarabiac pieniadze
musisz zarabiac, np. przy scince drzewa czy przy wypiekaniu chleba. By zdobyc doswiadczenie musisz wykonac questy. Za zarobione pieniadze mozesz kupic
meble czy zbroje. Doswiadczenie warunkuje twoj poziom postaci. Tylko przy okreslonym poziomie mozesz ubrac konkretna zborje. Uwazaj na Lokiego!
Dbaj o potrzeby swoje i swojego smoka!',	100);

CREATE TABLE Kuznia(
    Id INT NOT NULL AUTO_INCREMENT,
    Sprzedajacy VARCHAR(50) NOT NULL,
    AktualnaCena DECIMAL(4,2) NOT NULL,
    CzyStala BIT(1) NOT NULL,
    IloscLicytujacych INT NOT NULL,
    Nazwa VARCHAR(50) NOT NULL,
    Plik VARCHAR(50) NOT NULL,
    Klasa VARCHAR(50) NOT NULL,
    Opis VARCHAR(200) NOT NULL,
    PRIMARY KEY(Id)
);

CREATE TABLE Meble(
    Nazwa VARCHAR(100) NOT NULL,
    Plik VARCHAR(50) NOT NULL,
    Kategoria VARCHAR(50) NOT NULL,
    Glod INT NOT NULL,
    Sen INT NOT NULL,
    Pragnienie INT NOT NULL,
    Higiena INT NOT NULL,
    Doswiadczenia INT NOT NULL,
    PRIMARY KEY(Nazwa)
);

INSERT INTO Meble VALUES('ArtDecoStol',	'artDecoStol.png',	'Stoly',	300,	0,	0,	0,	0,	300);
INSERT INTO Meble VALUES('BardzoPuchatyDywan',	'puchatyDywan.png',	'Dywany',	200,	0,	0,	0,	0,	200);
INSERT INTO Meble VALUES('BarekWKrsztalcieGlobusu',	'globusBarek.png',	'Barki',	450,	0,	0,	100,	0,	450);
INSERT INTO Meble VALUES('BarekWStyluKolonijnym',	'kolonijnyBarek.png',	'Barki',	250,	0,	0,	50,	0,	250);
INSERT INTO Meble VALUES('BarekZeStaregoDrewna',	'stareDrewnoBarek.png',	'Barki',	200,	0,	0,	40,	0,	200);
INSERT INTO Meble VALUES('Beksinski',	'beksinski.png',	'Obrazy',	500,	0,	0,	0,	0,	500);
INSERT INTO Meble VALUES('BialaDwudrzwiowaLodowka',	'bialaDwudrzwiowaLodowka.png',	'Lodowki',	200,	100,	0,	0,	0,	100);
INSERT INTO Meble VALUES('BialaLodowka',	'bialaLodowka.png',	'Lodowki',	170,	70,	0,	0,	0,	80);
INSERT INTO Meble VALUES('BialaSzafa',	'bialaSzafa.png',	'Szafa',	300,	0,	0,	0,	0,	300);
INSERT INTO Meble VALUES('BialaSzafka',	'bialaSzafka.png',	'Szafki',	30,	0,	0,	0,	0,	30);
INSERT INTO Meble VALUES('BialaToaleta',	'bialaToaleta.png',	'Toalety',	50,	0,	0,	0,	10,	30);
INSERT INTO Meble VALUES('BialaUmywalka',	'bialaUmywalka.png',	'Umywalki',	70,	0,	0,	0,	10,	40);
INSERT INTO Meble VALUES('BialeOkno',	'bialeOkno.png',	'Okna',	10,	0,	0,	0,	0,	10);
INSERT INTO Meble VALUES('BialyStol',	'bialyStol.png',	'Stoly',	100,	0,	0,	0,	0,	100);
INSERT INTO Meble VALUES('BialyZlew',	'bialyZlew.png',	'Zlew',	50,	0,	0,	0,	10,	20);
INSERT INTO Meble VALUES('Blochomaz',	'blochomaz.png',	'Obrazy',	50,	0,	0,	0,	0,	50);
INSERT INTO Meble VALUES('Bratki',	'bratki.png',	'Kwiaty',	130,	0,	0,	0,	0,	130);
INSERT INTO Meble VALUES('BrazowyPuchar',	'brazowyPuchar.png',	'Trofea',	550,	0,	0,	0,	0,	550);
INSERT INTO Meble VALUES('BujanyFotel',	'bujanyFotel.png',	'Fotele',	200,	0,	0,	0,	0,	200);
INSERT INTO Meble VALUES('CeglanaKuchnia',	'ceglanaKuchnia.png',	'Kuchnia',	50,	10,	0,	0,	0,	30);
INSERT INTO Meble VALUES('CzarnaOzdobnaDwudrzwiowaLodowka',	'czarnaDwudrzwiowaLodowka.png',	'Lodowki',	300,	150,	0,	0,	0,	150);
INSERT INTO Meble VALUES('CzarnaOzdobnaToaleta',	'czarnaToaleta.png',	'Toalety',	100,	0,	0,	0,	30,	50);
INSERT INTO Meble VALUES('CzarnoZlotaSzafka',	'czarnoZlotaSzafka.png',	'Szafki',	230,	0,	0,	0,	0,	230);
INSERT INTO Meble VALUES('CzarnyZlew',	'czarnyZlew.png',	'Zlew',	150,	0,	0,	0,	30,	70);
INSERT INTO Meble VALUES('CzerwonaSzafa',	'czerwonaSzafa.png',	'Szafa',	350,	0,	0,	0,	0,	350);
INSERT INTO Meble VALUES('CzerwonaSzafka',	'czerwonaSzafka.png',	'Szafki',	50,	0,	0,	0,	0,	50);
INSERT INTO Meble VALUES('CzerwonoZloteLozko',	'czerwonoZloteLozko.png',	'Lozka',	450,	0,	45,	0,	0,	230);
INSERT INTO Meble VALUES('CzerwonyDywan',	'czerwonyDywan.png',	'Dywany',	70,	0,	0,	0,	0,	70);
INSERT INTO Meble VALUES('Drewniana3-drzwiowaSzafa',	'drewniana3-drzwiowaSzafa.png',	'Szafa',	500,	0,	0,	0,	0,	500);
INSERT INTO Meble VALUES('DrewnianaLawa',	'lawa.png',	'Lozka',	150,	0,	15,	0,	0,	70);
INSERT INTO Meble VALUES('DrewnianaOzdobnaSzafka',	'drewnianaOzdobnaSzafka.png',	'Szafki',	300,	0,	0,	0,	0,	300);
INSERT INTO Meble VALUES('DrewnianaPodloga',	'drewnianaPodloga.png',	'Podloga',	20,	0,	0,	0,	5,	20);
INSERT INTO Meble VALUES('DrewnianaSofa',	'drewnianaSofa.png',	'Sofa',	100,	0,	0,	0,	0,	100);
INSERT INTO Meble VALUES('DrewnianaSzafka',	'drewnianaSzafka.png',	'Szafki',	250,	0,	0,	0,	0,	250);
INSERT INTO Meble VALUES('DrewnianeDrzwi',	'drewnianeDrzwi.png',	'Drzwi',	20,	0,	0,	0,	0,	20);
INSERT INTO Meble VALUES('DrewnianeKrzeslozObiciem',	'krzesloZObiciem.png',	'Krzesla',	250,	0,	0,	0,	0,	250);
INSERT INTO Meble VALUES('DrewnianeKrzesloZPoduszka',	'krzesloZPoduszka.png',	'Krzesla',	130,	0,	0,	0,	0,	130);
INSERT INTO Meble VALUES('DrewnianeOkno',	'drewnianeOkno.png',	'Okna',	20,	0,	0,	0,	0,	20);
INSERT INTO Meble VALUES('DrewnianyCiosanyWazon',	'drewnianyWazon.png',	'Wazony',	30,	0,	0,	0,	0,	30);
INSERT INTO Meble VALUES('DrewnianyFotel',	'drewnianyFotel.png',	'Fotele',	100,	0,	0,	0,	0,	100);
INSERT INTO Meble VALUES('DrewnianyKufer',	'drewnianyKufer.png',	'Szafa',	50,	0,	0,	0,	0,	50);
INSERT INTO Meble VALUES('DrewnianyStol',	'drewnianyStol.png',	'Stoly',	150,	0,	0,	0,	0,	150);
INSERT INTO Meble VALUES('DrzewkoBonsai',	'bonsai.png',	'Kwiaty',	100,	0,	0,	0,	0,	100);
INSERT INTO Meble VALUES('DuzyBarek',	'duzyBarek.png',	'Barki',	300,	0,	0,	70,	0,	300);
INSERT INTO Meble VALUES('DywanWKropki',	'kropkiDywan.png',	'Dywany',	150,	0,	0,	0,	0,	150);
INSERT INTO Meble VALUES('DywanWKwiaty',	'kwiatyDywan.png',	'Dywany',	450,	0,	0,	0,	0,	450);
INSERT INTO Meble VALUES('DywanWRomby',	'rombyDywan.png',	'Dywany',	100,	0,	0,	0,	0,	100);
INSERT INTO Meble VALUES('DziuraWZiemi',	'dziura.png',	'Lodowki',	5,	5,	0,	0,	0,	5);
INSERT INTO Meble VALUES('EleganckaSkorzanaSofa',	'skorzanaSofa.png',	'Sofa',	550,	0,	0,	0,	0,	550);
INSERT INTO Meble VALUES('ElektrycznaCzarnoCzerwonaKuchnia',	'elektrycznaCzarnoCzerwonaKuchnia.png',	'Kuchnia',	400,	50,	0,	0,	0,	200);
INSERT INTO Meble VALUES('ElektrycznaKuchnia',	'elektrycznaKuchnia.png',	'Kuchnia',	300,	40,	0,	0,	0,	170);
INSERT INTO Meble VALUES('FiolekAfrykanski',	'fiolekAfrykanski.png',	'Kwiaty',	230,	0,	0,	0,	0,	230);
INSERT INTO Meble VALUES('FioletowyWazon',	'fioletowyWazon.png',	'Wazony',	100,	0,	0,	0,	0,	100);
INSERT INTO Meble VALUES('FlosalWazon',	'flosalWazon.png',	'Wazony',	200,	0,	0,	0,	0,	200);
INSERT INTO Meble VALUES('FotelLudwikaFilipa',	'ludwikFilipFotel.png',	'Fotele',	500,	0,	0,	0,	0,	500);
INSERT INTO Meble VALUES('FotelLudwikXV',	'ludwikXVFotel.png',	'Fotele',	450,	0,	0,	0,	0,	450);
INSERT INTO Meble VALUES('FuterkowaSofa',	'futerkowaSofa.png',	'Sofa',	500,	0,	0,	0,	0,	500);
INSERT INTO Meble VALUES('GazowaKuchniaZButla',	'gazowaKuchnia.png',	'Kuchnia',	250,	35,	0,	0,	0,	150);
INSERT INTO Meble VALUES('GlinianaUmywalka',	'glinianaUmywalka.png',	'Umywalki',	50,	0,	0,	0,	5,	30);
INSERT INTO Meble VALUES('GlinianyKominek',	'glinianyKominek.png',	'Kominki',	300,	0,	0,	0,	0,	300);
INSERT INTO Meble VALUES('GlinianyWazon',	'glinianyWazon.png',	'Wazony',	50,	0,	0,	0,	0,	50);
INSERT INTO Meble VALUES('GlinianyZlew',	'glinianyZlew.png',	'Zlew',	20,	0,	0,	0,	5,	10);
INSERT INTO Meble VALUES('Hiacynt',	'hiacynt.png',	'Kwiaty',	150,	0,	0,	0,	0,	150);
INSERT INTO Meble VALUES('Kaktus',	'kaktus.png',	'Kwiaty',	30,	0,	0,	0,	0,	30);
INSERT INTO Meble VALUES('KawalekDrewna',	'kawalekDrewna.png',	'Stoly',	30,	0,	0,	0,	0,	30);
INSERT INTO Meble VALUES('KiczowataSofa',	'kiczowataSofa.png',	'Sofa',	150,	0,	0,	0,	0,	150);
INSERT INTO Meble VALUES('KiczowyObrazek',	'kicz.png',	'Obrazy',	70,	0,	0,	0,	0,	70);
INSERT INTO Meble VALUES('Klepisko',	'klepisko.png',	'Podloga',	10,	0,	0,	0,	0,	10);
INSERT INTO Meble VALUES('KojecZBuda',	'budaKojec.png',	'Kojec',	200,	0,	0,	0,	0,	200);
INSERT INTO Meble VALUES('KojecZZabawkami',	'zabawkiKojec.png',	'Kojec',	300,	0,	0,	0,	0,	300);
INSERT INTO Meble VALUES('KolorowyObraz',	'kolorowyObraz.png',	'Obrazy',	130,	0,	0,	0,	0,	130);
INSERT INTO Meble VALUES('KominekKaflowy',	'kaflowyKominek.png',	'Kominki',	100,	0,	0,	0,	0,	100);
INSERT INTO Meble VALUES('KominekKaflowyOzdobny',	'kaflowyOzdobnyKominek.png',	'Kominki',	200,	0,	0,	0,	0,	200);
INSERT INTO Meble VALUES('KominekZKamienia',	'kamiennyKominek.png',	'Kominki',	500,	0,	0,	0,	0,	500);
INSERT INTO Meble VALUES('KrolewskieLozko',	'krolewskieLozko.png',	'Lozka',	550,	0,	55,	0,	0,	300);
INSERT INTO Meble VALUES('KrysztaloweTrofeum',	'krysztaloweTrofeum.png',	'Trofea',	500,	0,	0,	0,	0,	500);
INSERT INTO Meble VALUES('KrysztalowyWazon',	'krysztalowyWazon.png',	'Wazony',	500,	0,	0,	0,	0,	500);
INSERT INTO Meble VALUES('KuchniaKalowa',	'kaflowaKuchnia.png',	'Kuchnia',	60,	10,	0,	0,	0,	50);
INSERT INTO Meble VALUES('KutaMetalowaUmywalka',	'metalowaUmywalka.png',	'Umywalki',	150,	0,	0,	0,	30,	100);
INSERT INTO Meble VALUES('LaciataSzafka',	'laciataSzafka.png',	'Szafki',	100,	0,	0,	0,	0,	100);
INSERT INTO Meble VALUES('LawkaSzkolna',	'lawkaSzkolna.png',	'Stoly',	50,	0,	0,	0,	0,	50);
INSERT INTO Meble VALUES('Lilia',	'lilia.png',	'Kwiaty',	250,	0,	0,	0,	0,	250);
INSERT INTO Meble VALUES('LozkoZBaldachimem',	'baldachimLozko.png',	'Lozka',	500,	0,	50,	0,	0,	250);
INSERT INTO Meble VALUES('LozkoZBialaPosciela',	'bialeLozko.png',	'Lozka',	250,	0,	25,	0,	0,	120);
INSERT INTO Meble VALUES('LuksusowyKojec',	'luksusowyKojec.png',	'Kojec',	500,	0,	0,	0,	0,	500);
INSERT INTO Meble VALUES('MalowidloNaScienne',	'malowidlo.png',	'Obrazy',	30,	0,	0,	0,	0,	30);
INSERT INTO Meble VALUES('Medal',	'medal.png',	'Trofea',	100,	0,	0,	0,	0,	100);
INSERT INTO Meble VALUES('NiebieskaDwudrzwiowaLodowka',	'niebieskaDwudrzwiowaLodowka.png',	'Lodowki',	250,	130,	0,	0,	0,	120);
INSERT INTO Meble VALUES('NiebieskaSzafka',	'niebieskaSzafka.png',	'Szafki',	70,	0,	0,	0,	0,	70);
INSERT INTO Meble VALUES('NiebieskieLozko',	'niebieskieLozko.png',	'Lozka',	300,	0,	30,	0,	0,	150);
INSERT INTO Meble VALUES('ObrazZeZwierzeciem',	'zwierze.png',	'Obrazy',	150,	0,	0,	0,	0,	150);
INSERT INTO Meble VALUES('Ognisko',	'ognisko.png',	'Kuchnia',	5,	5,	0,	0,	0,	5);
INSERT INTO Meble VALUES('OgromnyKojec',	'ogromnyKojec.png',	'Kojec',	400,	0,	0,	0,	0,	400);
INSERT INTO Meble VALUES('OknoZOkiennicami',	'oknoZOkiennicami.png',	'Okna',	50,	10,	0,	0,	0,	30);
INSERT INTO Meble VALUES('OkraglyStol',	'okraglyStol.png',	'Stoly',	350,	0,	0,	0,	0,	350);
INSERT INTO Meble VALUES('OzdobnaBialaUmywalka',	'ozdobnaUmywalka.png',	'Umywalki',	100,	0,	0,	0,	20,	70);
INSERT INTO Meble VALUES('OzdobnaKuchniaKaflowa',	'ozdobnaKaflowaKuchnia.png',	'Kuchnia',	100,	20,	0,	0,	0,	70);
INSERT INTO Meble VALUES('OzdobnaSpizarnia',	'ozdobnaSpizarnia.png',	'Lodowki',	50,	15,	0,	0,	0,	30);
INSERT INTO Meble VALUES('OzdobnaStaraSzafa',	'OzdobnaStaraSzafa.png',	'Szafa',	250,	0,	0,	0,	0,	250);
INSERT INTO Meble VALUES('OzdobnaSzafa',	'ozdobnaSzafa.png',	'Szafa',	550,	0,	0,	0,	0,	550);
INSERT INTO Meble VALUES('OzdobneDrewnianeKrzeslo',	'ozdobneKrzeslo.png',	'Krzesla',	150,	0,	0,	0,	0,	150);
INSERT INTO Meble VALUES('OzdobneDrzwi',	'ozdobneDrzwi.png',	'Drzwi',	30,	0,	0,	0,	0,	30);
INSERT INTO Meble VALUES('OzdobnyBialyZlew',	'ozdobnyZlew.png',	'Zlew',	100,	0,	0,	0,	20,	50);
INSERT INTO Meble VALUES('OzdobnyDrewnianyStol',	'ozdobnyDrewnianyStol.png',	'Stoly',	450,	0,	0,	0,	0,	450);
INSERT INTO Meble VALUES('OzdobnyKufer',	'ozdobnyKufer.png',	'Szafa',	70,	0,	0,	0,	0,	70);
INSERT INTO Meble VALUES('Paprotka',	'paprotka.png',	'Kwiaty',	50,	0,	0,	0,	0,	50);
INSERT INTO Meble VALUES('PejzazGorski',	'gory.png',	'Obrazy',	250,	0,	0,	0,	0,	250);
INSERT INTO Meble VALUES('PejzazLesny',	'las.png',	'Obrazy',	230,	0,	0,	0,	0,	230);
INSERT INTO Meble VALUES('Pieniek',	'pieniek.png',	'Krzesla',	50,	0,	0,	0,	0,	50);
INSERT INTO Meble VALUES('PluszowaSofa',	'pluszowaSofa.png',	'Sofa',	450,	0,	0,	0,	0,	450);
INSERT INTO Meble VALUES('PluszoweKrzeslo',	'pluszoweKrzeslo.png',	'Krzesla',	200,	0,	0,	0,	0,	200);
INSERT INTO Meble VALUES('PluszowyFotel',	'pluszowyFotel.png',	'Fotele',	350,	0,	0,	0,	0,	350);
INSERT INTO Meble VALUES('Plytki',	'plytki.png',	'Podloga',	50,	0,	0,	0,	10,	30);
INSERT INTO Meble VALUES('Pomarancza',	'pomarancza.png',	'Kwiaty',	200,	0,	0,	0,	0,	200);
INSERT INTO Meble VALUES('PorcelanowyWazon',	'porcelanowyWazon.png',	'Wazony',	350,	0,	0,	0,	0,	350);
INSERT INTO Meble VALUES('Portret',	'portret.png',	'Obrazy',	200,	0,	0,	0,	0,	200);
INSERT INTO Meble VALUES('PorzadnyDrewnianyStol',	'porzadnyDrewnianyStol.png',	'Stoly',	400,	0,	0,	0,	0,	400);
INSERT INTO Meble VALUES('ProsteDrzwi',	'prosteDrzwi.png',	'Drzwi',	10,	0,	0,	0,	0,	10);
INSERT INTO Meble VALUES('PrzenosnaKuchnka',	'przenosnaKuchnka.png',	'Kuchnia',	150,	25,	0,	0,	0,	100);
INSERT INTO Meble VALUES('PuchoweLozko',	'puchoweLozko.png',	'Lozka',	350,	0,	35,	0,	0,	170);
INSERT INTO Meble VALUES('PuchoweZloteLozko',	'puchoweZloteLozko.png',	'Lozka',	400,	0,	40,	0,	0,	200);
INSERT INTO Meble VALUES('RogiJelenia',	'rogiJelenia.png',	'Trofea',	150,	0,	0,	0,	0,	150);
INSERT INTO Meble VALUES('RozaChinska',	'rozaChinksa.png',	'Kwiaty',	350,	0,	0,	0,	0,	350);
INSERT INTO Meble VALUES('RustykalnyKominek',	'rustykalnyKominek.png',	'Kominki',	400,	0,	0,	0,	0,	400);
INSERT INTO Meble VALUES('SalonowyBarek',	'salonowyBarek.png',	'Barki',	350,	0,	0,	80,	0,	350);
INSERT INTO Meble VALUES('SkandynawskiBarek',	'skandynawskiBarek.png',	'Barki',	150,	0,	0,	30,	0,	150);
INSERT INTO Meble VALUES('SkoraZDzika',	'skoraDzika.png',	'Trofea',	200,	0,	0,	0,	0,	200);
INSERT INTO Meble VALUES('SkoraZTygrysa',	'skoraTygrysa.png',	'Trofea',	250,	0,	0,	0,	0,	250);
INSERT INTO Meble VALUES('SkorzanyFotel',	'skorzanyFotel.png',	'Fotele',	400,	0,	0,	0,	0,	400);
INSERT INTO Meble VALUES('SkrzynkaZAlkocholem',	'skrzynkaZAlokocholem.png',	'Barki',	50,	0,	0,	10,	0,	50);
INSERT INTO Meble VALUES('SlomianeLozko',	'slomianeLozko.png',	'Lozka',	100,	0,	10,	0,	0,	50);
INSERT INTO Meble VALUES('SofaWKropki',	'kropkiSofa.png',	'Sofa',	300,	0,	0,	0,	0,	300);
INSERT INTO Meble VALUES('SofaWKwiaty',	'kwiatySofa.png',	'Sofa',	350,	0,	0,	0,	0,	350);
INSERT INTO Meble VALUES('SofaZPoduszkami',	'poduszkiSofa.png',	'Sofa',	400,	0,	0,	0,	0,	400);
INSERT INTO Meble VALUES('Spizarnia',	'spizarnia.png',	'Lodowki',	30,	10,	0,	0,	0,	10);
INSERT INTO Meble VALUES('SrebnyPuchar',	'srebnyPuchar.png',	'Trofea',	600,	0,	0,	0,	0,	600);
INSERT INTO Meble VALUES('Stara3-drzwiowaSzafa',	'stara3-drzwiowaSzafa.png',	'Szafa',	200,	0,	0,	0,	0,	200);
INSERT INTO Meble VALUES('StaraBialaLodowka',	'staraBialaLodowka.png',	'Lodowki',	100,	30,	0,	0,	0,	50);
INSERT INTO Meble VALUES('StaraDrewnianaOzdobnaSzafka',	'staraOzdobnaSzafka.png',	'Szafki',	200,	0,	0,	0,	0,	200):
INSERT INTO Meble VALUES('StaraDrewnianaSzafka',	'staraSzafka.png',	'Szafki',	170,	0,	0,	0,	0,	170);
INSERT INTO Meble VALUES('StaraKuchniaGazowa',	'staraGazowaKuchnia.png',	'Kuchnia',	200,	30,	0,	0,	0,	130);
INSERT INTO Meble VALUES('StaraSofa',	'staraSofa.png',	'Sofa',	200,	0,	0,	0,	0,	200);
INSERT INTO Meble VALUES('StaraSzafa',	'staraSzafa.png',	'Szafa',	100,	0,	0,	0,	0,	100);
INSERT INTO Meble VALUES('StaraSzaraLodowka',	'staraSzaraLodowka.png',	'Lodowki',	150,	50,	0,	0,	0,	70);
INSERT INTO Meble VALUES('StaraToaleta',	'staraToaleta.png',	'Toalety',	30,	0,	0,	0,	5,	20);
INSERT INTO Meble VALUES('StareDrewnianeKrzeslo',	'stareDrewnianeKrzeslo.png',	'Krzesla',	70,	0,	0,	0,	0,	70);
INSERT INTO Meble VALUES('StaryBarekNaKolkach',	'staryBarekNaKolkach.png',	'Barki',	100,	0,	0,	20,	0,	100);
INSERT INTO Meble VALUES('StarySzaryDywan',	'starySzaryDywan.png',	'Dywany',	50,	0,	0,	0,	0,	50);
INSERT INTO Meble VALUES('StogSiana',	'stogSiana.png',	'Krzesla',	30,	0,	0,	0,	0,	30);
INSERT INTO Meble VALUES('StolZObrusem',	'obrusStol.png',	'Stoly',	200,	0,	0,	0,	0,	200);
INSERT INTO Meble VALUES('StolZSerwetka',	'serwetkaStol.png',	'Stoly',	170,	0,	0,	0,	0,	170);
INSERT INTO Meble VALUES('Storczyk',	'storczyk.png',	'Kwiaty',	300,	0,	0,	0,	0,	300):
INSERT INTO Meble VALUES('SwietnieWyposazonyBarek',	'swietnieWyposazonyBarek.png',	'Barki',	400,	0,	0,	90,	0,	400);
INSERT INTO Meble VALUES('SzafkaZSerwetka',	'szafkaSerwetka.png',	'Szafki',	150,	0,	0,	0,	0,	150);
INSERT INTO Meble VALUES('SzklanaStatuetka',	'szklanaStatuetka.png',	'Trofea',	350,	0,	0,	0,	0,	350);
INSERT INTO Meble VALUES('TivoliDywan',	'tivoliDywan.png',	'Dywany',	400,	0,	0,	0,	0,	400);
INSERT INTO Meble VALUES('TrocheSlomy',	'sloma.png',	'Dywany',	30,	0,	0,	0,	0,	30);
INSERT INTO Meble VALUES('VintageDywan',	'vintageDywan.png',	'Dywany',	300,	0,	0,	0,	0,	300);
INSERT INTO Meble VALUES('WazonWKwiaty',	'kwiatyWazon.png',	'Wazony',	270,	0,	0,	0,	0,	270);
INSERT INTO Meble VALUES('WazonWPaski',	'paskiWazon.png',	'Wazony',	130,	0,	0,	0,	0,	130);
INSERT INTO Meble VALUES('Wiadro',	'wiadro.png',	'Toalety',	5,	0,	0,	0,	1,	5);
INSERT INTO Meble VALUES('WiklinowyFotel',	'wiklinowyFotel.png',	'Fotele',	150,	0,	0,	0,	0,	150);
INSERT INTO Meble VALUES('WygodneKrzesloSkorzane',	'krzesloSkorzane.png',	'Krzesla',	300,	0,	0,	0,	0,	300);
INSERT INTO Meble VALUES('WygodnyFotel',	'wygodnyFotel.png',	'Fotele',	300,	0,	0,	0,	0,	300);
INSERT INTO Meble VALUES('ZabytkowyPerskiDywan',	'perskiDywan.png',	'Dywany',	600,	0,	0,	0,	0,	600);
INSERT INTO Meble VALUES('ZabytkowyWazon',	'zabytkowyWazon.png',	'Wazony',	250,	0,	0,	0,	0,	250);
INSERT INTO Meble VALUES('Zdjecie',	'zdjecie.png',	'Obrazy',	100,	0,	0,	0,	0,	100);
INSERT INTO Meble VALUES('ZdobionyBarek',	'zdobionyBarek.png',	'Barki',	500,	0,	0,	120,	0,	500);
INSERT INTO Meble VALUES('ZielonaKuchniaKalowa',	'zielonaKaflowaKuchnia.png',	'Kuchnia',	70,	15,	0,	0,	0,	50);
INSERT INTO Meble VALUES('ZlotaLodowka',	'zlotaLodowka.png',	'Lodowki',	500,	200,	0,	0,	0,	500);
INSERT INTO Meble VALUES('ZlotaToaleta',	'zlotaToaleta.png',	'Toalety',	350,	0,	0,	0,	50,	200);
INSERT INTO Meble VALUES('ZlotaUmywalka',	'zlotaUmywalka.png',	'Umywalki',	300,	0,	0,	0,	50,	200);
INSERT INTO Meble VALUES('ZlotyPuchar',	'zlotyPuchar.png',	'Trofea',	700,	0,	0,	0,	0,	700);
INSERT INTO Meble VALUES('ZlotyZlew',	'zlotyZlew.png',	'Zlew',	300,	0,	0,	0,	50,	150);
INSERT INTO Meble VALUES('ZniszczoneLozko',	'zniszczoneLozko.png',	'Lozka',	200,	0,	20,	0,	0,	100);
INSERT INTO Meble VALUES('ZniszczonyFotel',	'zniszczonyFotel.png',	'Fotele',	50,	0,	0,	0,	0,	50);
INSERT INTO Meble VALUES('ZniszczonyKufer',	'zniszczonyKufer.png',	'Szafa',	30,	0,	0,	0,	0,	30);
INSERT INTO Meble VALUES('ZwyklaPomaranczowaSofa',	'pomaranczowaSofa.png',	'Sofa',	250,	0,	0,	0,	0,	250);
INSERT INTO Meble VALUES('ZwykleDrewnianeKrzeslo',	'drewnianeKrzeslo.png',	'Krzesla',	120,	0,	0,	0,	0,	120);
INSERT INTO Meble VALUES('ZwykleMetaloweKrzeslo',	'metaloweKrzeslo.png',	'Krzesla',	100,	0,	0,	0,	0,	100);
INSERT INTO Meble VALUES('ZwykleMetaloweTrofeum',	'metaloweTrofeum.png',	'Trofea',	300,	0,	0,	0,	0,	300);
INSERT INTO Meble VALUES('ZwyklyBialyWazon',	'bialyWazon.png',	'Wazony',	70,	0,	0,	0,	0,	70);
INSERT INTO Meble VALUES('ZwyklyFotel',	'zwyklyFotel.png',	'Fotele',	250,	0,	0,	0,	0,	250);
INSERT INTO Meble VALUES('ZwyklyKojec',	'zwyklyKojec.png',	'Kojec',	100,	0,	0,	0,	0,	100);

CREATE TABLE Postac(
    Imie VARCHAR(50) NOT NULL,
    Polozenie VARCHAR(50) NOT NULL,
    Plik VARCHAR(50) NOT NULL,
    PRIMARY KEY(Imie)
);

CREATE TABLE Questy(
    Id INT NOT NULL AUTO_INCREMENT,
    Postac VARCHAR(50) NOT NULL,
    Wykonujacy VARCHAR(50) NOT NULL,
    NoweZadanie VARCHAR(50) NOT NULL,
    Tresc VARCHAR(200) NOT NULL,
    Nagroda VARCHAR(100) NOT NULL,
    CzyWykonane BIT(1) NOT NULL,
    PRIMARY KEY(Id)
);

CREATE TABLE Smok(
    Wlasciciel VARCHAR(50) NOT NULL,
    Imie VARCHAR(50) NOT NULL,
    Gatunek VARCHAR(100) NOT NULL,
    PunktyZycia INT NOT NULL,
    Plik VARCHAR(50) NOT NULL,
    PRIMARY KEY(Wlascicie)
);

CREATE TABLE Uzytkownik(
    Login VARCHAR(50) NOT NULL,
    Haslo VARCHAR(300) NOT NULL,
    Nick VARCHAR(50) NOT NULL,
    KlasaPostaci VARCHAR(50) NOT NULL,
    ZloteMonety INT NOT NULL,
    Doswiadczenie INT NOT NULL,
    Wyglad VARCHAR(50) NOT NULL,
    Plec VARCHAR(1) NOT NULL,
    Drewno INT NOT NULL,
    GrudkaGliny INT NOT NULL,
    GrudkaZelaza INT NOT NULL,
    WorekZboza INT NOT NULL,
    Deski INT NOT NULL,
    Cegly INT NOT NULL,
    SztabkaZelaza INT NOT NULL,
    Chleb INT NOT NULL,
    Helm VARCHAR(50) NOT NULL,
    Zbroja VARCHAR(50) NOT NULL,
    Buty VARCHAR(50) NOT NULL,
    Rekawice VARCHAR(50) NOT NULL,
    Amulet VARCHAR(50) NOT NULL,
    Tarcza VARCHAR(50) NOT NULL,
    Bron VARCHAR(50) NOT NULL,
    Sen INT NOT NULL,
    Glod INT NOT NULL,
    Higiena INT NOT NULL,
    Pragnienie INT NOT NULL,
    Smok VARCHAR(50) NOT NULL,
    Poziom INT NOT NULL,
    Polozenie VARCHAR(100) NOT NULL,
    PRIMARY KEY(Login)
);

CREATE TABLE WygladPostaci(
    Id INT NOT NULL AUTO_INCREMENT,
    Nazwa VARCHAR(50) NOT NULL,
    Klasa VARCHAR(50) NOT NULL,
    Plik VARCHAR(50) NOT NULL,
    Kategoria VARCHAR(1) NOT NULL,
    PRIMARY KEY(Id);
);

INSERT INTO WygladPostaci VALUES(1, 'Blond Wojowniczka', 'wojownik', 'blondWojowniczka.png', 'K');
INSERT INTO WygladPostaci VALUES(2, 'Ruda Wojowniczka', 'wojownik', 'rudaWojowniczka.png', 'K');
INSERT INTO WygladPostaci VALUES(3, 'Brunetka Wojowniczka', 'wojownik', 'brunetkaWojowniczka.png', 'K');
INSERT INTO WygladPostaci VALUES(4, 'Szatynka Wojowniczka', 'wojownik', 'szatynkaWojowniczka.png', 'K');
INSERT INTO WygladPostaci VALUES(5, 'Blond Wojownik', 'wojownik', 'blondWojownik.png', 'M');
INSERT INTO WygladPostaci VALUES(6, 'Rudy Wojownik', 'wojownik', 'rudyWojownik.png', 'M');
INSERT INTO WygladPostaci VALUES(7, 'Brunet Wojownik', 'wojownik', 'brunetWojownik.png', 'M' );
INSERT INTO WygladPostaci VALUES(8, 'Szatyn Wojownik', 'wojownik', 'szatynWojownik.png', 'M');
INSERT INTO WygladPostaci VALUES(9, 'Blond Lotrzyca', 'lotrzyk', 'blondLotrzyca.png', 'K');
INSERT INTO WygladPostaci VALUES(10, 'Ruda Lotrzyca', 'lotrzyk', 'rudaLotrzyca.png', 'K');
INSERT INTO WygladPostaci VALUES(11, 'Brunetka Lotrzyca', 'lotrzyk', 'brunetkaLotrzyca.png', 'K');
INSERT INTO WygladPostaci VALUES(12, 'Szatynka Lotrzyca', 'lotrzyk', 'szatynkaLotrzyca.png', 'K');
INSERT INTO WygladPostaci VALUES(13, 'Blond Lotrzyk', 'lotrzyk', 'blondLotrzyk.png', 'M');
INSERT INTO WygladPostaci VALUES(14, 'Rudy Lotrzyk', 'lotrzyk', 'rudyLotrzyk.png', 'M');
INSERT INTO WygladPostaci VALUES(15, 'Brunet Lotrzyk', 'lotrzyk', 'brunetLotrzyk.png', 'M');
INSERT INTO WygladPostaci VALUES(16, 'Szatyn Lotrzyk', 'lotrzyk', 'szatynLotrzyk.png', 'M');
INSERT INTO WygladPostaci VALUES(17, 'Blond Czarodziejka', 'mag', 'blondCzarodziejka.png', 'K');
INSERT INTO WygladPostaci VALUES(18, 'Ruda Czarodziejka', 'mag', 'rudaCzarodziejka.png', 'K');
INSERT INTO WygladPostaci VALUES(19, 'Brunetka Czarodziejka', 'mag', 'brunetkaCzarodziejka.png', 'K');
INSERT INTO WygladPostaci VALUES(20, 'Szatynka Czarodziejka', 'mag', 'szatynkaCzarodziejka.png', 'K');
INSERT INTO WygladPostaci VALUES(21, 'Blond Mag', 'mag', 'blondMag.png', 'M');
INSERT INTO WygladPostaci VALUES(22, 'Rudy Mag', 'mag', 'rudyMag.png', 'M');
INSERT INTO WygladPostaci VALUES(23, 'Brunet Mag', 'mag', 'brunetMag.png', 'M');
INSERT INTO WygladPostaci VALUES(24, 'Szatyn Mag', 'mag', 'szatynMag.png', 'M');

CREATE TABLE Zadania(
    Nazwa VARCHAR(50) NOT NULL,
    Tresc VARCHAR(200) NOT NULL,
    Postać VARCHAR(50) NOT NULL,
    Nagroda VARCHAR(50) NOT NULL,
    PRIMARY KEY(Nazwa);
);

INSERT INTO Zadania VALUES('Biblioteka', 'Coz za piekna bilioteka! I ile ksiazek! Przeczytaj je wszystkie a na pewno zdobedziesz duzo doswiadczenia. Mozesz takze odsprzedac posiadane przez Ciebie ksiazki bibliotekarzowi', 'Bibliotekarz', '10Doswiadczenia,50Zlota');
INSERT INTO Zadania VALUES('Bog Klamstwa', 'Loki, Odyn i Hoenir wpadli w tarapaty. Niechcacy zabili czwlowieka przemienionego w wydre. Za kare bogowie maja mu przyniesc cos drogocennego. Loki prosi Cie o zdobycie periscienia Andvariego.', 'Loki', '1000Doswiadczenia,-100Zlota');
INSERT INTO Zadania VALUES('Duchy', 'Mala Asia siedzi przerazona w domu. Podejrzewa, ze u niej na strychu grasuja duchy! Przepedz duchy a czeka Cie mila niespodzianka', 'Mala Asia', '1Lalka,1JagodoweCiasto');
INSERT INTO Zadania VALUES('Gra', 'W kacie Twojego ulubionego baru siedzi tajemniczy jegomosc. Zaprasza Cie do gry. Wygraj z nim a otrzymasz rownie tajemnicza nagrode', 'Pokerzysta', '20Doswiadczenia,1JajoSmoka,1Karta');
INSERT INTO Zadania VALUES('Jagody', 'Jagmy Stara Wiedzma Jagma nie jest juz tak sprawna jak kiedys. Pomoz jej pozbierac niezbedne jagody a czeka Cie wspaniala nagroda!', 'Wiedzma Jagma', '50Doswiadczenia,1EliksirWitalnosci');
INSERT INTO Zadania VALUES('Jedzonko dla Chomika', 'Maly glodny chomik siedzi na lace. Jest bardzo glodny bo wiewiorki zabraly mu cale zapasy. Znajdz dla niego troszke jedzenia', 'Chomik', '100Doswiadczenia,MaxPotrzeby');
INSERT INTO Zadania VALUES('Osikowy Kolek', 'Zdabadz troche drzewa i zelaza bym lesnik mogl Ci wyrzezbic osikowy kolek. Tylko nim mozesz pokonac Wampira', 'Lesnik', '100Doswiadczenia');
INSERT INTO Zadania VALUES('Pajaki', 'Zrospaczony Sindri szuka brata. Podjerzewa, ze porwaly go pajaki. Uwolnij Brokka a na pewno czeka Cie wspaniala nagroda.', 'Sindri', '100Doswiadczenia,1Mjonir');
INSERT INTO Zadania VALUES('Palantir', 'Palantir to przyzad dzieki ktoremu magowie moga sie porozumiec na odleglosc. Niestaty nasz stary mag gdzies zgubil swoj. Odszukaj go dla niego', 'Mag', '100Doswiadczenia,1LaskaMaga');
INSERT INTO Zadania VALUES('Przyjecie u Diabla', 'Nasza stara znajmowa - Malgosia - jest zaproszona na bal do Diabla. Nie moze sie jednak pokazac w takim stanie. Zdobadz dla niej tajemnicza masc', 'Malgosia', '100Doswiadczenia,1SztabkaZlota');
INSERT INTO Zadania VALUES('Samouczek', 'Jestes nowy w tej krainie. Podarzaj za medrcem by poznac panujace tu zasady. Po przejsciu samouczka bedziesz juz wiedzial jak poruszac sie po swiecie. Powodzenia!', 'Medrzec', '10Doswiadczenia,100Zlota');
INSERT INTO Zadania VALUES('Slub', 'Alez ten Thor pieknie wyglada. Dobra teraz czas na odyzskanie mlota. Pomoz Thorowi zabic Thryma', 'Thor', '1000Doswiadczenia,100Zloto,1RekawiceThora');
INSERT INTO Zadania VALUES('Spojrz w Gwiazdy', 'Nasz Astrolog moze przepowiedziec Ci przyszlosc! Do tego jest mu potrzebna tylko luneta. Stara spadla z iezy astronomicznej i sie potlukala. Zdobadz dla niego nowa', 'Astrolog', '10Doswiadczenia,1KsiazkaZWrozbami');
INSERT INTO Zadania VALUES('Suknia slubna', 'Nazbieraj odpowienie kwiaty i zpalac troche pieniedzy by szwaczki mogl dla Ciebie zrobic suknie slubna i bukiecik', 'Szwaczka', '10Doswiadczenia,-100Zloto');
INSERT INTO Zadania VALUES('Tajemniczy pierscien', 'Pierscien Andvariego jest bardzo cenny. Wszystko co zostanie nim dotchniete natychmiast zamienia sie w zloto. Andvari nie chce oddac do za darmo. Mozesz zaplacic mu 1000 sztuk zlota lub go zabic.', 'Andvari', '1000Doswiadczenia');
INSERT INTO Zadania VALUES('Wampir', 'Na starym cmentarzystku zadomowil sie wampir. Od tej pory nikt nie czuje sie bezpiecznie. Pozbadz sie go a czeka Cie sowiata zaplata', 'Burmistrz', '1000Doswiadczenia,1PelerynaWampira');
INSERT INTO Zadania VALUES('Wandale w lesie', 'Podrozni przybywajacy do naszego baru wydaja sie zaniepokojeni. Okazalo sie, ze w naszym lesie grasuja wandale: smieca i podpalaja drzewa,napadaja na podroznych. Pozbadz sie ich', 'Lesnik', '100Doswiadczenia,1Luneta');
INSERT INTO Zadania VALUES('Wilki w Lesie', 'W lesie grasuja wilki, ktore zjadaja zwierzeta hodowlane i strasza podroznych. Przez nie nasza wioska upada! Pomoz w pozbyciu sie ich', 'Burmistrz Miasta', '100Doswiadczenia,100Zlota');
INSERT INTO Zadania VALUES('Wspaniala kolekcja', 'W naszej wiosce mieszka znany na caly swiat kolekcjoner! Ma najwieksza na swiecie kolekcje lalek. Pomoz mu poszerzyc ja o kolejna sztuke', 'Kolekcjoner', '10Doswiadczenia,100Zlota');
INSERT INTO Zadania VALUES('Zagadka', 'Loki moze dla Ciebie zdobyc Palantir ale musisz odpowiedziec na jego prosta zagadke', 'Loki', '10Doswiadczenia,1Palantir');
INSERT INTO Zadania VALUES('Zaginiony Mjonir', 'Thor zaginal Mjonir. Niedlugo pozniej dostal list od Thryma-to on go ukradl. W ramach okupu chce slub z piekna Freya. Moze by tak przebrac Thora za panne mloda? Zdobadz suknie slubna', 'Thor', '100Doswiadczenia');
INSERT INTO Zadania VALUES('Zatopiony skarb', 'Kraza pogloski, ze w naszej rzeczce jest zatopiony skarb. W rzece sa jednak topielce. Ale dla smialka czeka niewyobrazalna nagroda', 'Wetkarz', '1000Doswiadczenia,1HelmTopielcow');
INSERT INTO Zadania VALUES('Ziola', 'Pomoz starej zielarce uwarzyc eliksir zdrowia, ktory uleczy plage choroby. Choroba ta trawi Twoja kraine. Pozbieraj odpowiednie ziola.', 'Zielarka', '100Doswiadczenia,100Zlota1Zielnik');
INSERT INTO Zadania VALUES('Zmeczony Gosc', 'Do baru wpadl na chwile strudzony wedrowiec. Jest tak zmeczony, ze nie moze dalej isc. Zdobadz dla niego eliksir witalnosci by mogl wygodnie dotrzec do domu.', 'Wadrowiec', '100Doswiadczenia,1ButyWedrowca');

CREATE TABLE Zbroja(
    Nazwa VARCHAR(50) NOT NULL,
    PunktyAtaku INT NOT NULL,
    PunktyObrony INT NOT NULL,
    WymaganyPoziom INT NOT NULL,
    PunktyDoswiadczenia INT NOT NULL,
    Plik VARCHAR(50) NOT NULL,
    Klasa VARCHAR(50) NOT NULL,
    Typ VARCHAR(50) NOT NULL,
    PRIMARY KEY(Nazwa)
);

INSERT INTO Zbroja VALUES('ButyBlazna', 0, 70, 20, 50, 'blazenButy.png', 'mag', 'Buty');
INSERT INTO Zbroja VALUES('ButyDoZbroi', 0, 150, 50, 150, 'zbrojaButy.png', 'wojownik', 'Buty');
INSERT INTO Zbroja VALUES('ButyWedrowca', 0, 50, 5, 30, 'wedrowiecButy.png', 'wszystkieKlasy', 'Buty');
INSERT INTO Zbroja VALUES('ButyWiedzmy', 0, 100, 30, 70, 'wiedzmyButy.png', 'mag', 'Buty');
INSERT INTO Zbroja VALUES('DrewnianaRozczka', 50, 20, 1, 30, 'drewnianaRozczka.png', 'mag', 'Bron');
INSERT INTO Zbroja VALUES('DrewnianaTarcza', 10, 30, 1, 30, 'drewnianaTarcza.png', 'wojownik', 'Tarcza');
INSERT INTO Zbroja VALUES('DrewnianaTarczaZObiciem', 10, 30, 1, 30, 'drewnianaObicieTarcza.png', 'lotrzyk', 'Tarcza');
INSERT INTO Zbroja VALUES('FikusneButyZPomponem', 0, 150, 50, 150, 'fikusneButy.png', 'mag', 'Buty');
INSERT INTO Zbroja VALUES('GotyckieMitony', 50, 50, 5, 100, 'gotyckieMitony.png', 'wojownik', 'Rekawice');
INSERT INTO Zbroja VALUES('GotyckieRekawice', 100, 100, 30, 300, 'gotyckieRekawice.png', 'wojownik', 'Rekawice');
INSERT INTO Zbroja VALUES('HelmGladiatora', 0, 30, 5, 50, 'gladiatorHelm.png', 'wojownik', 'Helm');
INSERT INTO Zbroja VALUES('HelmOkularowy', 0, 30, 5, 50, 'okularowyHelm.png', 'lotrzyk', 'Helm');
INSERT INTO Zbroja VALUES('HelmRycerskiGermanski', 0, 100, 30, 300, 'rycerskiHelm.png', 'mag', 'Helm');
INSERT INTO Zbroja VALUES('HelmRzymski', 0, 150, 50, 400, 'rzymskiHelm.png', 'wojownik', 'Helm');
INSERT INTO Zbroja VALUES('HelmTopielcow', 0, 70, 20, 150, 'topielecHelm.png', 'mag', 'Helm');
INSERT INTO Zbroja VALUES('HelmZeSkrzydlami', 0, 30, 5, 50, 'skrzydlaHelm.png', 'mag', 'Helm');
INSERT INTO Zbroja VALUES('HelmZPrzylbica', 0, 150, 50, 400, 'przylbicaHelm.png', 'lotrzyk', 'Helm');
INSERT INTO Zbroja VALUES('HelmZRogami', 0, 100, 30, 300, 'rogiHelm.png', 'lotrzyk', 'Helm');
INSERT INTO Zbroja VALUES('HelmZSiatka', 0, 70, 20, 150, 'siatkaHelm.png', 'wojownik', 'Helm');
INSERT INTO Zbroja VALUES('LaskaMaga', 300, 200, 100, 200, 'magaLaska.png', 'mag', 'Bron');
INSERT INTO Zbroja VALUES('LaskaOgnia', 250, 170, 70, 150, 'ogniaLaska.png', 'mag', 'Bron');
INSERT INTO Zbroja VALUES('LekkaMetalowaTarcza', 20, 50, 5, 50, 'lekkaMetalowaTarcza.png', 'lotrzyk', 'Tarcza');
INSERT INTO Zbroja VALUES('LekkieSkorzaneButy', 0, 100, 30, 70, 'lekkieButy.png', 'lotrzyk', 'Buty');
INSERT INTO Zbroja VALUES('LodowaTarcza', 20, 50, 5, 50, 'lodowaTarcza.png', 'mag', 'Tarcza');
INSERT INTO Zbroja VALUES('MalySztylecik', 50, 20, 1, 30, 'malySztylecik.png', 'lotrzyk', 'Bron');
INSERT INTO Zbroja VALUES('MedalionSmoczeOko', 100, 70, 30, 300, 'smoczeOko.png', 'mag', 'Atrybuty');
INSERT INTO Zbroja VALUES('MetaloweMinetki', 150, 150, 50, 400, 'minetki.png', 'wojownik', 'Rekawice');
INSERT INTO Zbroja VALUES('MieczSpartanski', 150, 70, 30, 70, 'spartanskiMiecz.png', 'wojownik', 'Bron');
INSERT INTO Zbroja VALUES('Mithril', 50, 300, 70, 500, 'mithril.png', 'wojownik', 'Zbroja');
INSERT INTO Zbroja VALUES('MitonyMaksymiliany', 100, 100, 30, 300, 'maksMitony.png', 'lotrzyk', 'Rekawice');
INSERT INTO Zbroja VALUES('Mjonir', 500, 300, 150, 300, 'mjonir.png', 'wszystkieKlasy', 'Bron');
INSERT INTO Zbroja VALUES('Napiersnik', 20, 50, 5, 70, 'napiersnik.png', 'lotrzyk', 'Zbroja');
INSERT INTO Zbroja VALUES('NaszyjnikZZebowWilka', 30, 20, 1, 30, 'wilkNaszyjnik.png', 'wszystkieKlasy', 'Atrybuty');
INSERT INTO Zbroja VALUES('Ostrogi', 0, 150, 50, 150, 'ostrogi.png', 'lotrzyk', 'Buty');
INSERT INTO Zbroja VALUES('PelerynaWampira', 20, 50, 5, 70, 'pelerynaWampira.png', 'mag', 'Zbroja');
INSERT INTO Zbroja VALUES('PieknyZdobionyMiecz', 300, 200, 100, 200, 'zdobionyMiecz.png', 'wojownik', 'Bron');
INSERT INTO Zbroja VALUES('PlocienneButy', 0, 70, 20, 50, 'plocienneButy.png', 'lotrzyk', 'Buty');
INSERT INTO Zbroja VALUES('RekawicaThora', 200, 200, 70, 500, 'thorRekawice.png', 'wszystkieKlasy', 'Rekawice');
INSERT INTO Zbroja VALUES('RekawiceDoLokcia', 150, 150, 50, 400, 'lokiecRekawice.png', 'lotrzyk', 'Rekawice');
INSERT INTO Zbroja VALUES('RekawiceSaurona', 150, 150, 50, 400, 'sauronRekawice.png', 'mag', 'Rekawice');
INSERT INTO Zbroja VALUES('RoslinnaTarcza', 30, 100, 30, 70, 'roslinnaTarcza.png', 'mag', 'Tarcza');
INSERT INTO Zbroja VALUES('SiatkoweMitony', 50, 50, 5, 100, 'siatkoweMitony.png', 'mag', 'Rekawice');
INSERT INTO Zbroja VALUES('SiatkoweRekawice', 50, 50, 5, 100, 'siatkoweRekawice.png', 'lotrzyk', 'Rekawice');
INSERT INTO Zbroja VALUES('SkorzanaZbroja', 10, 30, 1, 30, 'skorzanaZbroja.png',  'wszystkieKlasy', 'Zbroja');
INSERT INTO Zbroja VALUES('SkorzaneRekawice', 30, 30, 1, 30, 'skorzaneRekawice.png', 'wszystkieKlasy', 'Rekawice');
INSERT INTO Zbroja VALUES('SkorzanyCzepek', 0, 20, 1, 30, 'skorzanyCzepek.png', 'wszystkieKlasy', 'Helm');
INSERT INTO Zbroja VALUES('SmoczaTarcza', 30, 100, 30, 70, 'smoczaTarcza.png', 'lotrzyk', 'Tarcza');
INSERT INTO Zbroja VALUES('SmoczySygnet', 50, 30, 5, 50, 'smoczySygnet.png', 'mag', 'Atrybuty');
INSERT INTO Zbroja VALUES('SnieznaLaska', 150, 70, 30, 70, 'snieznaLaska.png', 'mag', 'Bron');
INSERT INTO Zbroja VALUES('SygnetWKsztalcieWeza', 50, 30, 5, 50, 'wazSygnet.png', 'lotrzyk', 'Atrybuty');
INSERT INTO Zbroja VALUES('SygnetZHerbem', 50, 30, 5, 50, 'herbSygnet.png', 'wojownik', 'Atrybuty');
INSERT INTO Zbroja VALUES('SztyletPerski', 200, 100, 50, 100, 'perskiSztylet.png', 'lotrzyk', 'Bron');
INSERT INTO Zbroja VALUES('TarczaOgnia', 50, 150, 50, 100, 'ogniaTarcza.png', 'mag', 'Tarcza');
INSERT INTO Zbroja VALUES('TarczaZHerbem', 30, 100, 30, 70, 'herbTarcza.png', 'wojownik', 'Tarcza');
INSERT INTO Zbroja VALUES('WietrznaTarcza', 10, 30, 1, 30, 'wietrznaTarcza.png', 'mag', 'Tarcza');
INSERT INTO Zbroja VALUES('WisiorKwiatZycia', 100, 70, 30, 300, 'kwiatZycia.png', 'wojownik', 'Atrybuty');
INSERT INTO Zbroja VALUES('WisiorMlotThora', 200, 150, 70, 500, 'thorMlotaWisior.png', 'wszystkieKlasy', 'Atrybuty');
INSERT INTO Zbroja VALUES('WisiorWKsztalcieWeza', 100, 70, 30, 300, 'wazWisior.png', 'lotrzyk', 'Atrybuty');
INSERT INTO Zbroja VALUES('WysokieSkorzaneButy', 0, 100, 30, 70, 'wysokieButy.png', 'wojownik', 'Buty');
INSERT INTO Zbroja VALUES('WyszczerpionyMiecz', 50, 20, 1, 30, 'wyszczerbionyMiecz.png', 'wojownik', 'Bron');
INSERT INTO Zbroja VALUES('Zadlo', 250, 170, 70, 150, 'zadlo.png', 'lotrzyk', 'Bron');
INSERT INTO Zbroja VALUES('ZbrojaGladiatora', 20, 50, 5, 70, 'gladiatorZbroja.png', 'wojownik', 'Zbroja');
INSERT INTO Zbroja VALUES('ZbrojaHusarska', 40, 150, 50, 300, 'husarskaZbroja.png', 'wojownik', 'Zbroja');
INSERT INTO Zbroja VALUES('ZbrojaPlytowa', 30, 100, 30, 200, 'plytowaZbroja.png', 'wojownik', 'Zbroja');
INSERT INTO Zbroja VALUES('ZbrojaRycerzaSredniowiecznego', 40, 150, 50, 300, 'rycerzZbroja.png', 'lotrzyk', 'Zbroja');
INSERT INTO Zbroja VALUES('ZbrojaSiatkowa', 30, 100, 30, 200, 'siatkowaZbroja.png', 'lotrzyk', 'Zbroja');
INSERT INTO Zbroja VALUES('ZbrojaTemplariusza', 40, 150, 50, 300, 'templariuszZbroja.png', 'mag', 'Zbroja');
INSERT INTO Zbroja VALUES('ZdobionySztylet', 150, 70, 30, 70, 'zdobionySztylet.png', 'lotrzyk', 'Bron');
INSERT INTO Zbroja VALUES('ZlotyPierscienKrasnoludaAndvari', 150, 120, 50, 400, 'pierscienAndvari.png', 'wszystkieKlasy', 'Atrybuty');
INSERT INTO Zbroja VALUES('ZlotySygnetZGranatem', 70, 50, 20, 200, 'granatSygnet.png', 'wszystkieKlasy', 'Atrybuty');
INSERT INTO Zbroja VALUES('ZniszczoneButy', 0, 30, 1, 10, 'zniszczoneButy.png', 'wszystkieKlasy', 'Buty');
INSERT INTO Zbroja VALUES('ZwyklaLaskaMaga', 100, 50, 10, 50, 'zwyklaLaskaMaga.png', 'mag', 'Bron');
INSERT INTO Zbroja VALUES('ZwyklaMetalowaTarcza', 20, 50, 5, 50, 'zwyklaMetalowaTarcza.png', 'wojownik', 'Tarcza');
INSERT INTO Zbroja VALUES('ZwyklyMiecz', 100, 50, 10, 50, 'zwyklyMiecz.png', 'wojownik', 'Bron');
INSERT INTO Zbroja VALUES('ZwyklySztylet', 100, 50, 10, 50, 'zwyklySztylet.png', 'lotrzyk', 'Bron');

CREATE TABLE Ziola(
    Nazwa VARCHAR(50) NOT NULL,
    Polozenie VARCHAR(1000) NOT NULL,
    Opis VARCHAR(100) NOT NULL,
    Plik VARCHAR(50) NOT NULL,
    PRIMARY KEY(Nazwa)
);