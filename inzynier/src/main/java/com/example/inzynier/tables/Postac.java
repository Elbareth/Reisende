package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "d_postac")
public class Postac {
    @Id
    @NotNull
    private String imie;
    @NotNull
    private String polozenie;
    @NotNull
    private String plik;

    public Postac(@NotNull String imie, @NotNull String polozenie, @NotNull String plik) {
        this.imie = imie;
        this.polozenie = polozenie;
        this.plik = plik;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getPolozenie() {
        return polozenie;
    }

    public void setPolozenie(String polozenie) {
        this.polozenie = polozenie;
    }

    public String getPlik() {
        return plik;
    }

    @Override
    public String toString() {
        return "Postac{" +
                "imie='" + imie + '\'' +
                ", polozenie='" + polozenie + '\'' +
                ", plik='" + plik + '\'' +
                '}';
    }

    public void setPlik(String plik) {
        this.plik = plik;
    }
}
