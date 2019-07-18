package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Eliksir {
    @Id
    @NotNull
    private String Nazwa;
    @NotNull
    private Float Cena;
    @NotNull
    private String Plik;
    @NotNull
    private String Wlasciwosci;
    @NotNull
    private String Przepis;

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

    public String getWlasciwosci() {
        return Wlasciwosci;
    }

    public void setWlasciwosci(String wlasciwosci) {
        Wlasciwosci = wlasciwosci;
    }

    public String getPrzepis() {
        return Przepis;
    }

    public void setPrzepis(String przepis) {
        Przepis = przepis;
    }

    public Eliksir(@NotNull String nazwa, @NotNull Float cena, @NotNull String plik, @NotNull String wlasciwosci, @NotNull String przepis) {
        Nazwa = nazwa;
        Cena = cena;
        Plik = plik;
        Wlasciwosci = wlasciwosci;
        Przepis = przepis;
    }

    @Override
    public String toString() {
        return "Eliksir{" +
                "Nazwa='" + Nazwa + '\'' +
                ", Cena=" + Cena +
                ", Plik='" + Plik + '\'' +
                ", Wlasciwosci='" + Wlasciwosci + '\'' +
                ", Przepis='" + Przepis + '\'' +
                '}';
    }
}
