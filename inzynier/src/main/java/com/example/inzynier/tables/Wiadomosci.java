package com.example.inzynier.tables;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

//TODO UWAGA MantToOne!!!
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

    public Wiadomosci(@NotNull Uzytkownik nadawca, @NotNull Uzytkownik odbiorca, @NotNull String tytul, @NotNull String tresc, @NotNull LocalDate data) {
        this.nadawca = nadawca;
        this.odbiorca = odbiorca;
        this.tytul = tytul;
        this.tresc = tresc;
        this.data = data;
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

    @Override
    public String toString() {
        return "Wiadomosci{" +
                "id=" + id +
                ", nadawca=" + nadawca +
                ", odbiorca=" + odbiorca +
                ", tytul='" + tytul + '\'' +
                ", tresc='" + tresc + '\'' +
                ", data=" + data +
                '}';
    }
}
