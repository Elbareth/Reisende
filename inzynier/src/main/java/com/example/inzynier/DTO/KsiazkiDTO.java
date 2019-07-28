package com.example.inzynier.DTO;

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
}
