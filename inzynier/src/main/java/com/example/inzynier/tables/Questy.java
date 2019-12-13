package com.example.inzynier.tables;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

//TODO UWAGA ManyToOne!!!
@Entity
@Table(name = "d_questy")
public class Questy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @ManyToOne
    @JoinColumn(name="postac", referencedColumnName = "imie")
    private Postac postac;
    @NotNull
    @ManyToOne
    @JoinColumn(name="wykonujacy", referencedColumnName = "login")
    private Uzytkownik wykonujacy;
    @NotNull
    @Column(name = "nowe_zadanie")
    private String noweZadanie;
    @NotNull
    private String tresc;
    @NotNull
    private String nagroda;
    @NotNull
    @Column(name = "czy_wykonane")
    private Boolean czyWykonane;

    public Questy(@NotNull Postac postac, @NotNull Uzytkownik wykonujacy, @NotNull String noweZadanie, @NotNull String tresc, @NotNull String nagroda, @NotNull Boolean czyWykonane) {
        this.postac = postac;
        this.wykonujacy = wykonujacy;
        this.noweZadanie = noweZadanie;
        this.tresc = tresc;
        this.nagroda = nagroda;
        this.czyWykonane = czyWykonane;
    }

    public Questy() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Postac getPostac() {
        return postac;
    }

    public void setPostac(Postac postac) {
        this.postac = postac;
    }

    public Uzytkownik getWykonujacy() {
        return wykonujacy;
    }

    public void setWykonujacy(Uzytkownik wykonujacy) {
        this.wykonujacy = wykonujacy;
    }

    public String getNoweZadanie() {
        return noweZadanie;
    }

    public void setNoweZadanie(String noweZadanie) {
        this.noweZadanie = noweZadanie;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public String getNagroda() {
        return nagroda;
    }

    public void setNagroda(String nagroda) {
        this.nagroda = nagroda;
    }

    public Boolean getCzyWykonane() {
        return czyWykonane;
    }

    public void setCzyWykonane(Boolean czyWykonane) {
        this.czyWykonane = czyWykonane;
    }

    @Override
    public String toString() {
        return "Questy{" +
                "id=" + id +
                ", postac=" + postac +
                ", wykonujacy=" + wykonujacy +
                ", noweZadanie='" + noweZadanie + '\'' +
                ", tresc='" + tresc + '\'' +
                ", nagroda='" + nagroda + '\'' +
                ", czyWykonane=" + czyWykonane +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Questy questy = (Questy) o;
        return postac.equals(questy.postac) &&
                wykonujacy.equals(questy.wykonujacy) &&
                noweZadanie.equals(questy.noweZadanie) &&
                tresc.equals(questy.tresc) &&
                nagroda.equals(questy.nagroda) &&
                czyWykonane.equals(questy.czyWykonane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postac,
                wykonujacy,
                noweZadanie,
                tresc,
                nagroda,
                czyWykonane);
    }
}
