package com.example.inzynier.DTO;

import java.util.List;
import java.util.Objects;

public class ZiolaDTO {
    private String nazwa;
    private List<String> plansza;
    private List<Integer> polozenieX;
    private List<Integer> polozenieY;
    private String opis;
    private String plik;

    public ZiolaDTO(String nazwa, List<String> plansza, List<Integer> polozenieX, List<Integer> polozenieY, String opis, String plik) {
        this.nazwa = nazwa;
        this.plansza = plansza;
        this.polozenieX = polozenieX;
        this.polozenieY = polozenieY;
        this.opis = opis;
        this.plik = plik;
    }

    public ZiolaDTO() {
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<String> getPlansza() {
        return plansza;
    }

    public void setPlansza(List<String> plansza) {
        this.plansza = plansza;
    }

    public List<Integer> getPolozenieX() {
        return polozenieX;
    }

    public void setPolozenieX(List<Integer> polozenieX) {
        this.polozenieX = polozenieX;
    }

    public List<Integer> getPolozenieY() {
        return polozenieY;
    }

    public void setPolozenieY(List<Integer> polozenieY) {
        this.polozenieY = polozenieY;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getPlik() {
        return plik;
    }

    public void setPlik(String plik) {
        this.plik = plik;
    }

    @Override
    public String toString() {
        return "ZiolaDTO{" +
                "nazwa='" + nazwa + '\'' +
                ", plansza=" + plansza +
                ", polozenieX=" + polozenieX +
                ", polozenieY=" + polozenieY +
                ", opis='" + opis + '\'' +
                ", plik='" + plik + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ZiolaDTO)) return false;
        ZiolaDTO ziolaDTO = (ZiolaDTO) o;
        return getNazwa().equals(ziolaDTO.getNazwa()) &&
                getPlansza().equals(ziolaDTO.getPlansza()) &&
                getPolozenieX().equals(ziolaDTO.getPolozenieX()) &&
                getPolozenieY().equals(ziolaDTO.getPolozenieY()) &&
                getOpis().equals(ziolaDTO.getOpis()) &&
                getPlik().equals(ziolaDTO.getPlik());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNazwa(), getPlansza(), getPolozenieX(), getPolozenieY(), getOpis(), getPlik());
    }
}
