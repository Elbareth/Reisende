package com.example.inzynier.DTO;

public class ZiolaDTO {
    private String Nazwa;
    private String Polozenie;
    private String Opis;
    private String Plik;

    public ZiolaDTO(String nazwa, String polozenie, String opis, String plik) {
        Nazwa = nazwa;
        Polozenie = polozenie;
        Opis = opis;
        Plik = plik;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public String getPolozenie() {
        return Polozenie;
    }

    public void setPolozenie(String polozenie) {
        Polozenie = polozenie;
    }

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String opis) {
        Opis = opis;
    }

    public String getPlik() {
        return Plik;
    }

    public void setPlik(String plik) {
        Plik = plik;
    }

    @Override
    public String toString() {
        return "ZiolaDTO{" +
                "Nazwa='" + Nazwa + '\'' +
                ", Polozenie='" + Polozenie + '\'' +
                ", Opis='" + Opis + '\'' +
                ", Plik='" + Plik + '\'' +
                '}';
    }
}
