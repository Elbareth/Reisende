package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "d_meble")
public class Meble {
    @Id
    @NotNull
    private String nazwa;
    @NotNull
    private String plik;
    @NotNull
    private String kategoria;
    @NotNull
    private Float cena;
    @NotNull
    private Integer glod;
    @NotNull
    private Integer sen;
    @NotNull
    private Integer pragnienie;
    @NotNull
    private Integer higiena;
    @NotNull
    private Integer doswiadczenia;

    public Meble(@NotNull String nazwa, @NotNull String plik, @NotNull String kategoria,@NotNull Float cena, @NotNull Integer glod, @NotNull Integer sen, @NotNull Integer pragnienie, @NotNull Integer higiena, @NotNull Integer doswiadczenia) {
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
        return "Meble{" +
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
        Meble meble = (Meble) o;
        return nazwa.equals(meble.nazwa) &&
                plik.equals(meble.plik) &&
                kategoria.equals(meble.kategoria) &&
                cena.equals(meble.cena) &&
                glod.equals(meble.glod) &&
                sen.equals(meble.sen) &&
                pragnienie.equals(meble.pragnienie) &&
                higiena.equals(meble.higiena) &&
                doswiadczenia.equals(meble.doswiadczenia);
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
