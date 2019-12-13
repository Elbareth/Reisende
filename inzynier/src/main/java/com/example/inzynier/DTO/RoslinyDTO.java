package com.example.inzynier.DTO;

import java.util.Objects;

public class RoslinyDTO {
    private String roslina;

    public RoslinyDTO(String roslina) {
        this.roslina = roslina;
    }

    public RoslinyDTO() {
    }

    public String getRoslina() {
        return roslina;
    }

    public void setRoslina(String roslina) {
        this.roslina = roslina;
    }

    @Override
    public String toString() {
        return "RoslinyDTO{" +
                "roslina='" + roslina + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoslinyDTO)) return false;
        RoslinyDTO that = (RoslinyDTO) o;
        return getRoslina().equals(that.getRoslina());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoslina());
    }
}
