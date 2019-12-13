package com.example.inzynier.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "d_zbroja")
public class Zbroja {
    @Id
    @NotNull
    private String nazwa;
    @NotNull
    @Column(name = "punkty_ataku")
    private Integer punktyAtaku;
    @NotNull
    @Column(name = "punkty_obrony")
    private Integer punktyObrony;
    @NotNull
    @Column(name = "wymagany_poziom")
    private Integer wymaganyPoziom;
    @NotNull
    @Column(name = "punkty_doswiadczenia")
    private Integer punktyDoswiadczenia;
    @NotNull
    private String plik;
    @NotNull
    private String klasa;
    @NotNull
    private String typ;

    public Zbroja(@NotNull String nazwa, @NotNull Integer punktyAtaku, @NotNull Integer punktyObrony, @NotNull Integer wymaganyPoziom, @NotNull Integer punktyDoswiadczenia, @NotNull String plik, @NotNull String klasa, @NotNull String typ) {
        this.nazwa = nazwa;
        this.punktyAtaku = punktyAtaku;
        this.punktyObrony = punktyObrony;
        this.wymaganyPoziom = wymaganyPoziom;
        this.punktyDoswiadczenia = punktyDoswiadczenia;
        this.plik = plik;
        this.klasa = klasa;
        this.typ = typ;
    }

    public Zbroja() {
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
        return "Zbroja{" +
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
        Zbroja zbroja = (Zbroja) o;
        return nazwa.equals(zbroja.nazwa) &&
                punktyAtaku.equals(zbroja.punktyAtaku) &&
                punktyObrony.equals(zbroja.punktyObrony) &&
                wymaganyPoziom.equals(zbroja.wymaganyPoziom) &&
                punktyDoswiadczenia.equals(zbroja.punktyDoswiadczenia) &&
                plik.equals(zbroja.plik) &&
                klasa.equals(zbroja.klasa) &&
                typ.equals(zbroja.typ);
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
