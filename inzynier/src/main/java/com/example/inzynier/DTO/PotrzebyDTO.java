package com.example.inzynier.DTO;

import java.util.Objects;

public class PotrzebyDTO {
    private String glod;
    private String pragnienie;
    private String sen;
    private String higiena;

    public PotrzebyDTO(String glod, String pragnienie, String sen, String higiena) {
        this.glod = glod;
        this.pragnienie = pragnienie;
        this.sen = sen;
        this.higiena = higiena;
    }

    public PotrzebyDTO() {
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
        if (!(o instanceof PotrzebyDTO)) return false;
        PotrzebyDTO that = (PotrzebyDTO) o;
        return getGlod().equals(that.getGlod()) &&
                getPragnienie().equals(that.getPragnienie()) &&
                getSen().equals(that.getSen()) &&
                getHigiena().equals(that.getHigiena());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGlod(), getPragnienie(), getSen(), getHigiena());
    }

    @Override
    public String toString() {
        return "PotrzebyDTO{" +
                "glod='" + glod + '\'' +
                ", pragnienie='" + pragnienie + '\'' +
                ", sen='" + sen + '\'' +
                ", higiena='" + higiena + '\'' +
                '}';
    }
}
