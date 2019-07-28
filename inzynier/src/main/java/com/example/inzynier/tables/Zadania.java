package com.example.inzynier.tables;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//TODO UWAGA MAnyTOOne!!
@Entity
@Table(name = "d_zadania")
public class Zadania {
    @Id
    @NotNull
    private String nazwa;
    @NotNull
    private String tresc;
    @NotNull
    @ManyToOne
    @JoinColumn(name="imie")
    private Postac postac;
    @NotNull
    private String nagroda;

    public Zadania(@NotNull String nazwa, @NotNull String tresc, @NotNull Postac postac, @NotNull String nagroda) {
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

    public Postac getPostac() {
        return postac;
    }

    public void setPostac(Postac postac) {
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
        return "Zadania{" +
                "nazwa='" + nazwa + '\'' +
                ", tresc='" + tresc + '\'' +
                ", postac=" + postac +
                ", nagroda='" + nagroda + '\'' +
                '}';
    }
}
