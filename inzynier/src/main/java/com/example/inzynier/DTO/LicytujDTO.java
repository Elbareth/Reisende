package com.example.inzynier.DTO;

import java.util.Objects;

public class LicytujDTO {
    private Integer cena;

    public LicytujDTO(Integer cena) {
        this.cena = cena;
    }

    public LicytujDTO() {
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "LicytujDTO{" +
                ", cena=" + cena +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LicytujDTO)) return false;
        LicytujDTO that = (LicytujDTO) o;
        return getCena().equals(that.getCena());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCena());
    }
}
