package com.example.inzynier.DTO;

public class DialogPostaciDTO {
    private Integer ID;
    private String NazwaQuesta;
    private String Postac;
    private String Tekst;

    public DialogPostaciDTO(String nazwaQuesta, String postac, String tekst) {
        NazwaQuesta = nazwaQuesta;
        Postac = postac;
        Tekst = tekst;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNazwaQuesta() {
        return NazwaQuesta;
    }

    public void setNazwaQuesta(String nazwaQuesta) {
        NazwaQuesta = nazwaQuesta;
    }

    public String getPostac() {
        return Postac;
    }

    public void setPostac(String postac) {
        Postac = postac;
    }

    public String getTekst() {
        return Tekst;
    }

    public void setTekst(String tekst) {
        Tekst = tekst;
    }

    @Override
    public String toString() {
        return "DialogPostaciDTO{" +
                "ID=" + ID +
                ", NazwaQuesta='" + NazwaQuesta + '\'' +
                ", Postac='" + Postac + '\'' +
                ", Tekst='" + Tekst + '\'' +
                '}';
    }
}
