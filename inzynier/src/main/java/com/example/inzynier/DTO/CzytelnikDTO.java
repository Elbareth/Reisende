package com.example.inzynier.DTO;

import com.example.inzynier.tables.Ksiazki;
import com.example.inzynier.tables.Uzytkownik;

public class CzytelnikDTO {
    private Integer id;
    private KsiazkiDTO tytul;
    private UzytkownikDTO czytelnik;

    public CzytelnikDTO(KsiazkiDTO tytul, UzytkownikDTO czytelnik) {
        this.tytul = tytul;
        this.czytelnik = czytelnik;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public KsiazkiDTO getTytul() {
        return tytul;
    }

    public void setTytul(KsiazkiDTO tytul) {
        this.tytul = tytul;
    }

    public UzytkownikDTO getCzytelnik() {
        return czytelnik;
    }

    public void setCzytelnik(UzytkownikDTO czytelnik) {
        this.czytelnik = czytelnik;
    }

    @Override
    public String toString() {
        return "CzytelnikDTO{" +
                "id=" + id +
                ", tytul=" + tytul +
                ", czytelnik=" + czytelnik +
                '}';
    }
}
