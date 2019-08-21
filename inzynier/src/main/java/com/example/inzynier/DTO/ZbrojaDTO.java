package com.example.inzynier.DTO;

import java.util.Objects;

public class ZbrojaDTO {
    private String nazwa;
    private Integer punktyAtaku;
    private Integer punktyObrony;
    private Integer wymaganyPoziom;
    private Integer punktyDoswiadczenia;
    private String plik;
    private String klasa;
    private String typ;


    public ZbrojaDTO(String nazwa, Integer punktyAtaku, Integer punktyObrony, Integer wymaganyPoziom, Integer punktyDoswiadczenia, String plik, String klasa, String typ) {
        this.nazwa = nazwa;
        this.punktyAtaku = punktyAtaku;
        this.punktyObrony = punktyObrony;
        this.wymaganyPoziom = wymaganyPoziom;
        this.punktyDoswiadczenia = punktyDoswiadczenia;
        this.plik = plik;
        this.klasa = klasa;
        this.typ = typ;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Integer getPunktyAtaku() {
        return punktyAtaku;
    }

    public void setPunktyAtaku(Integer punktyAtaku) {
        this.punktyAtaku = punktyAtaku;
    }

    public Integer getPunktyObrony() {
        return punktyObrony;
    }

    public void setPunktyObrony(Integer punktyObrony) {
        this.punktyObrony = punktyObrony;
    }

    public Integer getWymaganyPoziom() {
        return wymaganyPoziom;
    }

    public void setWymaganyPoziom(Integer wymaganyPoziom) {
        this.wymaganyPoziom = wymaganyPoziom;
    }

    public Integer getPunktyDoswiadczenia() {
        return punktyDoswiadczenia;
    }

    public void setPunktyDoswiadczenia(Integer punktyDoswiadczenia) {
        this.punktyDoswiadczenia = punktyDoswiadczenia;
    }

    public String getPlik() {
        return plik;
    }

    public void setPlik(String plik) {
        this.plik = plik;
    }

    public String getKlasa() {
        return klasa;
    }

    public void setKlasa(String klasa) {
        this.klasa = klasa;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    @Override
    public String toString() {
        return "ZbrojaDTO{" +
                "nazwa='" + nazwa + '\'' +
                ", punktyAtaku=" + punktyAtaku +
                ", punktyObrony=" + punktyObrony +
                ", wymaganyPoziom=" + wymaganyPoziom +
                ", punktyDoswiadczenia=" + punktyDoswiadczenia +
                ", plik='" + plik + '\'' +
                ", klasa='" + klasa + '\'' +
                ", typ='" + typ + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZbrojaDTO zbrojaDTO = (ZbrojaDTO) o;
        return nazwa.equals(zbrojaDTO.nazwa) &&
                punktyAtaku.equals(zbrojaDTO.punktyAtaku) &&
                punktyObrony.equals(zbrojaDTO.punktyObrony) &&
                wymaganyPoziom.equals(zbrojaDTO.wymaganyPoziom) &&
                punktyDoswiadczenia.equals(zbrojaDTO.punktyDoswiadczenia) &&
                plik.equals(zbrojaDTO.plik) &&
                klasa.equals(zbrojaDTO.klasa) &&
                typ.equals(zbrojaDTO.typ);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa,
                punktyAtaku,
                punktyObrony,
                wymaganyPoziom,
                punktyDoswiadczenia,
                plik,
                klasa,
                typ);
    }
}
