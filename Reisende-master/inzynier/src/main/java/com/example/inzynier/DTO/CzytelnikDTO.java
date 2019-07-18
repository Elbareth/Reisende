package com.example.inzynier.DTO;

public class CzytelnikDTO {
    private Integer ID;
    private String Tytul;
    private String Czytelnik;

    public CzytelnikDTO(String tytul, String czytelnik) {
        Tytul = tytul;
        Czytelnik = czytelnik;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTytul() {
        return Tytul;
    }

    public void setTytul(String tytul) {
        Tytul = tytul;
    }

    public String getCzytelnik() {
        return Czytelnik;
    }

    public void setCzytelnik(String czytelnik) {
        Czytelnik = czytelnik;
    }

    @Override
    public String toString() {
        return "CzytelnikDTO{" +
                "ID=" + ID +
                ", Tytul='" + Tytul + '\'' +
                ", Czytelnik='" + Czytelnik + '\'' +
                '}';
    }
}
