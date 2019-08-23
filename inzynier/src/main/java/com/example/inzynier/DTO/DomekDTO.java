package com.example.inzynier.DTO;

import java.util.Objects;

public class DomekDTO {
    private String wlasciciel;
    private String pomieszczenia;
    private String okna;
    private String drzwi;
    private String lozko;
    private String wanna;
    private String umywalka;
    private String toaeta;
    private String szafki;
    private String zlew;
    private String kuchenka;
    private String lodowka;
    private String szafa;
    private String obraz;
    private String dywany;
    private String kominki;
    private String kwiaty;
    private String wazony;
    private String trofea;
    private String kojec;
    private String krzesla;
    private String fotele;
    private String sofa;
    private String stoly;
    private String barek;
    private String podloga;

    public DomekDTO(String wlasciciel, String pomieszczenia, String okna, String drzwi, String lozko, String wanna, String umywalka, String toaeta, String szafki, String zlew, String kuchenka, String lodowka, String szafa, String obraz, String dywany, String kominki, String kwiaty, String wazony, String trofea, String kojec, String krzesla, String fotele, String sofa, String stoly, String barek, String podloga) {
        this.wlasciciel = wlasciciel;
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

    public DomekDTO() {
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(String wlasciciel) {
        this.wlasciciel = wlasciciel;
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
        return "DomekDTO{" +
                "wlasciciel='" + wlasciciel + '\'' +
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomekDTO domekDTO = (DomekDTO) o;
        return wlasciciel.equals(domekDTO.wlasciciel) &&
                pomieszczenia.equals(domekDTO.pomieszczenia) &&
                okna.equals(domekDTO.okna) &&
                drzwi.equals(domekDTO.drzwi) &&
                lozko.equals(domekDTO.lozko) &&
                wanna.equals(domekDTO.wanna) &&
                umywalka.equals(domekDTO.umywalka) &&
                toaeta.equals(domekDTO.toaeta) &&
                szafki.equals(domekDTO.szafki) &&
                zlew.equals(domekDTO.zlew) &&
                kuchenka.equals(domekDTO.kuchenka) &&
                lodowka.equals(domekDTO.lodowka) &&
                szafa.equals(domekDTO.szafa) &&
                obraz.equals(domekDTO.obraz) &&
                dywany.equals(domekDTO.dywany) &&
                kominki.equals(domekDTO.kominki) &&
                kwiaty.equals(domekDTO.kwiaty) &&
                wazony.equals(domekDTO.wazony) &&
                trofea.equals(domekDTO.trofea) &&
                kojec.equals(domekDTO.kojec) &&
                krzesla.equals(domekDTO.krzesla) &&
                fotele.equals(domekDTO.fotele) &&
                sofa.equals(domekDTO.sofa) &&
                stoly.equals(domekDTO.stoly) &&
                barek.equals(domekDTO.barek) &&
                podloga.equals(domekDTO.podloga);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wlasciciel,
                pomieszczenia,
                okna,
                drzwi,
                lozko,
                wanna,
                umywalka,
                toaeta,
                szafki,
                zlew,
                kuchenka,
                lodowka,
                szafa,
                obraz,
                dywany,
                kominki,
                kwiaty,
                wazony,
                trofea,
                kojec,
                krzesla,
                fotele,
                sofa,
                stoly,
                barek,
                podloga);
    }
}
