package com.example.inzynier.DTO;

import java.util.Objects;

public class KupowanieMebliDTO {
    private String wymiarX;
    private String wymiarY;
    private String pieniadze;
    private String nazwa;

    public KupowanieMebliDTO(String wymiarX, String wymiarY, String pieniadze, String nazwa) {
        this.wymiarX = wymiarX;
        this.wymiarY = wymiarY;
        this.pieniadze = pieniadze;
        this.nazwa = nazwa;
    }

    public KupowanieMebliDTO() {
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

    public String getPieniadze() {
        return pieniadze;
    }

    public void setPieniadze(String pieniadze) {
        this.pieniadze = pieniadze;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "KupowanieMebliDTO{" +
                "wymiarX='" + wymiarX + '\'' +
                ", wymiarY='" + wymiarY + '\'' +
                ", pieniadze='" + pieniadze + '\'' +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KupowanieMebliDTO)) return false;
        KupowanieMebliDTO that = (KupowanieMebliDTO) o;
        return getWymiarX().equals(that.getWymiarX()) &&
                getWymiarY().equals(that.getWymiarY()) &&
                getPieniadze().equals(that.getPieniadze()) &&
                getNazwa().equals(that.getNazwa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWymiarX(), getWymiarY(), getPieniadze(), getNazwa());
    }
}
