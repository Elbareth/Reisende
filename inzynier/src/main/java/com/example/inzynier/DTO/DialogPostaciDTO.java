package com.example.inzynier.DTO;

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
}
