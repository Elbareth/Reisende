package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Domek {
    @Id
    @NotNull
    private String Wlasciciel;
    @NotNull
    private String Pomieszczenia;
    @NotNull
    private String Okna;
    @NotNull
    private String Drzwi;
    @NotNull
    private String Lozko;
    @NotNull
    private String Wanna;
    @NotNull
    private String Umywalka;
    @NotNull
    private String Toaeta;
    @NotNull
    private String Szafki;
    @NotNull
    private String Zlew;
    @NotNull
    private String Kuchenka;
    @NotNull
    private String Lodowka;
    @NotNull
    private String Szafa;
    @NotNull
    private String Obraz;
    @NotNull
    private String Dywany;
    @NotNull
    private String Kominki;
    @NotNull
    private String Kwiaty;
    @NotNull
    private String Wazony;
    @NotNull
    private String Trofea;
    @NotNull
    private String Kojec;
    @NotNull
    private String Krzesla;
    @NotNull
    private String Fotele;
    @NotNull
    private String Sofa;
    @NotNull
    private String Stoly;
    @NotNull
    private String Barek;
    @NotNull
    private String Podloga;

    public String getWlasciciel() {
        return Wlasciciel;
    }

    public void setWlasciciel(String wlasciciel) {
        Wlasciciel = wlasciciel;
    }

    public String getPomieszczenia() {
        return Pomieszczenia;
    }

    public void setPomieszczenia(String pomieszczenia) {
        Pomieszczenia = pomieszczenia;
    }

    public String getOkna() {
        return Okna;
    }

    public void setOkna(String okna) {
        Okna = okna;
    }

    public String getDrzwi() {
        return Drzwi;
    }

    public void setDrzwi(String drzwi) {
        Drzwi = drzwi;
    }

    public String getLozko() {
        return Lozko;
    }

    public void setLozko(String lozko) {
        Lozko = lozko;
    }

    public String getWanna() {
        return Wanna;
    }

    public void setWanna(String wanna) {
        Wanna = wanna;
    }

    public String getUmywalka() {
        return Umywalka;
    }

    public void setUmywalka(String umywalka) {
        Umywalka = umywalka;
    }

    public String getToaeta() {
        return Toaeta;
    }

    public void setToaeta(String toaeta) {
        Toaeta = toaeta;
    }

    public String getSzafki() {
        return Szafki;
    }

    public void setSzafki(String szafki) {
        Szafki = szafki;
    }

    public String getZlew() {
        return Zlew;
    }

    public void setZlew(String zlew) {
        Zlew = zlew;
    }

    public String getKuchenka() {
        return Kuchenka;
    }

    public void setKuchenka(String kuchenka) {
        Kuchenka = kuchenka;
    }

    public String getLodowka() {
        return Lodowka;
    }

    public void setLodowka(String lodowka) {
        Lodowka = lodowka;
    }

    public String getSzafa() {
        return Szafa;
    }

    public void setSzafa(String szafa) {
        Szafa = szafa;
    }

    public String getObraz() {
        return Obraz;
    }

    public void setObraz(String obraz) {
        Obraz = obraz;
    }

    public String getDywany() {
        return Dywany;
    }

    public void setDywany(String dywany) {
        Dywany = dywany;
    }

    public String getKominki() {
        return Kominki;
    }

    public void setKominki(String kominki) {
        Kominki = kominki;
    }

    public String getKwiaty() {
        return Kwiaty;
    }

    public void setKwiaty(String kwiaty) {
        Kwiaty = kwiaty;
    }

    public String getWazony() {
        return Wazony;
    }

    public void setWazony(String wazony) {
        Wazony = wazony;
    }

    public String getTrofea() {
        return Trofea;
    }

    public void setTrofea(String trofea) {
        Trofea = trofea;
    }

    public String getKojec() {
        return Kojec;
    }

    public void setKojec(String kojec) {
        Kojec = kojec;
    }

    public String getKrzesla() {
        return Krzesla;
    }

    public void setKrzesla(String krzesla) {
        Krzesla = krzesla;
    }

    public String getFotele() {
        return Fotele;
    }

    public void setFotele(String fotele) {
        Fotele = fotele;
    }

    public String getSofa() {
        return Sofa;
    }

    public void setSofa(String sofa) {
        Sofa = sofa;
    }

    public String getStoly() {
        return Stoly;
    }

    public void setStoly(String stoly) {
        Stoly = stoly;
    }

    public String getBarek() {
        return Barek;
    }

    public void setBarek(String barek) {
        Barek = barek;
    }

    public String getPodloga() {
        return Podloga;
    }

    public void setPodloga(String podloga) {
        Podloga = podloga;
    }

    public Domek(@NotNull String wlasciciel, @NotNull String pomieszczenia, @NotNull String okna, @NotNull String drzwi, @NotNull String lozko, @NotNull String wanna, @NotNull String umywalka, @NotNull String toaeta, @NotNull String szafki, @NotNull String zlew, @NotNull String kuchenka, @NotNull String lodowka, @NotNull String szafa, @NotNull String obraz, @NotNull String dywany, @NotNull String kominki, @NotNull String kwiaty, @NotNull String wazony, @NotNull String trofea, @NotNull String kojec, @NotNull String krzesla, @NotNull String fotele, @NotNull String sofa, @NotNull String stoly, @NotNull String barek, @NotNull String podloga) {
        Wlasciciel = wlasciciel;
        Pomieszczenia = pomieszczenia;
        Okna = okna;
        Drzwi = drzwi;
        Lozko = lozko;
        Wanna = wanna;
        Umywalka = umywalka;
        Toaeta = toaeta;
        Szafki = szafki;
        Zlew = zlew;
        Kuchenka = kuchenka;
        Lodowka = lodowka;
        Szafa = szafa;
        Obraz = obraz;
        Dywany = dywany;
        Kominki = kominki;
        Kwiaty = kwiaty;
        Wazony = wazony;
        Trofea = trofea;
        Kojec = kojec;
        Krzesla = krzesla;
        Fotele = fotele;
        Sofa = sofa;
        Stoly = stoly;
        Barek = barek;
        Podloga = podloga;
    }

    @Override
    public String toString() {
        return "Domek{" +
                "Wlasciciel='" + Wlasciciel + '\'' +
                ", Pomieszczenia='" + Pomieszczenia + '\'' +
                ", Okna='" + Okna + '\'' +
                ", Drzwi='" + Drzwi + '\'' +
                ", Lozko='" + Lozko + '\'' +
                ", Wanna='" + Wanna + '\'' +
                ", Umywalka='" + Umywalka + '\'' +
                ", Toaeta='" + Toaeta + '\'' +
                ", Szafki='" + Szafki + '\'' +
                ", Zlew='" + Zlew + '\'' +
                ", Kuchenka='" + Kuchenka + '\'' +
                ", Lodowka='" + Lodowka + '\'' +
                ", Szafa='" + Szafa + '\'' +
                ", Obraz='" + Obraz + '\'' +
                ", Dywany='" + Dywany + '\'' +
                ", Kominki='" + Kominki + '\'' +
                ", Kwiaty='" + Kwiaty + '\'' +
                ", Wazony='" + Wazony + '\'' +
                ", Trofea='" + Trofea + '\'' +
                ", Kojec='" + Kojec + '\'' +
                ", Krzesla='" + Krzesla + '\'' +
                ", Fotele='" + Fotele + '\'' +
                ", Sofa='" + Sofa + '\'' +
                ", Stoly='" + Stoly + '\'' +
                ", Barek='" + Barek + '\'' +
                ", Podloga='" + Podloga + '\'' +
                '}';
    }
}
