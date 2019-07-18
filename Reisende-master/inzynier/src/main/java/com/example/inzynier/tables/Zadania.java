package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Zadania {
    @Id
    @NotNull
    private String Nazwa;
    @NotNull
    private String Tresc;
    @NotNull
    private String Postać;
    @NotNull
    private String Nagroda;

    public Zadania(@NotNull String nazwa, @NotNull String tresc, @NotNull String postać, @NotNull String nagroda) {
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
        return "Zadania{" +
                "Nazwa='" + Nazwa + '\'' +
                ", Tresc='" + Tresc + '\'' +
                ", Postać='" + Postać + '\'' +
                ", Nagroda='" + Nagroda + '\'' +
                '}';
    }
}
