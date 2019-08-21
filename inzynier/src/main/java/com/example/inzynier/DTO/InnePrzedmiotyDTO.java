package com.example.inzynier.DTO;

import java.util.Objects;

public class InnePrzedmiotyDTO {
    private String nazwa;
    private Float cena;
    private String plik;
    private String opis;


    public InnePrzedmiotyDTO(String nazwa, Float cena, String plik, String opis) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.plik = plik;
        this.opis = opis;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Float getCena() {
        return cena;
    }

    public void setCena(Float cena) {
        this.cena = cena;
    }

    public String getPlik() {
        return plik;
    }

    public void setPlik(String plik) {
        this.plik = plik;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "InnePrzedmiotyDTO{" +
                "nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                ", plik='" + plik + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InnePrzedmiotyDTO that = (InnePrzedmiotyDTO) o;
        return nazwa.equals(that.nazwa) &&
                cena.equals(that.cena) &&
                plik.equals(that.plik) &&
                opis.equals(that.opis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa,
                cena,
                plik,
                opis);
    }
}
