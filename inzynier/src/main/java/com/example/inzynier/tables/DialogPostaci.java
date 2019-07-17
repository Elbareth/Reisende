package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

//TODO Stworz dialog postaci
@Entity
public class DialogPostaci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @NotNull
    private String NazwaQuesta;
    @NotNull
    private String Postac;
    @NotNull
    private String Tekst;

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

    public DialogPostaci(@NotNull String nazwaQuesta, @NotNull String postac, @NotNull String tekst) {
        NazwaQuesta = nazwaQuesta;
        Postac = postac;
        Tekst = tekst;
    }

    @Override
    public String toString() {
        return "DialogPostaci{" +
                "ID=" + ID +
                ", NazwaQuesta='" + NazwaQuesta + '\'' +
                ", Postac='" + Postac + '\'' +
                ", Tekst='" + Tekst + '\'' +
                '}';
    }
}
