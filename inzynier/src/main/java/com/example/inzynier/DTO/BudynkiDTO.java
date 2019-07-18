package com.example.inzynier.DTO;

public class BudynkiDTO {
    private String Nazwa;
    private String Polozenie;
    private String Wymiary;
    private String Plik;

    public BudynkiDTO(String nazwa, String polozenie, String wymiary, String plik) {
        Nazwa = nazwa;
        Polozenie = polozenie;
        Wymiary = wymiary;
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

    public String getWymiary() {
        return Wymiary;
    }

    public void setWymiary(String wymiary) {
        Wymiary = wymiary;
    }

    public String getPlik() {
        return Plik;
    }

    public void setPlik(String plik) {
        Plik = plik;
    }

    @Override
    public String toString() {
        return "BudynkiDTO{" +
                "Nazwa='" + Nazwa + '\'' +
                ", Polozenie='" + Polozenie + '\'' +
                ", Wymiary='" + Wymiary + '\'' +
                ", Plik='" + Plik + '\'' +
                '}';
    }
}
