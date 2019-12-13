package com.example.inzynier.DTO;

import java.util.Objects;

public class WyswietlMebleDTO {
    private String plik;
    private String wymiarX;
    private String wymiarY;
    private String kategoria;
    private String glod;
    private String pragnienie;
    private String sen;
    private String higiena;

    public WyswietlMebleDTO(String plik, String wymiarX, String wymiarY, String kategoria, String glod, String pragnienie, String sen, String higiena) {
        this.plik = plik;
        this.wymiarX = wymiarX;
        this.wymiarY = wymiarY;
        this.kategoria = kategoria;
        this.glod = glod;
        this.pragnienie = pragnienie;
        this.sen = sen;
        this.higiena = higiena;
    }

    public WyswietlMebleDTO() {
    }

    public String getPlik() {
        return plik;
    }

    public void setPlik(String plik) {
        this.plik = plik;
    }

    public String getWymiarX() {
        return wymiarX;
    }

    public void setWymiarX(String wymiarX) {
        this.wymiarX = wymiarX;
    }

    public String getWymiarY() {
        return wymiarY;
    }

    public void setWymiarY(String wymiarY) {
        this.wymiarY = wymiarY;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getGlod() {
        return glod;
    }

    public void setGlod(String glod) {
        this.glod = glod;
    }

    public String getPragnienie() {
        return pragnienie;
    }

    public void setPragnienie(String pragnienie) {
        this.pragnienie = pragnienie;
    }

    public String getSen() {
        return sen;
    }

    public void setSen(String sen) {
        this.sen = sen;
    }

    public String getHigiena() {
        return higiena;
    }

    public void setHigiena(String higiena) {
        this.higiena = higiena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WyswietlMebleDTO)) return false;
        WyswietlMebleDTO that = (WyswietlMebleDTO) o;
        return getPlik().equals(that.getPlik()) &&
                getWymiarX().equals(that.getWymiarX()) &&
                getWymiarY().equals(that.getWymiarY()) &&
                getKategoria().equals(that.getKategoria()) &&
                getGlod().equals(that.getGlod()) &&
                getPragnienie().equals(that.getPragnienie()) &&
                getSen().equals(that.getSen()) &&
                getHigiena().equals(that.getHigiena());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlik(), getWymiarX(), getWymiarY(), getKategoria(), getGlod(), getPragnienie(), getSen(), getHigiena());
    }

    @Override
    public String toString() {
        return "WyswietlMebleDTO{" +
                "plik='" + plik + '\'' +
                ", wymiarX='" + wymiarX + '\'' +
                ", wymiarY='" + wymiarY + '\'' +
                ", kategoria='" + kategoria + '\'' +
                ", glod='" + glod + '\'' +
                ", pragnienie='" + pragnienie + '\'' +
                ", sen='" + sen + '\'' +
                ", higiena='" + higiena + '\'' +
                '}';
    }
}
