package com.example.inzynier.tables;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "d_domek")
public class Domek {
    @Id
    @NotNull
    private String wlasciciel;
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JoinColumn(name="login")
    private Uzytkownik uzytkownik;
    @NotNull
    private String pomieszczenia;
    @NotNull
    private String okna;
    @NotNull
    private String drzwi;
    @NotNull
    private String lozko;
    @NotNull
    private String wanna;
    @NotNull
    private String umywalka;
    @NotNull
    private String toaeta;
    @NotNull
    private String szafki;
    @NotNull
    private String zlew;
    @NotNull
    private String kuchenka;
    @NotNull
    private String lodowka;
    @NotNull
    private String szafa;
    @NotNull
    private String obraz;
    @NotNull
    private String dywany;
    @NotNull
    private String kominki;
    @NotNull
    private String kwiaty;
    @NotNull
    private String wazony;
    @NotNull
    private String trofea;
    @NotNull
    private String kojec;
    @NotNull
    private String krzesla;
    @NotNull
    private String fotele;
    @NotNull
    private String sofa;
    @NotNull
    private String stoly;
    @NotNull
    private String barek;
    @NotNull
    private String podloga;

    public Domek(@NotNull String wlasciciel, Uzytkownik uzytkownik, @NotNull String pomieszczenia, @NotNull String okna, @NotNull String drzwi, @NotNull String lozko, @NotNull String wanna, @NotNull String umywalka, @NotNull String toaeta, @NotNull String szafki, @NotNull String zlew, @NotNull String kuchenka, @NotNull String lodowka, @NotNull String szafa, @NotNull String obraz, @NotNull String dywany, @NotNull String kominki, @NotNull String kwiaty, @NotNull String wazony, @NotNull String trofea, @NotNull String kojec, @NotNull String krzesla, @NotNull String fotele, @NotNull String sofa, @NotNull String stoly, @NotNull String barek, @NotNull String podloga) {
        this.wlasciciel = wlasciciel;
        this.uzytkownik = uzytkownik;
        this.pomieszczenia = pomieszczenia;
        this.okna = okna;
        this.drzwi = drzwi;
        this.lozko = lozko;
        this.wanna = wanna;
        this.umywalka = umywalka;
        this.toaeta = toaeta;
        this.szafki = szafki;
        this.zlew = zlew;
        this.kuchenka = kuchenka;
        this.lodowka = lodowka;
        this.szafa = szafa;
        this.obraz = obraz;
        this.dywany = dywany;
        this.kominki = kominki;
        this.kwiaty = kwiaty;
        this.wazony = wazony;
        this.trofea = trofea;
        this.kojec = kojec;
        this.krzesla = krzesla;
        this.fotele = fotele;
        this.sofa = sofa;
        this.stoly = stoly;
        this.barek = barek;
        this.podloga = podloga;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(String wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public String getPomieszczenia() {
        return pomieszczenia;
    }

    public void setPomieszczenia(String pomieszczenia) {
        this.pomieszczenia = pomieszczenia;
    }

    public String getOkna() {
        return okna;
    }

    public void setOkna(String okna) {
        this.okna = okna;
    }

    public String getDrzwi() {
        return drzwi;
    }

    public void setDrzwi(String drzwi) {
        this.drzwi = drzwi;
    }

    public String getLozko() {
        return lozko;
    }

    public void setLozko(String lozko) {
        this.lozko = lozko;
    }

    public String getWanna() {
        return wanna;
    }

    public void setWanna(String wanna) {
        this.wanna = wanna;
    }

    public String getUmywalka() {
        return umywalka;
    }

    public void setUmywalka(String umywalka) {
        this.umywalka = umywalka;
    }

    public String getToaeta() {
        return toaeta;
    }

    public void setToaeta(String toaeta) {
        this.toaeta = toaeta;
    }

    public String getSzafki() {
        return szafki;
    }

    public void setSzafki(String szafki) {
        this.szafki = szafki;
    }

    public String getZlew() {
        return zlew;
    }

    public void setZlew(String zlew) {
        this.zlew = zlew;
    }

    public String getKuchenka() {
        return kuchenka;
    }

    public void setKuchenka(String kuchenka) {
        this.kuchenka = kuchenka;
    }

    public String getLodowka() {
        return lodowka;
    }

    public void setLodowka(String lodowka) {
        this.lodowka = lodowka;
    }

    public String getSzafa() {
        return szafa;
    }

    public void setSzafa(String szafa) {
        this.szafa = szafa;
    }

    public String getObraz() {
        return obraz;
    }

    public void setObraz(String obraz) {
        this.obraz = obraz;
    }

    public String getDywany() {
        return dywany;
    }

    public void setDywany(String dywany) {
        this.dywany = dywany;
    }

    public String getKominki() {
        return kominki;
    }

    public void setKominki(String kominki) {
        this.kominki = kominki;
    }

    public String getKwiaty() {
        return kwiaty;
    }

    public void setKwiaty(String kwiaty) {
        this.kwiaty = kwiaty;
    }

    public String getWazony() {
        return wazony;
    }

    public void setWazony(String wazony) {
        this.wazony = wazony;
    }

    public String getTrofea() {
        return trofea;
    }

    public void setTrofea(String trofea) {
        this.trofea = trofea;
    }

    public String getKojec() {
        return kojec;
    }

    public void setKojec(String kojec) {
        this.kojec = kojec;
    }

    public String getKrzesla() {
        return krzesla;
    }

    public void setKrzesla(String krzesla) {
        this.krzesla = krzesla;
    }

    public String getFotele() {
        return fotele;
    }

    public void setFotele(String fotele) {
        this.fotele = fotele;
    }

    public String getSofa() {
        return sofa;
    }

    public void setSofa(String sofa) {
        this.sofa = sofa;
    }

    public String getStoly() {
        return stoly;
    }

    public void setStoly(String stoly) {
        this.stoly = stoly;
    }

    public String getBarek() {
        return barek;
    }

    public void setBarek(String barek) {
        this.barek = barek;
    }

    public String getPodloga() {
        return podloga;
    }

    public void setPodloga(String podloga) {
        this.podloga = podloga;
    }

    @Override
    public String toString() {
        return "Domek{" +
                "wlasciciel='" + wlasciciel + '\'' +
                ", uzytkownik=" + uzytkownik +
                ", pomieszczenia='" + pomieszczenia + '\'' +
                ", okna='" + okna + '\'' +
                ", drzwi='" + drzwi + '\'' +
                ", lozko='" + lozko + '\'' +
                ", wanna='" + wanna + '\'' +
                ", umywalka='" + umywalka + '\'' +
                ", toaeta='" + toaeta + '\'' +
                ", szafki='" + szafki + '\'' +
                ", zlew='" + zlew + '\'' +
                ", kuchenka='" + kuchenka + '\'' +
                ", lodowka='" + lodowka + '\'' +
                ", szafa='" + szafa + '\'' +
                ", obraz='" + obraz + '\'' +
                ", dywany='" + dywany + '\'' +
                ", kominki='" + kominki + '\'' +
                ", kwiaty='" + kwiaty + '\'' +
                ", wazony='" + wazony + '\'' +
                ", trofea='" + trofea + '\'' +
                ", kojec='" + kojec + '\'' +
                ", krzesla='" + krzesla + '\'' +
                ", fotele='" + fotele + '\'' +
                ", sofa='" + sofa + '\'' +
                ", stoly='" + stoly + '\'' +
                ", barek='" + barek + '\'' +
                ", podloga='" + podloga + '\'' +
                '}';
    }
}
