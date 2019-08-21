package com.example.inzynier.DTO;

import java.util.Objects;

public class DialogPostaciDTO {
    private Integer id;
    private String nazwaQuesta;
    private PostacDTO postac;
    private String tekst;

    public DialogPostaciDTO(String nazwaQuesta, PostacDTO postac, String tekst) {
        this.nazwaQuesta = nazwaQuesta;
        this.postac = postac;
        this.tekst = tekst;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwaQuesta() {
        return nazwaQuesta;
    }

    public void setNazwaQuesta(String nazwaQuesta) {
        this.nazwaQuesta = nazwaQuesta;
    }

    public PostacDTO getPostac() {
        return postac;
    }

    public void setPostac(PostacDTO postac) {
        this.postac = postac;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    @Override
    public String toString() {
        return "DialogPostaciDTO{" +
                "id=" + id +
                ", nazwaQuesta='" + nazwaQuesta + '\'' +
                ", postac=" + postac +
                ", tekst='" + tekst + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DialogPostaciDTO that = (DialogPostaciDTO) o;
        return nazwaQuesta.equals(that.nazwaQuesta) &&
                postac.equals(that.postac) &&
                tekst.equals(that.tekst);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwaQuesta,
                postac,
                tekst);
    }
}
