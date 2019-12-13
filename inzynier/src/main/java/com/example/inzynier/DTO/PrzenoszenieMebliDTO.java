package com.example.inzynier.DTO;

import java.util.Objects;

public class PrzenoszenieMebliDTO {
    private String staraPozycjaX;
    private String staraPozycjaY;
    private String wymiarX;
    private String wymiarY;
    private String nazwa;

    public PrzenoszenieMebliDTO(String staraPozycjaX, String staraPozycjaY, String wymiarX, String wymiarY, String nazwa) {
        this.staraPozycjaX = staraPozycjaX;
        this.staraPozycjaY = staraPozycjaY;
        this.wymiarX = wymiarX;
        this.wymiarY = wymiarY;
        this.nazwa = nazwa;
    }

    public PrzenoszenieMebliDTO() {
    }

    public String getStaraPozycjaX() {
        return staraPozycjaX;
    }

    public void setStaraPozycjaX(String staraPozycjaX) {
        this.staraPozycjaX = staraPozycjaX;
    }

    public String getStaraPozycjaY() {
        return staraPozycjaY;
    }

    public void setStaraPozycjaY(String staraPozycjaY) {
        this.staraPozycjaY = staraPozycjaY;
    }

    public String getWymiarX() {
        return wymiarX;
    }

    public void setWymiarX(String wymiarX) {
        this.wymiarX = wymiarX;
    }

    public String getWymiarY() {
        return wymiarY;
    }

    public void setWymiarY(String wymiarY) {
        this.wymiarY = wymiarY;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "PrzenoszenieMebliDTO{" +
                "staraPozycjaX='" + staraPozycjaX + '\'' +
                ", staraPozycjaY='" + staraPozycjaY + '\'' +
                ", wymiarX='" + wymiarX + '\'' +
                ", wymiarY='" + wymiarY + '\'' +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrzenoszenieMebliDTO)) return false;
        PrzenoszenieMebliDTO that = (PrzenoszenieMebliDTO) o;
        return getStaraPozycjaX().equals(that.getStaraPozycjaX()) &&
                getStaraPozycjaY().equals(that.getStaraPozycjaY()) &&
                getWymiarX().equals(that.getWymiarX()) &&
                getWymiarY().equals(that.getWymiarY()) &&
                getNazwa().equals(that.getNazwa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStaraPozycjaX(), getStaraPozycjaY(), getWymiarX(), getWymiarY(), getNazwa());
    }
}
