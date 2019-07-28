package com.example.inzynier.DTO;

public class KuzniaDTO {
    private Integer id;
    private UzytkownikDTO sprzedajacy;
    private Float aktualnaCena;
    private Boolean czyStala;
    private Integer iloscLicytujacych;
    private ZbrojaDTO nazwa;
    private String plik;
    private String klasa;
    private String opis;

    public KuzniaDTO(UzytkownikDTO sprzedajacy, Float aktualnaCena, Boolean czyStala, Integer iloscLicytujacych, ZbrojaDTO nazwa, String plik, String klasa, String opis) {
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

    public UzytkownikDTO getSprzedajacy() {
        return sprzedajacy;
    }

    public void setSprzedajacy(UzytkownikDTO sprzedajacy) {
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

    public ZbrojaDTO getNazwa() {
        return nazwa;
    }

    public void setNazwa(ZbrojaDTO nazwa) {
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
        return "KuzniaDTO{" +
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
