package com.example.inzynier.DTO;

import com.example.inzynier.tables.Uzytkownik;

import java.time.LocalDate;
import java.util.Date;

public class WiadomosciDTO {
    private Integer id;
    private String nadawca;
    private String odbiorca;
    private String tytul;
    private String tresc;
    private LocalDate data;


    public WiadomosciDTO(String nadawca, String odbiorca, String tytul, String tresc, LocalDate data) {
        this.nadawca = nadawca;
        this.odbiorca = odbiorca;
        this.tytul = tytul;
        this.tresc = tresc;
        this.data = data;
    }

    public WiadomosciDTO(Integer id, String nadawca, String odbiorca, String tytul, String tresc, LocalDate data) {
        this.id = id;
        this.nadawca = nadawca;
        this.odbiorca = odbiorca;
        this.tytul = tytul;
        this.tresc = tresc;
        this.data = data;
    }

    public WiadomosciDTO(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNadawca() {
        return nadawca;
    }

    public void setNadawca(String nadawca) {
        this.nadawca = nadawca;
    }

    public String getOdbiorca() {
        return odbiorca;
    }

    public void setOdbiorca(String odbiorca) {
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
        return "WiadomosciDTO{" +
                "id=" + id +
                ", nadawca=" + nadawca +
                ", odbiorca=" + odbiorca +
                ", tytul='" + tytul + '\'' +
                ", tresc='" + tresc + '\'' +
                ", data=" + data +
                '}';
    }
}
