package com.example.inzynier.DTO;

public class ZiolaDTO {
    private String nazwa;
    private String polozenie;
    private String opis;
    private String plik;


    public ZiolaDTO(String nazwa, String polozenie, String opis, String plik) {
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
        return "ZiolaDTO{" +
                "nazwa='" + nazwa + '\'' +
                ", polozenie='" + polozenie + '\'' +
                ", opis='" + opis + '\'' +
                ", plik='" + plik + '\'' +
                '}';
    }
}
