package com.example.inzynier.DTO;

public class QuestyDTO {
    private Integer Id;
    private String Postac;
    private String Wykonujacy;
    private String NoweZadanie;
    private String Tresc;
    private String Nagroda;
    private Boolean CzyWykonane;

    public QuestyDTO(String postac, String wykonujacy, String noweZadanie, String tresc, String nagroda, Boolean czyWykonane) {
        Postac = postac;
        Wykonujacy = wykonujacy;
        NoweZadanie = noweZadanie;
        Tresc = tresc;
        Nagroda = nagroda;
        CzyWykonane = czyWykonane;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getPostac() {
        return Postac;
    }

    public void setPostac(String postac) {
        Postac = postac;
    }

    public String getWykonujacy() {
        return Wykonujacy;
    }

    public void setWykonujacy(String wykonujacy) {
        Wykonujacy = wykonujacy;
    }

    public String getNoweZadanie() {
        return NoweZadanie;
    }

    public void setNoweZadanie(String noweZadanie) {
        NoweZadanie = noweZadanie;
    }

    public String getTresc() {
        return Tresc;
    }

    public void setTresc(String tresc) {
        Tresc = tresc;
    }

    public String getNagroda() {
        return Nagroda;
    }

    public void setNagroda(String nagroda) {
        Nagroda = nagroda;
    }

    public Boolean getCzyWykonane() {
        return CzyWykonane;
    }

    public void setCzyWykonane(Boolean czyWykonane) {
        CzyWykonane = czyWykonane;
    }

    @Override
    public String toString() {
        return "QuestyDTO{" +
                "Id=" + Id +
                ", Postac='" + Postac + '\'' +
                ", Wykonujacy='" + Wykonujacy + '\'' +
                ", NoweZadanie='" + NoweZadanie + '\'' +
                ", Tresc='" + Tresc + '\'' +
                ", Nagroda='" + Nagroda + '\'' +
                ", CzyWykonane=" + CzyWykonane +
                '}';
    }
}
