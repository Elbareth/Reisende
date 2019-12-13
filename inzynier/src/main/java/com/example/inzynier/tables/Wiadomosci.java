package com.example.inzynier.tables;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "d_wiadomosci")
public class Wiadomosci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "nadawca", referencedColumnName = "login")
    private Uzytkownik nadawca;
    @NotNull
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "odbiorca", referencedColumnName = "login")
    private Uzytkownik odbiorca;
    @NotNull
    private String tytul;
    @NotNull
    private String tresc;
    @NotNull
    @DateTimeFormat(pattern = "dd.MM.uuuu, HH:mm")
    private LocalDate data;
    @NotNull
    @Column(name = "czy_przeczytane")
    private Boolean czyPrzeczytane;

    public Wiadomosci(
            @NotNull Uzytkownik nadawca,
            @NotNull Uzytkownik odbiorca,
            @NotNull String tytul,
            @NotNull String tresc,
            @NotNull LocalDate data,
            @NotNull Boolean czyPrzeczytane) {
        this.nadawca = nadawca;
        this.odbiorca = odbiorca;
        this.tytul = tytul;
        this.tresc = tresc;
        this.data = data;
        this.czyPrzeczytane = czyPrzeczytane;
    }

    public Wiadomosci(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Uzytkownik getNadawca() {
        return nadawca;
    }

    public void setNadawca(Uzytkownik nadawca) {
        this.nadawca = nadawca;
    }

    public Uzytkownik getOdbiorca() {
        return odbiorca;
    }

    public void setOdbiorca(Uzytkownik odbiorca) {
        this.odbiorca = odbiorca;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Boolean getCzyPrzeczytane() {
        return czyPrzeczytane;
    }

    public void setCzyPrzeczytane(Boolean czyPrzeczytane) {
        this.czyPrzeczytane = czyPrzeczytane;
    }

    @Override
    public String toString() {
        return "Wiadomosci{" +
                "id=" + id +
                ", nadawca=" + nadawca +
                ", odbiorca=" + odbiorca +
                ", tytul='" + tytul + '\'' +
                ", tresc='" + tresc + '\'' +
                ", data=" + data +
                ", czyPrzeczytane=" + czyPrzeczytane +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wiadomosci that = (Wiadomosci) o;
        return nadawca.equals(that.nadawca) &&
                odbiorca.equals(that.odbiorca) &&
                tytul.equals(that.tytul) &&
                tresc.equals(that.tresc) &&
                data.equals(that.data) &&
                czyPrzeczytane.equals(that.czyPrzeczytane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nadawca,
                odbiorca,
                tytul,
                tresc,
                data,
                czyPrzeczytane);
    }
}
