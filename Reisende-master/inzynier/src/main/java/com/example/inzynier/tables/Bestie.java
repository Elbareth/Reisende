package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Bestie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @NotNull
    private String Nazwa;
    @NotNull
    private String Plik;
    @NotNull
    private String Polozenie;
    @NotNull
    private String Wymiary;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public String getPlik() {
        return Plik;
    }

    public void setPlik(String plik) {
        Plik = plik;
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

    public Bestie(@NotNull String nazwa, @NotNull String plik, @NotNull String polozenie, @NotNull String wymiary) {
        Nazwa = nazwa;
        Plik = plik;
        Polozenie = polozenie;
        Wymiary = wymiary;
    }

    @Override
    public String toString() {
        return "Bestie{" +
                "ID=" + ID +
                ", Nazwa='" + Nazwa + '\'' +
                ", Plik='" + Plik + '\'' +
                ", Polozenie='" + Polozenie + '\'' +
                ", Wymiary='" + Wymiary + '\'' +
                '}';
    }
}
