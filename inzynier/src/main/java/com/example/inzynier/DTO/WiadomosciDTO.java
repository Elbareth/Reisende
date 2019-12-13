package com.example.inzynier.DTO;

import java.time.LocalDate;
import java.util.Objects;

public class WiadomosciDTO {
    private Integer id;
    private String nadawca;
    private String odbiorca;
    private String tytul;
    private String tresc;
    private LocalDate data;
    private Boolean czyPrzeczytane;


    public WiadomosciDTO(String nadawca, String odbiorca, String tytul, String tresc, LocalDate data, Boolean czyPrzeczytane) {
        this.nadawca = nadawca;
        this.odbiorca = odbiorca;
        this.tytul = tytul;
        this.tresc = tresc;
        this.data = data;
        this.czyPrzeczytane = czyPrzeczytane;
    }

    public WiadomosciDTO(Integer id, String nadawca, String odbiorca, String tytul, String tresc, LocalDate data, Boolean czyPrzeczytane) {
        this.id = id;
        this.nadawca = nadawca;
        this.odbiorca = odbiorca;
        this.tytul = tytul;
        this.tresc = tresc;
        this.data = data;
        this.czyPrzeczytane = czyPrzeczytane;
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

    public Boolean getCzyPrzeczytane() {
        return czyPrzeczytane;
    }

    public void setCzyPrzeczytane(Boolean czyPrzeczytane) {
        this.czyPrzeczytane = czyPrzeczytane;
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
                ", czyPrzeczytane=" + czyPrzeczytane +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WiadomosciDTO that = (WiadomosciDTO) o;
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
