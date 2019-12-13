package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name="d_budynki")
public class Budynki {
    @Id
    @NotNull
    private String nazwa;
    @NotNull
    private String polozenie;
    @NotNull
    private String wymiary;
    @NotNull
    private String plik;

    public Budynki(@NotNull String nazwa, @NotNull String polozenie, @NotNull String wymiary, @NotNull String plik) {
        this.nazwa = nazwa;
        this.polozenie = polozenie;
        this.wymiary = wymiary;
        this.plik = plik;
    }

    public Budynki() {
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getPolozenie() {
        return polozenie;
    }

    public void setPolozenie(String polozenie) {
        this.polozenie = polozenie;
    }

    public String getWymiary() {
        return wymiary;
    }

    public void setWymiary(String wymiary) {
        this.wymiary = wymiary;
    }

    public String getPlik() {
        return plik;
    }

    public void setPlik(String plik) {
        this.plik = plik;
    }

    @Override
    public String toString() {
        return "Budynki{" +
                "nazwa='" + nazwa + '\'' +
                ", polozenie='" + polozenie + '\'' +
                ", wymiary='" + wymiary + '\'' +
                ", plik='" + plik + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Budynki budynki = (Budynki) o;
        return nazwa.equals(budynki.nazwa) &&
                polozenie.equals(budynki.polozenie) &&
                wymiary.equals(budynki.wymiary) &&
                plik.equals(budynki.plik);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa,
                polozenie,
                wymiary,
                plik);
    }
}
