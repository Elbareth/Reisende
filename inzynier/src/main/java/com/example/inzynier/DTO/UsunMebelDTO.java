package com.example.inzynier.DTO;

import java.util.Objects;

public class UsunMebelDTO {
    private String wymiarX;
    private String wymiarY;
    private String nazwa;

    public UsunMebelDTO(String wymiarX, String wymiarY, String nazwa) {
        this.wymiarX = wymiarX;
        this.wymiarY = wymiarY;
        this.nazwa = nazwa;
    }

    public UsunMebelDTO() {
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
        return "UsunMebelDTO{" +
                "wymiarX='" + wymiarX + '\'' +
                ", wymiarY='" + wymiarY + '\'' +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsunMebelDTO)) return false;
        UsunMebelDTO that = (UsunMebelDTO) o;
        return getWymiarX().equals(that.getWymiarX()) &&
                getWymiarY().equals(that.getWymiarY()) &&
                getNazwa().equals(that.getNazwa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWymiarX(), getWymiarY(), getNazwa());
    }
}
