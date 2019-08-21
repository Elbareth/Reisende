package com.example.inzynier.tables;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name="d_bestie")
public class Bestie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String nazwa;
    @NotNull
    private String plik;
    @NotNull
    private String polozenie;
    @NotNull
    private String wymiary;

    public Bestie(@NotNull String nazwa, @NotNull String plik, @NotNull String polozenie, @NotNull String wymiary) {
        this.nazwa = nazwa;
        this.plik = plik;
        this.polozenie = polozenie;
        this.wymiary = wymiary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getPlik() {
        return plik;
    }

    public void setPlik(String plik) {
        this.plik = plik;
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

    @Override
    public String toString() {
        return "Bestie{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", plik='" + plik + '\'' +
                ", polozenie='" + polozenie + '\'' +
                ", wymiary='" + wymiary + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bestie bestie = (Bestie) o;
        return nazwa.equals(bestie.nazwa) &&
                plik.equals(bestie.plik) &&
                polozenie.equals(bestie.polozenie) &&
                wymiary.equals(bestie.wymiary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa,
                plik,
                polozenie,
                wymiary);
    }
}
