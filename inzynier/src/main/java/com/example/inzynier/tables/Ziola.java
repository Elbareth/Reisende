package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Ziola {
    @Id
    @NotNull
    private String Nazwa;
    @NotNull
    private String Polozenie;
    @NotNull
    private String Opis;
    @NotNull
    private String Plik;

    public Ziola(@NotNull String nazwa, @NotNull String polozenie, @NotNull String opis, @NotNull String plik) {
        Nazwa = nazwa;
        Polozenie = polozenie;
        Opis = opis;
        Plik = plik;
    }

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

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String opis) {
        Opis = opis;
    }

    public String getPlik() {
        return Plik;
    }

    public void setPlik(String plik) {
        Plik = plik;
    }

    @Override
    public String toString() {
        return "Ziola{" +
                "Nazwa='" + Nazwa + '\'' +
                ", Polozenie='" + Polozenie + '\'' +
                ", Opis='" + Opis + '\'' +
                ", Plik='" + Plik + '\'' +
                '}';
    }
}
