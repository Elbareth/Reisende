package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Meble {
    @Id
    @NotNull
    private String Nazwa;
    @NotNull
    private String Plik;
    @NotNull
    private String Kategoria;
    @NotNull
    private Integer Glod;
    @NotNull
    private Integer Sen;
    @NotNull
    private Integer Pragnienie;
    @NotNull
    private Integer Higiena;
    @NotNull
    private Integer Doswiadczenia;

    public Meble(@NotNull String nazwa, @NotNull String plik, @NotNull String kategoria, @NotNull Integer glod, @NotNull Integer pragnienie, @NotNull Integer sen, @NotNull Integer higiena, @NotNull Integer doswiadczenia) {
        Nazwa = nazwa;
        Plik = plik;
        Kategoria = kategoria;
        Glod = glod;
        Pragnienie = pragnienie;
        Sen = sen;
        Higiena = higiena;
        Doswiadczenia = doswiadczenia;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public String getPlik() {
        return Plik;
    }

    public void setPlik(String plik) {
        Plik = plik;
    }

    public String getKategoria() {
        return Kategoria;
    }

    public void setKategoria(String kategoria) {
        Kategoria = kategoria;
    }

    public Integer getGlod() {
        return Glod;
    }

    public void setGlod(Integer glod) {
        Glod = glod;
    }

    public Integer getPragnienie() {
        return Pragnienie;
    }

    public void setPragnienie(Integer pragnienie) {
        Pragnienie = pragnienie;
    }

    public Integer getSen() {
        return Sen;
    }

    public void setSen(Integer sen) {
        Sen = sen;
    }

    public Integer getHigiena() {
        return Higiena;
    }

    public void setHigiena(Integer higiena) {
        Higiena = higiena;
    }

    public Integer getDoswiadczenia() {
        return Doswiadczenia;
    }

    public void setDoswiadczenia(Integer doswiadczenia) {
        Doswiadczenia = doswiadczenia;
    }

    @Override
    public String toString() {
        return "Meble{" +
                "Nazwa='" + Nazwa + '\'' +
                ", Plik='" + Plik + '\'' +
                ", Kategoria='" + Kategoria + '\'' +
                ", Glod=" + Glod +
                ", Pragnienie=" + Pragnienie +
                ", Sen=" + Sen +
                ", Higiena=" + Higiena +
                ", Doswiadczenia=" + Doswiadczenia +
                '}';
    }
}
