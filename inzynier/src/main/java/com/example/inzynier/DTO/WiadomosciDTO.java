package com.example.inzynier.DTO;

import com.example.inzynier.tables.Uzytkownik;

import java.util.Date;

public class WiadomosciDTO {
    private Integer id;
    private UzytkownikDTO nadawca;
    private UzytkownikDTO odbiorca;
    private String tytul;
    private String tresc;
    private Date data;


    public WiadomosciDTO(UzytkownikDTO nadawca, UzytkownikDTO odbiorca, String tytul, String tresc, Date data) {
        this.nadawca = nadawca;
        this.odbiorca = odbiorca;
        this.tytul = tytul;
        this.tresc = tresc;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UzytkownikDTO getNadawca() {
        return nadawca;
    }

    public void setNadawca(UzytkownikDTO nadawca) {
        this.nadawca = nadawca;
    }

    public UzytkownikDTO getOdbiorca() {
        return odbiorca;
    }

    public void setOdbiorca(UzytkownikDTO odbiorca) {
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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
