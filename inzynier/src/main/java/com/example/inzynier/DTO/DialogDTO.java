package com.example.inzynier.DTO;

import java.util.Objects;

public class DialogDTO {
    private String postac;
    private String dialog;

    public DialogDTO(String postac, String dialog) {
        this.postac = postac;
        this.dialog = dialog;
    }

    public DialogDTO() {
    }

    public String getPostac() {
        return postac;
    }

    public void setPostac(String postac) {
        this.postac = postac;
    }

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    @Override
    public String toString() {
        return "DialogDTO{" +
                "postac='" + postac + '\'' +
                ", dialog='" + dialog + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DialogDTO)) return false;
        DialogDTO dialogDTO = (DialogDTO) o;
        return getPostac().equals(dialogDTO.getPostac()) &&
                getDialog().equals(dialogDTO.getDialog());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostac(), getDialog());
    }
}
