package com.example.inzynier.tables;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Wiadomosci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @NotNull
    private String Nadawca;
    @NotNull
    private String Odbiorca;
    @NotNull
    private String Tytul;
    @NotNull
    private String Tresc;
    @NotNull
    @DateTimeFormat(pattern = "dd.MM.uuuu, HH:mm")
    private Date Data;

    public Wiadomosci(@NotNull String nadawca, @NotNull String odbiorca, @NotNull String tytul, @NotNull String tresc, @NotNull Date data) {
        Nadawca = nadawca;
        Odbiorca = odbiorca;
        Tytul = tytul;
        Tresc = tresc;
        Data = data;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNadawca() {
        return Nadawca;
    }

    public void setNadawca(String nadawca) {
        Nadawca = nadawca;
    }

    public String getOdbiorca() {
        return Odbiorca;
    }

    public void setOdbiorca(String odbiorca) {
        Odbiorca = odbiorca;
    }

    public String getTytul() {
        return Tytul;
    }

    public void setTytul(String tytul) {
        Tytul = tytul;
    }

    public String getTresc() {
        return Tresc;
    }

    public void setTresc(String tresc) {
        Tresc = tresc;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date data) {
        Data = data;
    }

    @Override
    public String toString() {
        return "Wiadomosci{" +
                "Id=" + Id +
                ", Nadawca='" + Nadawca + '\'' +
                ", Odbiorca='" + Odbiorca + '\'' +
                ", Tytul='" + Tytul + '\'' +
                ", Tresc='" + Tresc + '\'' +
                ", Data=" + Data +
                '}';
    }
}
