package com.example.inzynier.DTO;

import java.util.List;
import java.util.Objects;

public class BestieDTO {
    private Integer id;
    private String nazwa;
    private String plik;
    private List<String> plansza;
    private List<Integer> polozenieX;
    private List<Integer> polozenieY;
    private Integer sila;

    public BestieDTO(Integer id, String nazwa, String plik, List<String> plansza, List<Integer> polozenieX, List<Integer> polozenieY, Integer sila) {
        this.id = id;
        this.nazwa = nazwa;
        this.plik = plik;
        this.plansza = plansza;
        this.polozenieX = polozenieX;
        this.polozenieY = polozenieY;
        this.sila = sila;
    }

    public BestieDTO(String nazwa, String plik, List<String> plansza, List<Integer> polozenieX, List<Integer> polozenieY, Integer sila) {
        this.nazwa = nazwa;
        this.plik = plik;
        this.plansza = plansza;
        this.polozenieX = polozenieX;
        this.polozenieY = polozenieY;
        this.sila = sila;
    }

    public BestieDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getPlik() {
        return plik;
    }

    public void setPlik(String plik) {
        this.plik = plik;
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

    public Integer getSila() {
        return sila;
    }

    public void setSila(Integer sila) {
        this.sila = sila;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BestieDTO)) return false;
        BestieDTO bestieDTO = (BestieDTO) o;
        return getId().equals(bestieDTO.getId()) &&
                getNazwa().equals(bestieDTO.getNazwa()) &&
                getPlik().equals(bestieDTO.getPlik()) &&
                getPlansza().equals(bestieDTO.getPlansza()) &&
                getPolozenieX().equals(bestieDTO.getPolozenieX()) &&
                getPolozenieY().equals(bestieDTO.getPolozenieY()) &&
                getSila().equals(bestieDTO.getSila());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNazwa(), getPlik(), getPlansza(), getPolozenieX(), getPolozenieY(), getSila());
    }

    @Override
    public String toString() {
        return "BestieDTO{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", plik='" + plik + '\'' +
                ", plansza=" + plansza +
                ", polozenieX=" + polozenieX +
                ", polozenieY=" + polozenieY +
                ", sila=" + sila +
                '}';
    }
}
