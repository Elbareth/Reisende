package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "d_inne_przedmioty")
public class InnePrzedmioty {
    @Id
    @NotNull
    private String nazwa;
    @NotNull
    private Float cena;
    @NotNull
    private String plik;
    @NotNull
    private String opis;

    public InnePrzedmioty(@NotNull String nazwa, @NotNull Float cena, @NotNull String plik, @NotNull String opis) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.plik = plik;
        this.opis = opis;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Float getCena() {
        return cena;
    }

    public void setCena(Float cena) {
        this.cena = cena;
    }

    public String getPlik() {
        return plik;
    }

    public void setPlik(String plik) {
        this.plik = plik;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "InnePrzedmioty{" +
                "nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                ", plik='" + plik + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }
}
