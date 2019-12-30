package com.example.inzynier.DTO;

import java.util.Objects;

public class CzytanieDTO {
    private String ksiazka;

    public CzytanieDTO(String ksiazka) {
        this.ksiazka = ksiazka;
    }

    public CzytanieDTO() {
    }

    public String getKsiazka() {
        return ksiazka;
    }

    public void setKsiazka(String ksiazka) {
        this.ksiazka = ksiazka;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CzytanieDTO)) return false;
        CzytanieDTO that = (CzytanieDTO) o;
        return getKsiazka().equals(that.getKsiazka());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKsiazka());
    }

    @Override
    public String toString() {
        return "CzytanieDTO{" +
                "ksiazka='" + ksiazka + '\'' +
                '}';
    }
}
