package com.example.inzynier.DTO;

public class BestieDTO {
    private Integer ID;
    private String Nazwa;
    private String Plik;
    private String Polozenie;
    private String Wymiary;

    public BestieDTO(String nazwa, String plik, String polozenie, String wymiary) {
        Nazwa = nazwa;
        Plik = plik;
        Polozenie = polozenie;
        Wymiary = wymiary;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public String getPlik() {
        return Plik;
    }

    public void setPlik(String plik) {
        Plik = plik;
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

    @Override
    public String toString() {
        return "BestieDTO{" +
                "ID=" + ID +
                ", Nazwa='" + Nazwa + '\'' +
                ", Plik='" + Plik + '\'' +
                ", Polozenie='" + Polozenie + '\'' +
                ", Wymiary='" + Wymiary + '\'' +
                '}';
    }
}
