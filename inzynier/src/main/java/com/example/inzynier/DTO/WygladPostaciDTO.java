package com.example.inzynier.DTO;

public class WygladPostaciDTO {
    private Integer Id;
    private String Nazwa;
    private String Klasa;
    private String Plik;
    private String Kategoria;

    public WygladPostaciDTO(String nazwa, String klasa, String plik, String kategoria) {
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
        return "WygladPostaciDTO{" +
                "Id=" + Id +
                ", Nazwa='" + Nazwa + '\'' +
                ", Klasa='" + Klasa + '\'' +
                ", Plik='" + Plik + '\'' +
                ", Kategoria='" + Kategoria + '\'' +
                '}';
    }
}
