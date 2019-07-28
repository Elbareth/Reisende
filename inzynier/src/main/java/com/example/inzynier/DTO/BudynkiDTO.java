package com.example.inzynier.DTO;

public class BudynkiDTO {
    private String nazwa;
    private String polozenie;
    private String wymiary;
    private String plik;

    public BudynkiDTO(String nazwa, String polozenie, String wymiary, String plik) {
        this.nazwa = nazwa;
        this.polozenie = polozenie;
        this.wymiary = wymiary;
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

    public String getWymiary() {
        return wymiary;
    }

    public void setWymiary(String wymiary) {
        this.wymiary = wymiary;
    }

    public String getPlik() {
        return plik;
    }

    public void setPlik(String plik) {
        this.plik = plik;
    }

    @Override
    public String toString() {
        return "BudynkiDTO{" +
                "nazwa='" + nazwa + '\'' +
                ", polozenie='" + polozenie + '\'' +
                ", wymiary='" + wymiary + '\'' +
                ", plik='" + plik + '\'' +
                '}';
    }
}
