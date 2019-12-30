package com.example.inzynier.tables;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "d_zabite_bestie")
public class ZabiteBestie {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "uzytkownik", referencedColumnName = "login")
    private Uzytkownik uzytkownik;
    @NotNull
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "nazwa_bestii", referencedColumnName = "nazwa")
    private Bestie nazwaBestii;
    @NotNull
    private Integer ilosc;

    public ZabiteBestie(@NotNull Integer id, @NotNull Uzytkownik uzytkownik, @NotNull Bestie nazwaBestii, @NotNull Integer ilosc) {
        this.id = id;
        this.uzytkownik = uzytkownik;
        this.nazwaBestii = nazwaBestii;
        this.ilosc = ilosc;
    }

    public ZabiteBestie(@NotNull Uzytkownik uzytkownik, @NotNull Bestie nazwaBestii, @NotNull Integer ilosc) {
        this.uzytkownik = uzytkownik;
        this.nazwaBestii = nazwaBestii;
        this.ilosc = ilosc;
    }

    public ZabiteBestie() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public Bestie getNazwaBestii() {
        return nazwaBestii;
    }

    public void setNazwaBestii(Bestie nazwaBestii) {
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
        if (!(o instanceof ZabiteBestie)) return false;
        ZabiteBestie that = (ZabiteBestie) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getUzytkownik(), that.getUzytkownik()) &&
                Objects.equals(getNazwaBestii(), that.getNazwaBestii()) &&
                Objects.equals(getIlosc(), that.getIlosc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUzytkownik(), getNazwaBestii(), getIlosc());
    }

    @Override
    public String toString() {
        return "ZabiteBestie{" +
                "id=" + id +
                ", uzytkownik=" + uzytkownik +
                ", nazwaBestii=" + nazwaBestii +
                ", ilosc=" + ilosc +
                '}';
    }
}
