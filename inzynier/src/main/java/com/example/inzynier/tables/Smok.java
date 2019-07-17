package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Smok {
    @Id
    @NotNull
    private String Wlasciciel;
    @NotNull
    private String Imie;
    @NotNull
    private String Gatunek;
    @NotNull
    private Integer PunktyZycia;
    @NotNull
    private String Plik;

    public Smok(@NotNull String wlasciciel, @NotNull String imie, @NotNull String gatunek, @NotNull Integer punktyZycia, @NotNull String plik) {
        Wlasciciel = wlasciciel;
        Imie = imie;
        Gatunek = gatunek;
        PunktyZycia = punktyZycia;
        Plik = plik;
    }

    public String getWlasciciel() {
        return Wlasciciel;
    }

    public void setWlasciciel(String wlasciciel) {
        Wlasciciel = wlasciciel;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getGatunek() {
        return Gatunek;
    }

    public void setGatunek(String gatunek) {
        Gatunek = gatunek;
    }

    public Integer getPunktyZycia() {
        return PunktyZycia;
    }

    public void setPunktyZycia(Integer punktyZycia) {
        PunktyZycia = punktyZycia;
    }

    public String getPlik() {
        return Plik;
    }

    public void setPlik(String plik) {
        Plik = plik;
    }

    @Override
    public String toString() {
        return "Smok{" +
                "Wlasciciel='" + Wlasciciel + '\'' +
                ", Imie='" + Imie + '\'' +
                ", Gatunek='" + Gatunek + '\'' +
                ", PunktyZycia=" + PunktyZycia +
                ", Plik='" + Plik + '\'' +
                '}';
    }
}
