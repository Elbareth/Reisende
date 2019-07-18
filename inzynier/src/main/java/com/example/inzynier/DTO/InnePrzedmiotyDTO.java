package com.example.inzynier.DTO;

public class InnePrzedmiotyDTO {
    private String Nazwa;
    private Float Cena;
    private String Plik;
    private String Opis;

    public InnePrzedmiotyDTO(String nazwa, Float cena, String plik, String opis) {
        Nazwa = nazwa;
        Cena = cena;
        Plik = plik;
        Opis = opis;
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

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String opis) {
        Opis = opis;
    }

    @Override
    public String toString() {
        return "InnePrzedmiotyDTO{" +
                "Nazwa='" + Nazwa + '\'' +
                ", Cena=" + Cena +
                ", Plik='" + Plik + '\'' +
                ", Opis='" + Opis + '\'' +
                '}';
    }
}
