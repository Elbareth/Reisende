package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Zbroja {
    @Id
    @NotNull
    private String Nazwa;
    @NotNull
    private Integer PunktyAtaku;
    @NotNull
    private Integer PunktyObrony;
    @NotNull
    private Integer WymaganyPoziom;
    @NotNull
    private Integer PunktyDoswiadczenia;
    @NotNull
    private String Plik;
    @NotNull
    private String Klasa;
    @NotNull
    private String Typ;

    public Zbroja(@NotNull String nazwa, @NotNull Integer punktyAtaku, @NotNull Integer punktyObrony, @NotNull Integer wymaganyPoziom, @NotNull Integer punktyDoswiadczenia, @NotNull String plik, @NotNull String klasa, @NotNull String typ) {
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
        return "Zbroja{" +
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
