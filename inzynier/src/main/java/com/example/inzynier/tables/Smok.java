package com.example.inzynier.tables;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "d_smok")
public class Smok {
    @Id
    @NotNull
    private String wlasciciel;
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JoinColumn(name="login")
    private Uzytkownik uzytkownik;
    @NotNull
    private String imie;
    @NotNull
    private String gatunek;
    @NotNull
    @Column(name = "punkty_zycia")
    private Integer punktyZycia;
    @NotNull
    private String plik;

    public Smok(@NotNull String wlasciciel, Uzytkownik uzytkownik, @NotNull String imie, @NotNull String gatunek, @NotNull Integer punktyZycia, @NotNull String plik) {
        this.wlasciciel = wlasciciel;
        this.uzytkownik = uzytkownik;
        this.imie = imie;
        this.gatunek = gatunek;
        this.punktyZycia = punktyZycia;
        this.plik = plik;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(String wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public Integer getPunktyZycia() {
        return punktyZycia;
    }

    public void setPunktyZycia(Integer punktyZycia) {
        this.punktyZycia = punktyZycia;
    }

    public String getPlik() {
        return plik;
    }

    public void setPlik(String plik) {
        this.plik = plik;
    }

    @Override
    public String toString() {
        return "Smok{" +
                "wlasciciel='" + wlasciciel + '\'' +
                ", uzytkownik=" + uzytkownik +
                ", imie='" + imie + '\'' +
                ", gatunek='" + gatunek + '\'' +
                ", punktyZycia=" + punktyZycia +
                ", plik='" + plik + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Smok smok = (Smok) o;
        return wlasciciel.equals(smok.wlasciciel) &&
                uzytkownik.equals(smok.uzytkownik) &&
                imie.equals(smok.imie) &&
                gatunek.equals(smok.gatunek) &&
                punktyZycia.equals(smok.punktyZycia) &&
                plik.equals(smok.plik);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wlasciciel,
                uzytkownik,
                imie,
                gatunek,
                punktyZycia,
                plik);
    }
}
