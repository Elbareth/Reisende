package com.example.inzynier.tables;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    public Ksiazki(@NotNull String nazwa, @NotNull String tresc, @NotNull Integer doswiadczenia) {
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
        return "Ksiazki{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", tresc='" + tresc + '\'' +
                ", doswiadczenia=" + doswiadczenia +
                '}';
    }
}
