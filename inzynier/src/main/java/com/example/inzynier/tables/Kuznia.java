package com.example.inzynier.tables;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "d_kuznia")
public class Kuznia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="sprzedajacy", referencedColumnName = "login")
    private Uzytkownik sprzedajacy;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="kupujacy", referencedColumnName = "login")
    private Uzytkownik kupujacy;
    @NotNull
    @Column(name = "aktualna_cena")
    private Float aktualnaCena;
    @NotNull
    @Column(name = "czy_stala")
    private Boolean czyStala;
    @NotNull
    @Column(name = "ilosc_licytujacych")
    private Integer iloscLicytujacych;
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="nazwa")
    private Zbroja nazwa;
    @NotNull
    private String plik;
    @NotNull
    private String klasa;
    @NotNull
    private String opis;
    @NotNull
    @Column(name = "data_zakonczenia")
    @DateTimeFormat(pattern = "dd.MM.uuuu, HH:mm")
    private LocalDateTime dataZakonczenia;

    public Kuznia(@NotNull Uzytkownik sprzedajacy, @NotNull Uzytkownik kupujacy, @NotNull Float aktualnaCena, @NotNull Boolean czyStala, @NotNull Integer iloscLicytujacych, @NotNull Zbroja nazwa, @NotNull String plik, @NotNull String klasa, @NotNull String opis, @NotNull LocalDateTime dataZakonczenia) {
        this.sprzedajacy = sprzedajacy;
        this.kupujacy = kupujacy;
        this.aktualnaCena = aktualnaCena;
        this.czyStala = czyStala;
        this.iloscLicytujacych = iloscLicytujacych;
        this.nazwa = nazwa;
        this.plik = plik;
        this.klasa = klasa;
        this.opis = opis;
        this.dataZakonczenia = dataZakonczenia;
    }

    public Kuznia() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Uzytkownik getSprzedajacy() {
        return sprzedajacy;
    }

    public void setSprzedajacy(Uzytkownik sprzedajacy) {
        this.sprzedajacy = sprzedajacy;
    }

    public Float getAktualnaCena() {
        return aktualnaCena;
    }

    public void setAktualnaCena(Float aktualnaCena) {
        this.aktualnaCena = aktualnaCena;
    }

    public Boolean getCzyStala() {
        return czyStala;
    }

    public void setCzyStala(Boolean czyStala) {
        this.czyStala = czyStala;
    }

    public Integer getIloscLicytujacych() {
        return iloscLicytujacych;
    }

    public void setIloscLicytujacych(Integer iloscLicytujacych) {
        this.iloscLicytujacych = iloscLicytujacych;
    }

    public Zbroja getNazwa() {
        return nazwa;
    }

    public void setNazwa(Zbroja nazwa) {
        this.nazwa = nazwa;
    }

    public String getPlik() {
        return plik;
    }

    public void setPlik(String plik) {
        this.plik = plik;
    }

    public String getKlasa() {
        return klasa;
    }

    public void setKlasa(String klasa) {
        this.klasa = klasa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public LocalDateTime getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(LocalDateTime dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public Uzytkownik getKupujacy() {
        return kupujacy;
    }

    public void setKupujacy(Uzytkownik kupujacy) {
        this.kupujacy = kupujacy;
    }

    @Override
    public String toString() {
        return "Kuznia{" +
                "id=" + id +
                ", sprzedajacy=" + sprzedajacy +
                ", kupujacy=" + kupujacy +
                ", aktualnaCena=" + aktualnaCena +
                ", czyStala=" + czyStala +
                ", iloscLicytujacych=" + iloscLicytujacych +
                ", nazwa=" + nazwa +
                ", plik='" + plik + '\'' +
                ", klasa='" + klasa + '\'' +
                ", opis='" + opis + '\'' +
                ", dataZakonczenia=" + dataZakonczenia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kuznia)) return false;
        Kuznia kuznia = (Kuznia) o;
        return getSprzedajacy().equals(kuznia.getSprzedajacy()) &&
                getKupujacy().equals(kuznia.getKupujacy()) &&
                getAktualnaCena().equals(kuznia.getAktualnaCena()) &&
                getCzyStala().equals(kuznia.getCzyStala()) &&
                getIloscLicytujacych().equals(kuznia.getIloscLicytujacych()) &&
                getNazwa().equals(kuznia.getNazwa()) &&
                getPlik().equals(kuznia.getPlik()) &&
                getKlasa().equals(kuznia.getKlasa()) &&
                getOpis().equals(kuznia.getOpis()) &&
                getDataZakonczenia().equals(kuznia.getDataZakonczenia());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSprzedajacy(), getKupujacy(), getAktualnaCena(), getCzyStala(), getIloscLicytujacych(), getNazwa(), getPlik(), getKlasa(), getOpis(), getDataZakonczenia());
    }
}
