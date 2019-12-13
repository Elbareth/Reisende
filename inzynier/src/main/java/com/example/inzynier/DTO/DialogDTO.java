package com.example.inzynier.DTO;

import java.util.Objects;

public class DialogDTO {
    private String postac;

    public DialogDTO(String postac) {
        this.postac = postac;
    }

    public DialogDTO() {
    }

    public String getPostac() {
        return postac;
    }

    public void setPostac(String postac) {
        this.postac = postac;
    }

    @Override
    public String toString() {
        return "DialogDTO{" +
                "postac='" + postac + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DialogDTO)) return false;
        DialogDTO dialogDTO = (DialogDTO) o;
        return getPostac().equals(dialogDTO.getPostac());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostac());
    }
}
