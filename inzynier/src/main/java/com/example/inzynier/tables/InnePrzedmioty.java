package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class InnePrzedmioty {
    @Id
    @NotNull
    private String Nazwa;
    @NotNull
    private Float Cena;
    @NotNull
    private String Plik;
    @NotNull
    private String Opis;

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public Float getCena() {
        return Cena;
    }

    public void setCena(Float cena) {
        Cena = cena;
    }

    public String getPlik() {
        return Plik;
    }

    public void setPlik(String plik) {
        Plik = plik;
    }

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String opis) {
        Opis = opis;
    }

    public InnePrzedmioty(@NotNull String nazwa, @NotNull Float cena, @NotNull String plik, @NotNull String opis) {
        Nazwa = nazwa;
        Cena = cena;
        Plik = plik;
        Opis = opis;
    }

    @Override
    public String toString() {
        return "InnePrzedmioty{" +
                "Nazwa='" + Nazwa + '\'' +
                ", Cena=" + Cena +
                ", Plik='" + Plik + '\'' +
                ", Opis='" + Opis + '\'' +
                '}';
    }
}
