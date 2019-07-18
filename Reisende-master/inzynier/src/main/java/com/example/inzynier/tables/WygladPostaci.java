package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class WygladPostaci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @NotNull
    private String Nazwa;
    @NotNull
    private String Klasa;
    @NotNull
    private String Plik;
    @NotNull
    private String Kategoria;

    public WygladPostaci(String nazwa, String klasa, String plik, String kategoria) {
        Nazwa = nazwa;
        Klasa = klasa;
        Plik = plik;
        Kategoria = kategoria;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public String getKlasa() {
        return Klasa;
    }

    public void setKlasa(String klasa) {
        Klasa = klasa;
    }

    public String getPlik() {
        return Plik;
    }

    public void setPlik(String plik) {
        Plik = plik;
    }

    public String getKategoria() {
        return Kategoria;
    }

    public void setKategoria(String kategoria) {
        Kategoria = kategoria;
    }

    @Override
    public String toString() {
        return "WygladPostaci{" +
                "Id=" + Id +
                ", Nazwa='" + Nazwa + '\'' +
                ", Klasa='" + Klasa + '\'' +
                ", Plik='" + Plik + '\'' +
                ", Kategoria='" + Kategoria + '\'' +
                '}';
    }
}
