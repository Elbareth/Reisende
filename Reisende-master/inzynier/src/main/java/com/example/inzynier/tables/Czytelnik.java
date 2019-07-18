package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Czytelnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @NotNull
    private String Tytul;
    @NotNull
    private String Czytelnik;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTytul() {
        return Tytul;
    }

    public void setTytul(String tytul) {
        Tytul = tytul;
    }

    public String getCzytelnik() {
        return Czytelnik;
    }

    public void setCzytelnik(String czytelnik) {
        Czytelnik = czytelnik;
    }

    public Czytelnik(@NotNull String tytul, @NotNull String czytelnik) {
        Tytul = tytul;
        Czytelnik = czytelnik;
    }

    @Override
    public String toString() {
        return "Czytelnik{" +
                "ID=" + ID +
                ", Tytul='" + Tytul + '\'' +
                ", Czytelnik='" + Czytelnik + '\'' +
                '}';
    }
}
