package com.example.inzynier.DTO;

import java.util.Objects;

public class KupZbrojeDTO {
    private String nazwa;
    private String cena;

    public KupZbrojeDTO(String nazwa, String cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public KupZbrojeDTO() {
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KupZbrojeDTO)) return false;
        KupZbrojeDTO that = (KupZbrojeDTO) o;
        return getNazwa().equals(that.getNazwa()) &&
                getCena().equals(that.getCena());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNazwa(), getCena());
    }

    @Override
    public String toString() {
        return "KupZbrojeDTO{" +
                "nazwa='" + nazwa + '\'' +
                ", cena='" + cena + '\'' +
                '}';
    }
}
