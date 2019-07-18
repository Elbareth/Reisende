package com.example.inzynier.DTO;

public class SmokDTO {
    private String Wlasciciel;
    private String Imie;
    private String Gatunek;
    private Integer PunktyZycia;
    private String Plik;

    public SmokDTO(String wlasciciel, String imie, String gatunek, Integer punktyZycia, String plik) {
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
        return "SmokDTO{" +
                "Wlasciciel='" + Wlasciciel + '\'' +
                ", Imie='" + Imie + '\'' +
                ", Gatunek='" + Gatunek + '\'' +
                ", PunktyZycia=" + PunktyZycia +
                ", Plik='" + Plik + '\'' +
                '}';
    }
}
