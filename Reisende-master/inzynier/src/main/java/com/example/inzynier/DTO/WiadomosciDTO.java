package com.example.inzynier.DTO;

import java.util.Date;

public class WiadomosciDTO {
    private Integer Id;
    private String Nadawca;
    private String Odbiorca;
    private String Tytul;
    private String Tresc;
    private Date Data;

    public WiadomosciDTO(String nadawca, String odbiorca, String tytul, String tresc, Date data) {
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
        return "WiadomosciDTO{" +
                "Id=" + Id +
                ", Nadawca='" + Nadawca + '\'' +
                ", Odbiorca='" + Odbiorca + '\'' +
                ", Tytul='" + Tytul + '\'' +
                ", Tresc='" + Tresc + '\'' +
                ", Data=" + Data +
                '}';
    }
}
