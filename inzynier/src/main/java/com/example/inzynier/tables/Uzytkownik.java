package com.example.inzynier.tables;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "d_uzytkownik")
public class Uzytkownik {
    @Id
    @NotNull
    private String login;
    @NotNull
    private String haslo;
    @NotNull
    private String nick;
    @NotNull
    @Column(name = "klasa_postaci")
    private String klasaPostaci;
    @NotNull
    @Column(name = "zlote_monety")
    private Integer zloteMonety;
    @NotNull
    private Integer doswiadczenie;
    @NotNull
    private String wyglad;
    @NotNull
    private Character plec;
    @NotNull
    private Integer drewno;
    @NotNull
    @Column(name = "grudka_gliny")
    private Integer grudkaGliny;
    @NotNull
    @Column(name = "grudka_zelaza")
    private Integer grudkaZelaza;
    @NotNull
    @Column(name = "worek_zboza")
    private Integer worekZboza;
    @NotNull
    private Integer deski;
    @NotNull
    private Integer cegly;
    @NotNull
    @Column(name = "sztabka_zelaza")
    private Integer sztabkaZelaza;
    @NotNull
    private Integer chleb;
    @NotNull
    private String helm;
    @NotNull
    private String zbroja;
    @NotNull
    private String buty;
    @NotNull
    private String rekawice;
    @NotNull
    private String amulet;
    @NotNull
    private String tarcza;
    @NotNull
    private String bron;
    @NotNull
    private Integer sen;
    @NotNull
    private Integer glod;
    @NotNull
    private Integer higiena;
    @NotNull
    private Integer pragnienie;
    @NotNull
    private String smok;
    @NotNull
    private Integer poziom;
    @NotNull
    private String polozenie;

    public  Uzytkownik(){

    }

    public Uzytkownik(@NotNull String login, @NotNull String haslo, @NotNull String nick, @NotNull String klasaPostaci, @NotNull Integer zloteMonety, @NotNull Integer doswiadczenie, @NotNull String wyglad, @NotNull Character plec, @NotNull Integer drewno, @NotNull Integer grudkaGliny, @NotNull Integer grudkaZelaza, @NotNull Integer worekZboza, @NotNull Integer deski, @NotNull Integer cegly, @NotNull Integer sztabkaZelaza, @NotNull Integer chleb, @NotNull String helm, @NotNull String zbroja, @NotNull String buty, @NotNull String rekawice, @NotNull String amulet, @NotNull String tarcza, @NotNull String bron, @NotNull Integer sen, @NotNull Integer glod, @NotNull Integer higiena, @NotNull Integer pragnienie, @NotNull String smok, @NotNull Integer poziom, @NotNull String polozenie) {
        this.login = login;
        this.haslo = haslo;
        this.nick = nick;
        this.klasaPostaci = klasaPostaci;
        this.zloteMonety = zloteMonety;
        this.doswiadczenie = doswiadczenie;
        this.wyglad = wyglad;
        this.plec = plec;
        this.drewno = drewno;
        this.grudkaGliny = grudkaGliny;
        this.grudkaZelaza = grudkaZelaza;
        this.worekZboza = worekZboza;
        this.deski = deski;
        this.cegly = cegly;
        this.sztabkaZelaza = sztabkaZelaza;
        this.chleb = chleb;
        this.helm = helm;
        this.zbroja = zbroja;
        this.buty = buty;
        this.rekawice = rekawice;
        this.amulet = amulet;
        this.tarcza = tarcza;
        this.bron = bron;
        this.sen = sen;
        this.glod = glod;
        this.higiena = higiena;
        this.pragnienie = pragnienie;
        this.smok = smok;
        this.poziom = poziom;
        this.polozenie = polozenie;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getKlasaPostaci() {
        return klasaPostaci;
    }

    public void setKlasaPostaci(String klasaPostaci) {
        this.klasaPostaci = klasaPostaci;
    }

    public Integer getZloteMonety() {
        return zloteMonety;
    }

    public void setZloteMonety(Integer zloteMonety) {
        this.zloteMonety = zloteMonety;
    }

    public Integer getDoswiadczenie() {
        return doswiadczenie;
    }

    public void setDoswiadczenie(Integer doswiadczenie) {
        this.doswiadczenie = doswiadczenie;
    }

    public String getWyglad() {
        return wyglad;
    }

    public void setWyglad(String wyglad) {
        this.wyglad = wyglad;
    }

    public Character getPlec() {
        return plec;
    }

    public void setPlec(Character plec) {
        this.plec = plec;
    }

    public Integer getDrewno() {
        return drewno;
    }

    public void setDrewno(Integer drewno) {
        this.drewno = drewno;
    }

    public Integer getGrudkaGliny() {
        return grudkaGliny;
    }

    public void setGrudkaGliny(Integer grudkaGliny) {
        this.grudkaGliny = grudkaGliny;
    }

    public Integer getGrudkaZelaza() {
        return grudkaZelaza;
    }

    public void setGrudkaZelaza(Integer grudkaZelaza) {
        this.grudkaZelaza = grudkaZelaza;
    }

    public Integer getWorekZboza() {
        return worekZboza;
    }

    public void setWorekZboza(Integer worekZboza) {
        this.worekZboza = worekZboza;
    }

    public Integer getDeski() {
        return deski;
    }

    public void setDeski(Integer deski) {
        this.deski = deski;
    }

    public Integer getCegly() {
        return cegly;
    }

    public void setCegly(Integer cegly) {
        this.cegly = cegly;
    }

    public Integer getSztabkaZelaza() {
        return sztabkaZelaza;
    }

    public void setSztabkaZelaza(Integer sztabkaZelaza) {
        this.sztabkaZelaza = sztabkaZelaza;
    }

    public Integer getChleb() {
        return chleb;
    }

    public void setChleb(Integer chleb) {
        this.chleb = chleb;
    }

    public String getHelm() {
        return helm;
    }

    public void setHelm(String helm) {
        this.helm = helm;
    }

    public String getZbroja() {
        return zbroja;
    }

    public void setZbroja(String zbroja) {
        this.zbroja = zbroja;
    }

    public String getButy() {
        return buty;
    }

    public void setButy(String buty) {
        this.buty = buty;
    }

    public String getRekawice() {
        return rekawice;
    }

    public void setRekawice(String rekawice) {
        this.rekawice = rekawice;
    }

    public String getAmulet() {
        return amulet;
    }

    public void setAmulet(String amulet) {
        this.amulet = amulet;
    }

    public String getTarcza() {
        return tarcza;
    }

    public void setTarcza(String tarcza) {
        this.tarcza = tarcza;
    }

    public String getBron() {
        return bron;
    }

    public void setBron(String bron) {
        this.bron = bron;
    }

    public Integer getSen() {
        return sen;
    }

    public void setSen(Integer sen) {
        this.sen = sen;
    }

    public Integer getGlod() {
        return glod;
    }

    public void setGlod(Integer glod) {
        this.glod = glod;
    }

    public Integer getHigiena() {
        return higiena;
    }

    public void setHigiena(Integer higiena) {
        this.higiena = higiena;
    }

    public Integer getPragnienie() {
        return pragnienie;
    }

    public void setPragnienie(Integer pragnienie) {
        this.pragnienie = pragnienie;
    }

    public String getSmok() {
        return smok;
    }

    public void setSmok(String smok) {
        this.smok = smok;
    }

    public Integer getPoziom() {
        return poziom;
    }

    public void setPoziom(Integer poziom) {
        this.poziom = poziom;
    }

    public String getPolozenie() {
        return polozenie;
    }

    public void setPolozenie(String polozenie) {
        this.polozenie = polozenie;
    }

    @Override
    public String toString() {
        return "Uzytkownik{" +
                "login='" + login + '\'' +
                ", haslo='" + haslo + '\'' +
                ", nick='" + nick + '\'' +
                ", klasaPostaci='" + klasaPostaci + '\'' +
                ", zloteMonety=" + zloteMonety +
                ", doswiadczenie=" + doswiadczenie +
                ", wyglad='" + wyglad + '\'' +
                ", plec=" + plec +
                ", drewno=" + drewno +
                ", grudkaGliny=" + grudkaGliny +
                ", grudkaZelaza=" + grudkaZelaza +
                ", worekZboza=" + worekZboza +
                ", deski=" + deski +
                ", cegly=" + cegly +
                ", sztabkaZelaza=" + sztabkaZelaza +
                ", chleb=" + chleb +
                ", helm='" + helm + '\'' +
                ", zbroja='" + zbroja + '\'' +
                ", buty='" + buty + '\'' +
                ", rekawice='" + rekawice + '\'' +
                ", amulet='" + amulet + '\'' +
                ", tarcza='" + tarcza + '\'' +
                ", bron='" + bron + '\'' +
                ", sen=" + sen +
                ", glod=" + glod +
                ", higiena=" + higiena +
                ", pragnienie=" + pragnienie +
                ", smok='" + smok + '\'' +
                ", poziom=" + poziom +
                ", polozenie='" + polozenie + '\'' +
                '}';
    }
}
