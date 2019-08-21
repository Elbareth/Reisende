package com.example.inzynier.DTO;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmokDTO smokDTO = (SmokDTO) o;
        return wlasciciel.equals(smokDTO.wlasciciel) &&
                imie.equals(smokDTO.imie) &&
                gatunek.equals(smokDTO.gatunek) &&
                punktyZycia.equals(smokDTO.punktyZycia) &&
                plik.equals(smokDTO.plik);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wlasciciel,
                imie,
                gatunek,
                punktyZycia,
                plik);
    }
}
