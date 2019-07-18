package com.example.inzynier.DTO;

public class EkwipunekDTO {
    private Integer ID;
    private String Wlasciciel;
    private String Nazwa;
    private String Plik;
    private String Opis;

    public EkwipunekDTO(String wlasciciel, String nazwa, String plik, String opis) {
        Wlasciciel = wlasciciel;
        Nazwa = nazwa;
        Plik = plik;
        Opis = opis;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getWlasciciel() {
        return Wlasciciel;
    }

    public void setWlasciciel(String wlasciciel) {
        Wlasciciel = wlasciciel;
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

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String opis) {
        Opis = opis;
    }

    @Override
    public String toString() {
        return "EkwipunekDTO{" +
                "ID=" + ID +
                ", Wlasciciel='" + Wlasciciel + '\'' +
                ", Nazwa='" + Nazwa + '\'' +
                ", Plik='" + Plik + '\'' +
                ", Opis='" + Opis + '\'' +
                '}';
    }
}
