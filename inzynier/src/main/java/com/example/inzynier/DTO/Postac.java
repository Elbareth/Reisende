package com.example.inzynier.DTO;

import java.util.Objects;

public class Postac {
    private String plansza;
    private String left;
    private String top;

    public Postac(String left, String top, String plansza) {
        this.left = left;
        this.top = top;
        this.plansza = plansza;
    }

    public Postac() {
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getPlansza() {
        return plansza;
    }

    public void setPlansza(String plansza) {
        this.plansza = plansza;
    }

    @Override
    public String toString() {
        return "Postac{" +
                "plansza='" + plansza + '\'' +
                ", left='" + left + '\'' +
                ", top='" + top + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Postac)) return false;
        Postac postac = (Postac) o;
        return getPlansza().equals(postac.getPlansza()) &&
                getLeft().equals(postac.getLeft()) &&
                getTop().equals(postac.getTop());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlansza(), getLeft(), getTop());
    }
}
