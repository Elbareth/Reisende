package com.example.inzynier.DTO;

public class KsiazkiDTO {
    private Integer Id;
    private String Nazwa;
    private String Tresc;
    private Integer Doswiadczenia;

    public KsiazkiDTO(String nazwa, String tresc, Integer doswiadczenia) {
        Nazwa = nazwa;
        Tresc = tresc;
        Doswiadczenia = doswiadczenia;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public Integer getDoswiadczenia() {
        return Doswiadczenia;
    }

    public void setDoswiadczenia(Integer doswiadczenia) {
        Doswiadczenia = doswiadczenia;
    }

    @Override
    public String toString() {
        return "KsiazkiDTO{" +
                "Id=" + Id +
                ", Nazwa='" + Nazwa + '\'' +
                ", Tresc='" + Tresc + '\'' +
                ", Doswiadczenia=" + Doswiadczenia +
                '}';
    }
}
