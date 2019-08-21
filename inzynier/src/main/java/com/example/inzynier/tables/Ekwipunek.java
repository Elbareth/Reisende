package com.example.inzynier.tables;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

//TODO OneToOne nie shared key!!!
@Entity
@Table(name = "d_ekwipunek")
public class Ekwipunek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @OneToOne
    @JoinColumn(name="login")
    private Uzytkownik wlasciciel;
    @NotNull
    private String nazwa;
    @NotNull
    private String plik;
    @NotNull
    private String opis;

    public Ekwipunek(@NotNull Uzytkownik wlasciciel, @NotNull String nazwa, @NotNull String plik, @NotNull String opis) {
        this.wlasciciel = wlasciciel;
        this.nazwa = nazwa;
        this.plik = plik;
        this.opis = opis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Uzytkownik getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(Uzytkownik wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
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
        return "Ekwipunek{" +
                "id=" + id +
                ", wlasciciel=" + wlasciciel +
                ", nazwa='" + nazwa + '\'' +
                ", plik='" + plik + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ekwipunek ekwipunek = (Ekwipunek) o;
        return wlasciciel.equals(ekwipunek.wlasciciel) &&
                nazwa.equals(ekwipunek.nazwa) &&
                plik.equals(ekwipunek.plik) &&
                opis.equals(ekwipunek.opis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wlasciciel,
                nazwa,
                plik,
                opis);
    }
}
