package com.example.inzynier.DTO;

import java.util.Objects;

public class ZabiteBestieDTO {
    private Integer id;
    private String uzytkownik;
    private String nazwaBestii;
    private Integer ilosc;

    public ZabiteBestieDTO(Integer id, String uzytkownik, String nazwaBestii, Integer ilosc) {
        this.id = id;
        this.uzytkownik = uzytkownik;
        this.nazwaBestii = nazwaBestii;
        this.ilosc = ilosc;
    }

    public ZabiteBestieDTO(String uzytkownik, String nazwaBestii, Integer ilosc) {
        this.uzytkownik = uzytkownik;
        this.nazwaBestii = nazwaBestii;
        this.ilosc = ilosc;
    }

    public ZabiteBestieDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(String uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public String getNazwaBestii() {
        return nazwaBestii;
    }

    public void setNazwaBestii(String nazwaBestii) {
        this.nazwaBestii = nazwaBestii;
    }

    public Integer getIlosc() {
        return ilosc;
    }

    public void setIlosc(Integer ilosc) {
        this.ilosc = ilosc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ZabiteBestieDTO)) return false;
        ZabiteBestieDTO that = (ZabiteBestieDTO) o;
        return getId().equals(that.getId()) &&
                getUzytkownik().equals(that.getUzytkownik()) &&
                getNazwaBestii().equals(that.getNazwaBestii()) &&
                getIlosc().equals(that.getIlosc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUzytkownik(), getNazwaBestii(), getIlosc());
    }

    @Override
    public String toString() {
        return "ZabiteBestieDTO{" +
                "id=" + id +
                ", uzytkownik='" + uzytkownik + '\'' +
                ", nazwaBestii='" + nazwaBestii + '\'' +
                ", ilosc=" + ilosc +
                '}';
    }
}
