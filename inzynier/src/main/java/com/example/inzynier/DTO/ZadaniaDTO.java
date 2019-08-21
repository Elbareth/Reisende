package com.example.inzynier.DTO;

import java.util.Objects;

public class ZadaniaDTO {
    private String nazwa;
    private String tresc;
    private PostacDTO postac;
    private String nagroda;

    public ZadaniaDTO(String nazwa, String tresc, PostacDTO postac, String nagroda) {
        this.nazwa = nazwa;
        this.tresc = tresc;
        this.postac = postac;
        this.nagroda = nagroda;
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

    public PostacDTO getPostac() {
        return postac;
    }

    public void setPostac(PostacDTO postac) {
        this.postac = postac;
    }

    public String getNagroda() {
        return nagroda;
    }

    public void setNagroda(String nagroda) {
        this.nagroda = nagroda;
    }

    @Override
    public String toString() {
        return "ZadaniaDTO{" +
                "nazwa='" + nazwa + '\'' +
                ", tresc='" + tresc + '\'' +
                ", postac=" + postac +
                ", nagroda='" + nagroda + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZadaniaDTO that = (ZadaniaDTO) o;
        return nazwa.equals(that.nazwa) &&
                tresc.equals(that.tresc) &&
                postac.equals(that.postac) &&
                nagroda.equals(that.nagroda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa,
                tresc,
                postac,
                nagroda);
    }
}
