package com.example.inzynier.DTO;

public class PostacDTO {
    private String Imie;
    private String Polozenie;
    private String Plik;

    public PostacDTO(String imie, String polozenie, String plik) {
        Imie = imie;
        Polozenie = polozenie;
        Plik = plik;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getPolozenie() {
        return Polozenie;
    }

    public void setPolozenie(String polozenie) {
        Polozenie = polozenie;
    }

    public String getPlik() {
        return Plik;
    }

    public void setPlik(String plik) {
        Plik = plik;
    }

    @Override
    public String toString() {
        return "PostacDTO{" +
                "Imie='" + Imie + '\'' +
                ", Polozenie='" + Polozenie + '\'' +
                ", Plik='" + Plik + '\'' +
                '}';
    }
}
