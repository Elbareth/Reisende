package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Kuznia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @NotNull
    private String Sprzedajacy;
    @NotNull
    private Float AktualnaCena;
    @NotNull
    private Boolean CzyStala;
    @NotNull
    private Integer IloscLicytujacych;
    @NotNull
    private String Nazwa;
    @NotNull
    private String Plik;
    @NotNull
    private String Klasa;
    @NotNull
    private String Opis;

    public Kuznia(@NotNull String sprzedajacy, @NotNull Float aktualnaCena, @NotNull Boolean czyStala, @NotNull Integer iloscLicytujacych, @NotNull String nazwa, @NotNull String plik, @NotNull String klasa, @NotNull String opis) {
        Sprzedajacy = sprzedajacy;
        AktualnaCena = aktualnaCena;
        CzyStala = czyStala;
        IloscLicytujacych = iloscLicytujacych;
        Nazwa = nazwa;
        Plik = plik;
        Klasa = klasa;
        Opis = opis;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getSprzedajacy() {
        return Sprzedajacy;
    }

    public void setSprzedajacy(String sprzedajacy) {
        Sprzedajacy = sprzedajacy;
    }

    public Float getAktualnaCena() {
        return AktualnaCena;
    }

    public void setAktualnaCena(Float aktualnaCena) {
        AktualnaCena = aktualnaCena;
    }

    public Boolean getCzyStala() {
        return CzyStala;
    }

    public void setCzyStala(Boolean czyStala) {
        CzyStala = czyStala;
    }

    public Integer getIloscLicytujacych() {
        return IloscLicytujacych;
    }

    public void setIloscLicytujacych(Integer iloscLicytujacych) {
        IloscLicytujacych = iloscLicytujacych;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public String getPlik() {
        return Plik;
    }

    public void setPlik(String plik) {
        Plik = plik;
    }

    public String getKlasa() {
        return Klasa;
    }

    public void setKlasa(String klasa) {
        Klasa = klasa;
    }

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String opis) {
        Opis = opis;
    }

    @Override
    public String toString() {
        return "Kuznia{" +
                "Id=" + Id +
                ", Sprzedajacy='" + Sprzedajacy + '\'' +
                ", AktualnaCena=" + AktualnaCena +
                ", CzyStala=" + CzyStala +
                ", IloscLicytujacych=" + IloscLicytujacych +
                ", Nazwa='" + Nazwa + '\'' +
                ", Plik='" + Plik + '\'' +
                ", Klasa='" + Klasa + '\'' +
                ", Opis='" + Opis + '\'' +
                '}';
    }
}
