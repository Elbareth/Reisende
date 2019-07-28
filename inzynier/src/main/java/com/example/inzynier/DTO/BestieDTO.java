package com.example.inzynier.DTO;

public class BestieDTO {
    private Integer id;
    private String nazwa;
    private String plik;
    private String polozenie;
    private String wymiary;

    public BestieDTO(String nazwa, String plik, String polozenie, String wymiary) {
        this.nazwa = nazwa;
        this.plik = plik;
        this.polozenie = polozenie;
        this.wymiary = wymiary;
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

    public String getPlik() {
        return plik;
    }

    public void setPlik(String plik) {
        this.plik = plik;
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

    @Override
    public String toString() {
        return "BestieDTO{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", plik='" + plik + '\'' +
                ", polozenie='" + polozenie + '\'' +
                ", wymiary='" + wymiary + '\'' +
                '}';
    }
}
