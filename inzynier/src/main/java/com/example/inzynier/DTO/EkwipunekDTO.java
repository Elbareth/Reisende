package com.example.inzynier.DTO;

public class EkwipunekDTO {
    private Integer id;
    private UzytkownikDTO wlasciciel;
    private String nazwa;
    private String plik;
    private String opis;

    public EkwipunekDTO(UzytkownikDTO wlasciciel, String nazwa, String plik, String opis) {
        this.wlasciciel = wlasciciel;
        this.nazwa = nazwa;
        this.plik = plik;
        this.opis = opis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UzytkownikDTO getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(UzytkownikDTO wlasciciel) {
        this.wlasciciel = wlasciciel;
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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "EkwipunekDTO{" +
                "id=" + id +
                ", wlasciciel=" + wlasciciel +
                ", nazwa='" + nazwa + '\'' +
                ", plik='" + plik + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }
}
