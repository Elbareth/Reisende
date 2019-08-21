package com.example.inzynier.DTO;

import java.util.Objects;

public class MebleDTO {
    private String nazwa;
    private String plik;
    private String kategoria;
    private Float cena;
    private Integer glod;
    private Integer sen;
    private Integer pragnienie;
    private Integer higiena;
    private Integer doswiadczenia;


    public MebleDTO(String nazwa, String plik, String kategoria,Float cena, Integer glod, Integer sen, Integer pragnienie, Integer higiena, Integer doswiadczenia) {
        this.nazwa = nazwa;
        this.plik = plik;
        this.kategoria = kategoria;
        this.cena = cena;
        this.glod = glod;
        this.sen = sen;
        this.pragnienie = pragnienie;
        this.higiena = higiena;
        this.doswiadczenia = doswiadczenia;
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

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public Integer getGlod() {
        return glod;
    }

    public void setGlod(Integer glod) {
        this.glod = glod;
    }

    public Integer getSen() {
        return sen;
    }

    public void setSen(Integer sen) {
        this.sen = sen;
    }

    public Integer getPragnienie() {
        return pragnienie;
    }

    public void setPragnienie(Integer pragnienie) {
        this.pragnienie = pragnienie;
    }

    public Integer getHigiena() {
        return higiena;
    }

    public void setHigiena(Integer higiena) {
        this.higiena = higiena;
    }

    public Integer getDoswiadczenia() {
        return doswiadczenia;
    }

    public void setDoswiadczenia(Integer doswiadczenia) {
        this.doswiadczenia = doswiadczenia;
    }

    public Float getCena() {
        return cena;
    }

    public void setCena(Float cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "MebleDTO{" +
                "nazwa='" + nazwa + '\'' +
                ", plik='" + plik + '\'' +
                ", kategoria='" + kategoria + '\'' +
                ", cena='" + cena + '\'' +
                ", glod=" + glod +
                ", sen=" + sen +
                ", pragnienie=" + pragnienie +
                ", higiena=" + higiena +
                ", doswiadczenia=" + doswiadczenia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MebleDTO mebleDTO = (MebleDTO) o;
        return nazwa.equals(mebleDTO.nazwa) &&
                plik.equals(mebleDTO.plik) &&
                kategoria.equals(mebleDTO.kategoria) &&
                cena.equals(mebleDTO.cena) &&
                glod.equals(mebleDTO.glod) &&
                sen.equals(mebleDTO.sen) &&
                pragnienie.equals(mebleDTO.pragnienie) &&
                higiena.equals(mebleDTO.higiena) &&
                doswiadczenia.equals(mebleDTO.doswiadczenia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa,
                plik,
                kategoria,
                cena,
                glod,
                sen,
                pragnienie,
                higiena,
                doswiadczenia);
    }
}
