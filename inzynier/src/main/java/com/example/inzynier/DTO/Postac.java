package com.example.inzynier.DTO;

public class Postac {
    private String left;
    private String top;

    public Postac(String left, String top) {
        this.left = left;
        this.top = top;
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

    @Override
    public String toString() {
        return "Postac{" +
                "left='" + left + '\'' +
                ", top='" + top + '\'' +
                '}';
    }
}
