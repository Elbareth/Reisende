package com.example.inzynier.DTO;

public class EliksirDTO {
    private String Nazwa;
    private Float Cena;
    private String Plik;
    private String Wlasciwosci;
    private String Przepis;

    public EliksirDTO(String nazwa, Float cena, String plik, String wlasciwosci, String przepis) {
        Nazwa = nazwa;
        Cena = cena;
        Plik = plik;
        Wlasciwosci = wlasciwosci;
        Przepis = przepis;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public Float getCena() {
        return Cena;
    }

    public void setCena(Float cena) {
        Cena = cena;
    }

    public String getPlik() {
        return Plik;
    }

    public void setPlik(String plik) {
        Plik = plik;
    }

    public String getWlasciwosci() {
        return Wlasciwosci;
    }

    public void setWlasciwosci(String wlasciwosci) {
        Wlasciwosci = wlasciwosci;
    }

    public String getPrzepis() {
        return Przepis;
    }

    public void setPrzepis(String przepis) {
        Przepis = przepis;
    }

    @Override
    public String toString() {
        return "EliksirDTO{" +
                "Nazwa='" + Nazwa + '\'' +
                ", Cena=" + Cena +
                ", Plik='" + Plik + '\'' +
                ", Wlasciwosci='" + Wlasciwosci + '\'' +
                ", Przepis='" + Przepis + '\'' +
                '}';
    }
}
