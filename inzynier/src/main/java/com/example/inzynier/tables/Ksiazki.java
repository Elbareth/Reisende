package com.example.inzynier.tables;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "d_ksiazki")
public class Ksiazki {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String nazwa;
    @NotNull
    private String tresc;
    @NotNull
    private Integer doswiadczenia;


    public Ksiazki(Integer id, @NotNull String nazwa, @NotNull String tresc, @NotNull Integer doswiadczenia) {
        this.id = id;
        this.nazwa = nazwa;
        this.tresc = tresc;
        this.doswiadczenia = doswiadczenia;
    }

    public Ksiazki(@NotNull String nazwa, @NotNull String tresc, @NotNull Integer doswiadczenia) {
        this.nazwa = nazwa;
        this.tresc = tresc;
        this.doswiadczenia = doswiadczenia;
    }

    public Ksiazki() {
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
        return "Ksiazki{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", tresc='" + tresc + '\'' +
                ", doswiadczenia=" + doswiadczenia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ksiazki ksiazki = (Ksiazki) o;
        return nazwa.equals(ksiazki.nazwa) &&
                tresc.equals(ksiazki.tresc) &&
                doswiadczenia.equals(ksiazki.doswiadczenia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa,
                tresc,
                doswiadczenia);
    }
}
