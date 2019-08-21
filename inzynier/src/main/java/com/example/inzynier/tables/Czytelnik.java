package com.example.inzynier.tables;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

//TODO UWAGA ManyToOne!!!
@Entity
@Table(name="d_czytelnik")
public class Czytelnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="nazwa")
    private Ksiazki tytul;
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="login")
    private Uzytkownik czytelnik;

    public Czytelnik(@NotNull Ksiazki tytul, @NotNull Uzytkownik czytelnik) {
        this.tytul = tytul;
        this.czytelnik = czytelnik;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ksiazki getTytul() {
        return tytul;
    }

    public void setTytul(Ksiazki tytul) {
        this.tytul = tytul;
    }

    public Uzytkownik getCzytelnik() {
        return czytelnik;
    }

    public void setCzytelnik(Uzytkownik czytelnik) {
        this.czytelnik = czytelnik;
    }

    @Override
    public String toString() {
        return "Czytelnik{" +
                "id=" + id +
                ", tytul=" + tytul +
                ", czytelnik=" + czytelnik +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Czytelnik czytelnik1 = (Czytelnik) o;
        return tytul.equals(czytelnik1.tytul) &&
                czytelnik.equals(czytelnik1.czytelnik);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tytul,
                czytelnik);
    }
}
