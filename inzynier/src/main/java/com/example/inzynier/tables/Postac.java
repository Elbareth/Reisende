package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Postac {
    @Id
    @NotNull
    private String Imie;
    @NotNull
    private String Polozenie;
    @NotNull
    private String Plik;

    public Postac(@NotNull String imie, @NotNull String polozenie, @NotNull String plik) {
        Imie = imie;
        Polozenie = polozenie;
        Plik = plik;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getPolozenie() {
        return Polozenie;
    }

    public void setPolozenie(String polozenie) {
        Polozenie = polozenie;
    }

    public String getPlik() {
        return Plik;
    }

    public void setPlik(String plik) {
        Plik = plik;
    }

    @Override
    public String toString() {
        return "Postac{" +
                "Imie='" + Imie + '\'' +
                ", Polozenie='" + Polozenie + '\'' +
                ", Plik='" + Plik + '\'' +
                '}';
    }
}
