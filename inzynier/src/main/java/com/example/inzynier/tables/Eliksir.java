package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "d_eliksir")
public class Eliksir {
    @Id
    @NotNull
    private String nazwa;
    @NotNull
    private Float cena;
    @NotNull
    private String plik;
    @NotNull
    private String wlasciwosci;
    @NotNull
    private String przepis;

    public Eliksir(@NotNull String nazwa, @NotNull Float cena, @NotNull String plik, @NotNull String wlasciwosci, @NotNull String przepis) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.plik = plik;
        this.wlasciwosci = wlasciwosci;
        this.przepis = przepis;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Float getCena() {
        return cena;
    }

    public void setCena(Float cena) {
        this.cena = cena;
    }

    public String getPlik() {
        return plik;
    }

    public void setPlik(String plik) {
        this.plik = plik;
    }

    public String getWlasciwosci() {
        return wlasciwosci;
    }

    public void setWlasciwosci(String wlasciwosci) {
        this.wlasciwosci = wlasciwosci;
    }

    public String getPrzepis() {
        return przepis;
    }

    public void setPrzepis(String przepis) {
        this.przepis = przepis;
    }

    @Override
    public String toString() {
        return "Eliksir{" +
                "nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                ", plik='" + plik + '\'' +
                ", wlasciwosci='" + wlasciwosci + '\'' +
                ", przepis='" + przepis + '\'' +
                '}';
    }
}
