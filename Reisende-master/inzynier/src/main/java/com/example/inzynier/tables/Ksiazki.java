package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Ksiazki {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @NotNull
    private String Nazwa;
    @NotNull
    private String Tresc;
    @NotNull
    private Integer Doswiadczenia;

    public Ksiazki(@NotNull String nazwa, @NotNull String tresc, @NotNull Integer doswiadczenia) {
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
        return "Ksiazki{" +
                "Id=" + Id +
                ", Nazwa='" + Nazwa + '\'' +
                ", Tresc='" + Tresc + '\'' +
                ", Doswiadczenia=" + Doswiadczenia +
                '}';
    }
}
