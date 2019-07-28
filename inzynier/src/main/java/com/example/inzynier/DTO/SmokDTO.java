package com.example.inzynier.DTO;

public class SmokDTO {
    private String wlasciciel;
    private String imie;
    private String gatunek;
    private Integer punktyZycia;
    private String plik;

    public SmokDTO(String wlasciciel, String imie, String gatunek, Integer punktyZycia, String plik) {
        this.wlasciciel = wlasciciel;
        this.imie = imie;
        this.gatunek = gatunek;
        this.punktyZycia = punktyZycia;
        this.plik = plik;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(String wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public Integer getPunktyZycia() {
        return punktyZycia;
    }

    public void setPunktyZycia(Integer punktyZycia) {
        this.punktyZycia = punktyZycia;
    }

    public String getPlik() {
        return plik;
    }

    public void setPlik(String plik) {
        this.plik = plik;
    }

    @Override
    public String toString() {
        return "SmokDTO{" +
                "wlasciciel='" + wlasciciel + '\'' +
                ", imie='" + imie + '\'' +
                ", gatunek='" + gatunek + '\'' +
                ", punktyZycia=" + punktyZycia +
                ", plik='" + plik + '\'' +
                '}';
    }
}
