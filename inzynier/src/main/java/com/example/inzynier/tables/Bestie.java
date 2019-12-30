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
    private Integer sila;

    public Bestie(Integer id, @NotNull String nazwa, @NotNull String plik, @NotNull String polozenie, @NotNull Integer sila) {
        this.id = id;
        this.nazwa = nazwa;
        this.plik = plik;
        this.polozenie = polozenie;
        this.sila = sila;
    }

    public Bestie(@NotNull String nazwa, @NotNull String plik, @NotNull String polozenie, @NotNull Integer sila) {
        this.nazwa = nazwa;
        this.plik = plik;
        this.polozenie = polozenie;
        this.sila = sila;
    }

    public Bestie() {
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

    public Integer getSila() {
        return sila;
    }

    public void setSila(Integer sila) {
        this.sila = sila;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bestie)) return false;
        Bestie bestie = (Bestie) o;
        return getId().equals(bestie.getId()) &&
                getNazwa().equals(bestie.getNazwa()) &&
                getPlik().equals(bestie.getPlik()) &&
                getPolozenie().equals(bestie.getPolozenie()) &&
                getSila().equals(bestie.getSila());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNazwa(), getPlik(), getPolozenie(), getSila());
    }

    @Override
    public String toString() {
        return "Bestie{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", plik='" + plik + '\'' +
                ", polozenie='" + polozenie + '\'' +
                ", sila=" + sila +
                '}';
    }
}
