package com.example.inzynier.tables;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Questy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @NotNull
    private String Postac;
    @NotNull
    private String Wykonujacy;
    @NotNull
    private String NoweZadanie;
    @NotNull
    private String Tresc;
    @NotNull
    private String Nagroda;
    @NotNull
    private Boolean CzyWykonane;

    public Questy(@NotNull String postac, @NotNull String wykonujacy, @NotNull String noweZadanie, @NotNull String tresc, @NotNull String nagroda, @NotNull Boolean czyWykonane) {
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
        return "Questy{" +
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
