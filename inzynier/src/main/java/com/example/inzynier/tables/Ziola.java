package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "d_ziola")
public class Ziola {
    @Id
    @NotNull
    private String nazwa;
    @NotNull
    private String polozenie;
    @NotNull
    private String opis;
    @NotNull
    private String plik;

    public Ziola(@NotNull String nazwa, @NotNull String polozenie, @NotNull String opis, @NotNull String plik) {
        this.nazwa = nazwa;
        this.polozenie = polozenie;
        this.opis = opis;
        this.plik = plik;
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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getPlik() {
        return plik;
    }

    public void setPlik(String plik) {
        this.plik = plik;
    }

    @Override
    public String toString() {
        return "Ziola{" +
                "nazwa='" + nazwa + '\'' +
                ", polozenie='" + polozenie + '\'' +
                ", opis='" + opis + '\'' +
                ", plik='" + plik + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ziola ziola = (Ziola) o;
        return nazwa.equals(ziola.nazwa) &&
                polozenie.equals(ziola.polozenie) &&
                opis.equals(ziola.opis) &&
                plik.equals(ziola.plik);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa,
                polozenie,
                opis,
                plik);
    }
}
