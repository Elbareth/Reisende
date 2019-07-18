package com.example.inzynier.DTO;

public class ZbrojaDTO {
    private String Nazwa;
    private Integer PunktyAtaku;
    private Integer PunktyObrony;
    private Integer WymaganyPoziom;
    private Integer PunktyDoswiadczenia;
    private String Plik;
    private String Klasa;
    private String Typ;

    public ZbrojaDTO(String nazwa, Integer punktyAtaku, Integer punktyObrony, Integer wymaganyPoziom, Integer punktyDoswiadczenia, String plik, String klasa, String typ) {
        Nazwa = nazwa;
        PunktyAtaku = punktyAtaku;
        PunktyObrony = punktyObrony;
        WymaganyPoziom = wymaganyPoziom;
        PunktyDoswiadczenia = punktyDoswiadczenia;
        Plik = plik;
        Klasa = klasa;
        Typ = typ;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public Integer getPunktyAtaku() {
        return PunktyAtaku;
    }

    public void setPunktyAtaku(Integer punktyAtaku) {
        PunktyAtaku = punktyAtaku;
    }

    public Integer getPunktyObrony() {
        return PunktyObrony;
    }

    public void setPunktyObrony(Integer punktyObrony) {
        PunktyObrony = punktyObrony;
    }

    public Integer getWymaganyPoziom() {
        return WymaganyPoziom;
    }

    public void setWymaganyPoziom(Integer wymaganyPoziom) {
        WymaganyPoziom = wymaganyPoziom;
    }

    public Integer getPunktyDoswiadczenia() {
        return PunktyDoswiadczenia;
    }

    public void setPunktyDoswiadczenia(Integer punktyDoswiadczenia) {
        PunktyDoswiadczenia = punktyDoswiadczenia;
    }

    public String getPlik() {
        return Plik;
    }

    public void setPlik(String plik) {
        Plik = plik;
    }

    public String getKlasa() {
        return Klasa;
    }

    public void setKlasa(String klasa) {
        Klasa = klasa;
    }

    public String getTyp() {
        return Typ;
    }

    public void setTyp(String typ) {
        Typ = typ;
    }

    @Override
    public String toString() {
        return "ZbrojaDTO{" +
                "Nazwa='" + Nazwa + '\'' +
                ", PunktyAtaku=" + PunktyAtaku +
                ", PunktyObrony=" + PunktyObrony +
                ", WymaganyPoziom=" + WymaganyPoziom +
                ", PunktyDoswiadczenia=" + PunktyDoswiadczenia +
                ", Plik='" + Plik + '\'' +
                ", Klasa='" + Klasa + '\'' +
                ", Typ='" + Typ + '\'' +
                '}';
    }
}
