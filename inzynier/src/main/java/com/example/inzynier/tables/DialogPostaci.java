package com.example.inzynier.tables;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

//TODO Stworz dialog postaci
//TODO Uwaga ManyToOne!!!
@Entity
@Table(name = "d_dialog_postaci")
public class DialogPostaci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name="nazwa_questa")
    private String nazwaQuesta;
    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "postac", referencedColumnName = "imie")
    private Postac postac;
    @NotNull
    private String tekst;

    public DialogPostaci(@NotNull String nazwaQuesta, @NotNull Postac postac, @NotNull String tekst) {
        this.nazwaQuesta = nazwaQuesta;
        this.postac = postac;
        this.tekst = tekst;
    }

    public DialogPostaci() {
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

    public Postac getPostac() {
        return postac;
    }

    public void setPostac(Postac postac) {
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
        return "DialogPostaci{" +
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
        DialogPostaci that = (DialogPostaci) o;
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
