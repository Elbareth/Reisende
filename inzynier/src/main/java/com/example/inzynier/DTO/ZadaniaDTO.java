package com.example.inzynier.DTO;

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
}
