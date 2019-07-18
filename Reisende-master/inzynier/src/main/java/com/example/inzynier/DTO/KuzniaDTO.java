package com.example.inzynier.DTO;

public class KuzniaDTO {
    private Integer Id;
    private String Sprzedajacy;
    private Float AktualnaCena;
    private Boolean CzyStala;
    private Integer IloscLicytujacych;
    private String Nazwa;
    private String Plik;
    private String Klasa;
    private String Opis;

    public KuzniaDTO(String sprzedajacy, Float aktualnaCena, Boolean czyStala, Integer iloscLicytujacych, String nazwa, String plik, String klasa, String opis) {
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
        return "KuzniaDTO{" +
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
