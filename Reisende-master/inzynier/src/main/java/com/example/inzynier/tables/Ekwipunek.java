package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Ekwipunek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @NotNull
    private String Wlasciciel;
    @NotNull
    private String Nazwa;
    @NotNull
    private String Plik;
    @NotNull
    private String Opis;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getWlasciciel() {
        return Wlasciciel;
    }

    public void setWlasciciel(String wlasciciel) {
        Wlasciciel = wlasciciel;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
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

    public Ekwipunek(@NotNull String wlasciciel, @NotNull String nazwa, @NotNull String plik, @NotNull String opis) {
        Wlasciciel = wlasciciel;
        Nazwa = nazwa;
        Plik = plik;
        Opis = opis;
    }

    @Override
    public String toString() {
        return "Ekwipunek{" +
                "ID=" + ID +
                ", Wlasciciel='" + Wlasciciel + '\'' +
                ", Nazwa='" + Nazwa + '\'' +
                ", Plik='" + Plik + '\'' +
                ", Opis='" + Opis + '\'' +
                '}';
    }
}
