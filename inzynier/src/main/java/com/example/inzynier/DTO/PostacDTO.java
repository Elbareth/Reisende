package com.example.inzynier.DTO;

import java.util.Objects;

public class PostacDTO {
    private String imie;
    private String polozenie;
    private String plik;

    public PostacDTO(String imie, String polozenie, String plik) {
        this.imie = imie;
        this.polozenie = polozenie;
        this.plik = plik;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getPolozenie() {
        return polozenie;
    }

    public void setPolozenie(String polozenie) {
        this.polozenie = polozenie;
    }

    public String getPlik() {
        return plik;
    }

    public void setPlik(String plik) {
        this.plik = plik;
    }

    @Override
    public String toString() {
        return "PostacDTO{" +
                "imie='" + imie + '\'' +
                ", polozenie='" + polozenie + '\'' +
                ", plik='" + plik + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostacDTO postacDTO = (PostacDTO) o;
        return imie.equals(postacDTO.imie) &&
                polozenie.equals(postacDTO.polozenie) &&
                plik.equals(postacDTO.plik);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie,
                polozenie,
                plik);
    }
}
