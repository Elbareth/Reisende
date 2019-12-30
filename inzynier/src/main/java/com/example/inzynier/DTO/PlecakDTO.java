package com.example.inzynier.DTO;

import java.util.Objects;

public class PlecakDTO {
    private String nazwa;
    private Integer ilosc;

    public PlecakDTO(String nazwa, Integer ilosc) {
        this.nazwa = nazwa;
        this.ilosc = ilosc;
    }

    public PlecakDTO() {
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Integer getIlosc() {
        return ilosc;
    }

    public void setIlosc(Integer ilosc) {
        this.ilosc = ilosc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlecakDTO)) return false;
        PlecakDTO plecakDTO = (PlecakDTO) o;
        return getNazwa().equals(plecakDTO.getNazwa()) &&
                getIlosc().equals(plecakDTO.getIlosc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNazwa(), getIlosc());
    }

    @Override
    public String toString() {
        return "PlecakDTO{" +
                "nazwa='" + nazwa + '\'' +
                ", ilosc=" + ilosc +
                '}';
    }
}
