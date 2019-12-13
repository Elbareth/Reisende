package com.example.inzynier.DTO;

import java.util.Objects;

public class PostacDTO {
    private String imie;
    private String plansza;
    private Integer polozenieX;
    private Integer polozenieY;
    private String plik;

    public PostacDTO(String imie, String plansza, Integer polozenieX, Integer polozenieY, String plik) {
        this.imie = imie;
        this.plansza = plansza;
        this.polozenieX = polozenieX;
        this.polozenieY = polozenieY;
        this.plik = plik;
    }

    public PostacDTO() {
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public Integer getPolozenieX() {
        return polozenieX;
    }

    public void setPolozenieX(Integer polozenieX) {
        this.polozenieX = polozenieX;
    }

    public Integer getPolozenieY() {
        return polozenieY;
    }

    public void setPolozenieY(Integer polozenieY) {
        this.polozenieY = polozenieY;
    }

    public String getPlik() {
        return plik;
    }

    public void setPlik(String plik) {
        this.plik = plik;
    }

    public String getPlansza() {
        return plansza;
    }

    public void setPlansza(String plansza) {
        this.plansza = plansza;
    }

    @Override
    public String toString() {
        return "PostacDTO{" +
                "imie='" + imie + '\'' +
                ", plansza='" + plansza + '\'' +
                ", polozenieX=" + polozenieX +
                ", polozenieY=" + polozenieY +
                ", plik='" + plik + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostacDTO)) return false;
        PostacDTO postacDTO = (PostacDTO) o;
        return getImie().equals(postacDTO.getImie()) &&
                getPlansza().equals(postacDTO.getPlansza()) &&
                getPolozenieX().equals(postacDTO.getPolozenieX()) &&
                getPolozenieY().equals(postacDTO.getPolozenieY()) &&
                getPlik().equals(postacDTO.getPlik());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getImie(), getPlansza(), getPolozenieX(), getPolozenieY(), getPlik());
    }
}
