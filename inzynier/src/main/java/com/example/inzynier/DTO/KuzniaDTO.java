package com.example.inzynier.DTO;

import java.time.LocalDateTime;
import java.util.Objects;

public class KuzniaDTO {
    private Integer id;
    private String sprzedajacy;
    private String kupujacy;
    private Float aktualnaCena;
    private Boolean czyStala;
    private Integer iloscLicytujacych;
    private String nazwa;
    private String plik;
    private String klasa;
    private String opis;
    private LocalDateTime dataZakonczenia;

    public KuzniaDTO(Integer id, String sprzedajacy, String kupujacy, Float aktualnaCena, Boolean czyStala, Integer iloscLicytujacych, String nazwa, String plik, String klasa, String opis, LocalDateTime dataZakonczenia) {
        this.id = id;
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

    public KuzniaDTO(String sprzedajacy, String kupujacy, Float aktualnaCena, Boolean czyStala, Integer iloscLicytujacych, String nazwa, String plik, String klasa, String opis, LocalDateTime dataZakonczenia) {
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

    public KuzniaDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSprzedajacy() {
        return sprzedajacy;
    }

    public void setSprzedajacy(String sprzedajacy) {
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

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
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

    public String getKupujacy() {
        return kupujacy;
    }

    public void setKupujacy(String kupujacy) {
        this.kupujacy = kupujacy;
    }

    @Override
    public String toString() {
        return "KuzniaDTO{" +
                "id=" + id +
                ", sprzedajacy='" + sprzedajacy + '\'' +
                ", kupujacy='" + kupujacy + '\'' +
                ", aktualnaCena=" + aktualnaCena +
                ", czyStala=" + czyStala +
                ", iloscLicytujacych=" + iloscLicytujacych +
                ", nazwa='" + nazwa + '\'' +
                ", plik='" + plik + '\'' +
                ", klasa='" + klasa + '\'' +
                ", opis='" + opis + '\'' +
                ", dataZakonczenia=" + dataZakonczenia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KuzniaDTO)) return false;
        KuzniaDTO kuzniaDTO = (KuzniaDTO) o;
        return getSprzedajacy().equals(kuzniaDTO.getSprzedajacy()) &&
                getKupujacy().equals(kuzniaDTO.getKupujacy()) &&
                getAktualnaCena().equals(kuzniaDTO.getAktualnaCena()) &&
                getCzyStala().equals(kuzniaDTO.getCzyStala()) &&
                getIloscLicytujacych().equals(kuzniaDTO.getIloscLicytujacych()) &&
                getNazwa().equals(kuzniaDTO.getNazwa()) &&
                getPlik().equals(kuzniaDTO.getPlik()) &&
                getKlasa().equals(kuzniaDTO.getKlasa()) &&
                getOpis().equals(kuzniaDTO.getOpis()) &&
                getDataZakonczenia().equals(kuzniaDTO.getDataZakonczenia());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSprzedajacy(), getKupujacy(), getAktualnaCena(), getCzyStala(), getIloscLicytujacych(), getNazwa(), getPlik(), getKlasa(), getOpis(), getDataZakonczenia());
    }
}
