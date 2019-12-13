package com.example.inzynier.DTO;

import java.util.Objects;

public class WygladPostaciDTO {
    private Integer id;
    private String nazwa;
    private String klasa;
    private String plik;
    private String kategoria;

    public WygladPostaciDTO(Integer id, String nazwa, String klasa, String plik, String kategoria) {
        this.id = id;
        this.nazwa = nazwa;
        this.klasa = klasa;
        this.plik = plik;
        this.kategoria = kategoria;
    }

    public WygladPostaciDTO(String nazwa, String klasa, String plik, String kategoria) {
        this.nazwa = nazwa;
        this.klasa = klasa;
        this.plik = plik;
        this.kategoria = kategoria;
    }

    public WygladPostaciDTO() {
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
        return "WygladPostaciDTO{" +
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
        WygladPostaciDTO that = (WygladPostaciDTO) o;
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
