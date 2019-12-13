package com.example.inzynier.DTO;

import java.util.Objects;

public class BudynkiDTO {
    private String nazwa;
    private String plansza;
    private String polozenieX;
    private String polozenieY;
    private String wymiary;
    private String plik;

    public BudynkiDTO(String nazwa, String plansza, String polozenieX, String polozenieY, String wymiary, String plik) {
        this.nazwa = nazwa;
        this.plansza = plansza;
        this.polozenieX = polozenieX;
        this.polozenieY = polozenieY;
        this.wymiary = wymiary;
        this.plik = plik;
    }

    public BudynkiDTO() {
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getPlansza() {
        return plansza;
    }

    public void setPlansza(String plansza) {
        this.plansza = plansza;
    }

    public String getPolozenieX() {
        return polozenieX;
    }

    public void setPolozenieX(String polozenieX) {
        this.polozenieX = polozenieX;
    }

    public String getPolozenieY() {
        return polozenieY;
    }

    public void setPolozenieY(String polozenieY) {
        this.polozenieY = polozenieY;
    }

    public String getWymiary() {
        return wymiary;
    }

    public void setWymiary(String wymiary) {
        this.wymiary = wymiary;
    }

    public String getPlik() {
        return plik;
    }

    public void setPlik(String plik) {
        this.plik = plik;
    }

    @Override
    public String toString() {
        return "BudynkiDTO{" +
                "nazwa='" + nazwa + '\'' +
                ", plansza='" + plansza + '\'' +
                ", polozenieX='" + polozenieX + '\'' +
                ", polozenieY='" + polozenieY + '\'' +
                ", wymiary='" + wymiary + '\'' +
                ", plik='" + plik + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BudynkiDTO)) return false;
        BudynkiDTO that = (BudynkiDTO) o;
        return getNazwa().equals(that.getNazwa()) &&
                getPlansza().equals(that.getPlansza()) &&
                getPolozenieX().equals(that.getPolozenieX()) &&
                getPolozenieY().equals(that.getPolozenieY()) &&
                getWymiary().equals(that.getWymiary()) &&
                getPlik().equals(that.getPlik());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNazwa(), getPlansza(), getPolozenieX(), getPolozenieY(), getWymiary(), getPlik());
    }
}
