package com.example.inzynier.DTO;

public class ZadaniaDTO {
    private String Nazwa;
    private String Tresc;
    private String Postać;
    private String Nagroda;

    public ZadaniaDTO(String nazwa, String tresc, String postać, String nagroda) {
        Nazwa = nazwa;
        Tresc = tresc;
        Postać = postać;
        Nagroda = nagroda;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public String getTresc() {
        return Tresc;
    }

    public void setTresc(String tresc) {
        Tresc = tresc;
    }

    public String getPostać() {
        return Postać;
    }

    public void setPostać(String postać) {
        Postać = postać;
    }

    public String getNagroda() {
        return Nagroda;
    }

    public void setNagroda(String nagroda) {
        Nagroda = nagroda;
    }

    @Override
    public String toString() {
        return "ZadaniaDTO{" +
                "Nazwa='" + Nazwa + '\'' +
                ", Tresc='" + Tresc + '\'' +
                ", Postać='" + Postać + '\'' +
                ", Nagroda='" + Nagroda + '\'' +
                '}';
    }
}
