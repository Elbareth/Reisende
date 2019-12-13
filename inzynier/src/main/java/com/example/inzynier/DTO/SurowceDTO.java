package com.example.inzynier.DTO;

import java.util.Objects;

public class SurowceDTO {
    private String drewno;
    private String glina;
    private String zelazo;
    private String zboze;
    private String deski;
    private String cegla;
    private String sztabkaZelaza;
    private String chleb;
    private String studnia;

    public SurowceDTO(String drewno, String glina, String zelazo, String zboze, String deski, String cegla, String sztabkaZelaza, String chleb, String studnia) {
        this.drewno = drewno;
        this.glina = glina;
        this.zelazo = zelazo;
        this.zboze = zboze;
        this.deski = deski;
        this.cegla = cegla;
        this.sztabkaZelaza = sztabkaZelaza;
        this.chleb = chleb;
        this.studnia = studnia;
    }

    public SurowceDTO() {
    }

    public String getDrewno() {
        return drewno;
    }

    public void setDrewno(String drewno) {
        this.drewno = drewno;
    }

    public String getGlina() {
        return glina;
    }

    public void setGlina(String glina) {
        this.glina = glina;
    }

    public String getZelazo() {
        return zelazo;
    }

    public void setZelazo(String zelazo) {
        this.zelazo = zelazo;
    }

    public String getZboze() {
        return zboze;
    }

    public void setZboze(String zboze) {
        this.zboze = zboze;
    }

    public String getDeski() {
        return deski;
    }

    public void setDeski(String deski) {
        this.deski = deski;
    }

    public String getCegla() {
        return cegla;
    }

    public void setCegla(String cegla) {
        this.cegla = cegla;
    }

    public String getSztabkaZelaza() {
        return sztabkaZelaza;
    }

    public void setSztabkaZelaza(String szatbkaZelaza) {
        this.sztabkaZelaza = szatbkaZelaza;
    }

    public String getChleb() {
        return chleb;
    }

    public void setChleb(String chleb) {
        this.chleb = chleb;
    }

    public String getStudnia() {
        return studnia;
    }

    public void setStudnia(String studnia) {
        this.studnia = studnia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SurowceDTO)) return false;
        SurowceDTO that = (SurowceDTO) o;
        return getDrewno().equals(that.getDrewno()) &&
                getGlina().equals(that.getGlina()) &&
                getZelazo().equals(that.getZelazo()) &&
                getZboze().equals(that.getZboze()) &&
                getDeski().equals(that.getDeski()) &&
                getCegla().equals(that.getCegla()) &&
                getSztabkaZelaza().equals(that.getSztabkaZelaza()) &&
                getChleb().equals(that.getChleb()) &&
                getStudnia().equals(that.getStudnia());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDrewno(), getGlina(), getZelazo(), getZboze(), getDeski(), getCegla(), getSztabkaZelaza(), getChleb(), getStudnia());
    }

    @Override
    public String toString() {
        return "SurowceDTO{" +
                "drewno='" + drewno + '\'' +
                ", glina='" + glina + '\'' +
                ", zelazo='" + zelazo + '\'' +
                ", zboze='" + zboze + '\'' +
                ", deski='" + deski + '\'' +
                ", cegla='" + cegla + '\'' +
                ", sztabkaZelaza='" + sztabkaZelaza + '\'' +
                ", chleb='" + chleb + '\'' +
                ", studnia='" + studnia + '\'' +
                '}';
    }
}
