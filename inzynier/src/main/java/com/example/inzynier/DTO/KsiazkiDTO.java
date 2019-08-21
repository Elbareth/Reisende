package com.example.inzynier.DTO;

import java.util.Objects;

public class KsiazkiDTO {
    private Integer id;
    private String nazwa;
    private String tresc;
    private Integer doswiadczenia;

    public KsiazkiDTO(String nazwa, String tresc, Integer doswiadczenia) {
        this.nazwa = nazwa;
        this.tresc = tresc;
        this.doswiadczenia = doswiadczenia;
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

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Integer getDoswiadczenia() {
        return doswiadczenia;
    }

    public void setDoswiadczenia(Integer doswiadczenia) {
        this.doswiadczenia = doswiadczenia;
    }

    @Override
    public String toString() {
        return "KsiazkiDTO{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", tresc='" + tresc + '\'' +
                ", doswiadczenia=" + doswiadczenia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KsiazkiDTO that = (KsiazkiDTO) o;
        return nazwa.equals(that.nazwa) &&
                tresc.equals(that.tresc) &&
                doswiadczenia.equals(that.doswiadczenia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa,
                tresc,
                doswiadczenia);
    }
}
