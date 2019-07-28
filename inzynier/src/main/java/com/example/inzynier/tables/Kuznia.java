package com.example.inzynier.tables;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//TODO WAGA ManyToOne!!!
@Entity
@Table(name = "d_kuznia")
public class Kuznia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="login")
    private Uzytkownik sprzedajacy;
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

    public Kuznia(@NotNull Uzytkownik sprzedajacy, @NotNull Float aktualnaCena, @NotNull Boolean czyStala, @NotNull Integer iloscLicytujacych, @NotNull Zbroja nazwa, @NotNull String plik, @NotNull String klasa, @NotNull String opis) {
        this.sprzedajacy = sprzedajacy;
        this.aktualnaCena = aktualnaCena;
        this.czyStala = czyStala;
        this.iloscLicytujacych = iloscLicytujacych;
        this.nazwa = nazwa;
        this.plik = plik;
        this.klasa = klasa;
        this.opis = opis;
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

    @Override
    public String toString() {
        return "Kuznia{" +
                "id=" + id +
                ", sprzedajacy=" + sprzedajacy +
                ", aktualnaCena=" + aktualnaCena +
                ", czyStala=" + czyStala +
                ", iloscLicytujacych=" + iloscLicytujacych +
                ", nazwa=" + nazwa +
                ", plik='" + plik + '\'' +
                ", klasa='" + klasa + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }
}
