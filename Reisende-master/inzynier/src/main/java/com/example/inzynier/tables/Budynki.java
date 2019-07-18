package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Budynki {
    @Id
    @NotNull
    private String Nazwa;
    @NotNull
    private String Polozenie;
    @NotNull
    private String Wymiary;
    @NotNull
    private String Plik;

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public String getPolozenie() {
        return Polozenie;
    }

    public void setPolozenie(String polozenie) {
        Polozenie = polozenie;
    }

    public String getWymiary() {
        return Wymiary;
    }

    public void setWymiary(String wymiary) {
        Wymiary = wymiary;
    }

    public String getPlik() {
        return Plik;
    }

    public void setPlik(String plik) {
        Plik = plik;
    }

    public Budynki(@NotNull String nazwa, @NotNull String polozenie, @NotNull String wymiary, @NotNull String plik) {
        Nazwa = nazwa;
        Polozenie = polozenie;
        Wymiary = wymiary;
        Plik = plik;
    }

    @Override
    public String toString() {
        return "Budynki{" +
                "Nazwa='" + Nazwa + '\'' +
                ", Polozenie='" + Polozenie + '\'' +
                ", Wymiary='" + Wymiary + '\'' +
                ", Plik='" + Plik + '\'' +
                '}';
    }
}
