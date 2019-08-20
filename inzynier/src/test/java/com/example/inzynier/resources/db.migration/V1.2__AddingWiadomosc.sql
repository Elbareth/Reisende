CREATE TABLE d_wiadomosci(
    id INT NOT NULL AUTO_INCREMENT,
    nadawca VARCHAR(50) NOT NULL,
    odbiorca VARCHAR(50) NOT NULL,
    tytul VARCHAR(50) NOT NULL,
    tresc VARCHAR(1000) NOT NULL,
    data DATETIME NOT NULL,
    PRIMARY KEY(id)
);