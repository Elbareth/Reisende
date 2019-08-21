package com.example.inzynier.tables;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "d_wyglad_postaci")
public class WygladPostaci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String nazwa;
    @NotNull
    private String klasa;
    @NotNull
    private String plik;
    @NotNull
    private String kategoria;

    public WygladPostaci(@NotNull String nazwa, @NotNull String klasa, @NotNull String plik, @NotNull String kategoria) {
        this.nazwa = nazwa;
        this.klasa = klasa;
        this.plik = plik;
        this.kategoria = kategoria;
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

    public String getKlasa() {
        return klasa;
    }

    public void setKlasa(String klasa) {
        this.klasa = klasa;
    }

    public String getPlik() {
        return plik;
    }

    public void setPlik(String plik) {
        this.plik = plik;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    @Override
    public String toString() {
        return "WygladPostaci{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", klasa='" + klasa + '\'' +
                ", plik='" + plik + '\'' +
                ", kategoria='" + kategoria + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WygladPostaci that = (WygladPostaci) o;
        return nazwa.equals(that.nazwa) &&
                klasa.equals(that.klasa) &&
                plik.equals(that.plik) &&
                kategoria.equals(that.kategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa,
                klasa,
                plik,
                kategoria);
    }
}
