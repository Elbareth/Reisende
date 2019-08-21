package com.example.inzynier.DTO;

import java.util.Objects;

public class QuestyDTO {
    private Integer id;
    private PostacDTO postac;
    private UzytkownikDTO wykonujacy;
    private String noweZadanie;
    private String tresc;
    private String nagroda;
    private Boolean czyWykonane;

    public QuestyDTO(PostacDTO postac, UzytkownikDTO wykonujacy, String noweZadanie, String tresc, String nagroda, Boolean czyWykonane) {
        this.postac = postac;
        this.wykonujacy = wykonujacy;
        this.noweZadanie = noweZadanie;
        this.tresc = tresc;
        this.nagroda = nagroda;
        this.czyWykonane = czyWykonane;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PostacDTO getPostac() {
        return postac;
    }

    public void setPostac(PostacDTO postac) {
        this.postac = postac;
    }

    public UzytkownikDTO getWykonujacy() {
        return wykonujacy;
    }

    public void setWykonujacy(UzytkownikDTO wykonujacy) {
        this.wykonujacy = wykonujacy;
    }

    public String getNoweZadanie() {
        return noweZadanie;
    }

    public void setNoweZadanie(String noweZadanie) {
        this.noweZadanie = noweZadanie;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public String getNagroda() {
        return nagroda;
    }

    public void setNagroda(String nagroda) {
        this.nagroda = nagroda;
    }

    public Boolean getCzyWykonane() {
        return czyWykonane;
    }

    public void setCzyWykonane(Boolean czyWykonane) {
        this.czyWykonane = czyWykonane;
    }

    @Override
    public String toString() {
        return "QuestyDTO{" +
                "id=" + id +
                ", postac=" + postac +
                ", wykonujacy=" + wykonujacy +
                ", noweZadanie='" + noweZadanie + '\'' +
                ", tresc='" + tresc + '\'' +
                ", nagroda='" + nagroda + '\'' +
                ", czyWykonane=" + czyWykonane +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestyDTO questyDTO = (QuestyDTO) o;
        return postac.equals(questyDTO.postac) &&
                wykonujacy.equals(questyDTO.wykonujacy) &&
                noweZadanie.equals(questyDTO.noweZadanie) &&
                tresc.equals(questyDTO.tresc) &&
                nagroda.equals(questyDTO.nagroda) &&
                czyWykonane.equals(questyDTO.czyWykonane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postac,
                wykonujacy,
                noweZadanie,
                tresc,
                nagroda,
                czyWykonane);
    }
}
