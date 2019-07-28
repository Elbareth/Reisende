package com.example.inzynier.DTO;

public class EliksirDTO {
    private String nazwa;
    private Float cena;
    private String plik;
    private String wlasciwosci;
    private String przepis;

    public EliksirDTO(String nazwa, Float cena, String plik, String wlasciwosci, String przepis) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.plik = plik;
        this.wlasciwosci = wlasciwosci;
        this.przepis = przepis;
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

    public String getWlasciwosci() {
        return wlasciwosci;
    }

    public void setWlasciwosci(String wlasciwosci) {
        this.wlasciwosci = wlasciwosci;
    }

    public String getPrzepis() {
        return przepis;
    }

    public void setPrzepis(String przepis) {
        this.przepis = przepis;
    }

    @Override
    public String toString() {
        return "EliksirDTO{" +
                "nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                ", plik='" + plik + '\'' +
                ", wlasciwosci='" + wlasciwosci + '\'' +
                ", przepis='" + przepis + '\'' +
                '}';
    }
}
