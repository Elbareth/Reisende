package com.example.inzynier.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Uzytkownik {
    @Id
    @NotNull
    private String Login;
    @NotNull
    private String Haslo;
    @NotNull
    private String Nick;
    @NotNull
    private String KlasaPostaci;
    @NotNull
    private Integer ZloteMonety;
    @NotNull
    private Integer Doswiadczenie;
    @NotNull
    private String Wyglad;
    @NotNull
    private Character Plec;
    @NotNull
    private Integer Drewno;
    @NotNull
    private Integer GrudkaGliny;
    @NotNull
    private Integer GrudkaZelaza;
    @NotNull
    private Integer WorekZboza;
    @NotNull
    private Integer Deski;
    @NotNull
    private Integer Cegly;
    @NotNull
    private Integer SztabkaZelaza;
    @NotNull
    private Integer Chleb;
    @NotNull
    private String Helm;
    @NotNull
    private String Zbroja;
    @NotNull
    private String Buty;
    @NotNull
    private String Rekawice;
    @NotNull
    private String Amulet;
    @NotNull
    private String Tarcza;
    @NotNull
    private String Bron;
    @NotNull
    private Integer Sen;
    @NotNull
    private Integer Glod;
    @NotNull
    private Integer Higiena;
    @NotNull
    private Integer Pragnienie;
    @NotNull
    private String Smok;
    @NotNull
    private Integer Poziom;
    @NotNull
    private String Polozenie;

    public Uzytkownik(@NotNull String login, @NotNull String haslo, @NotNull String nick, @NotNull String klasaPostaci, @NotNull Integer zloteMonety, @NotNull Integer doswiadczenie, @NotNull String wyglad, @NotNull Character plec, @NotNull Integer drewno, @NotNull Integer grudkaGliny, @NotNull Integer grudkaZelaza, @NotNull Integer worekZboza, @NotNull Integer deski, @NotNull Integer cegly, @NotNull Integer sztabkaZelaza, @NotNull Integer chleb, @NotNull String helm, @NotNull String zbroja, @NotNull String buty, @NotNull String rekawice, @NotNull String amulet, @NotNull String tarcza, @NotNull String bron, @NotNull Integer sen, @NotNull Integer glod, @NotNull Integer higiena, @NotNull Integer pragnienie, @NotNull String smok, @NotNull Integer poziom, @NotNull String polozenie) {
        Login = login;
        Haslo = haslo;
        Nick = nick;
        KlasaPostaci = klasaPostaci;
        ZloteMonety = zloteMonety;
        Doswiadczenie = doswiadczenie;
        Wyglad = wyglad;
        Plec = plec;
        Drewno = drewno;
        GrudkaGliny = grudkaGliny;
        GrudkaZelaza = grudkaZelaza;
        WorekZboza = worekZboza;
        Deski = deski;
        Cegly = cegly;
        SztabkaZelaza = sztabkaZelaza;
        Chleb = chleb;
        Helm = helm;
        Zbroja = zbroja;
        Buty = buty;
        Rekawice = rekawice;
        Amulet = amulet;
        Tarcza = tarcza;
        Bron = bron;
        Sen = sen;
        Glod = glod;
        Higiena = higiena;
        Pragnienie = pragnienie;
        Smok = smok;
        Poziom = poziom;
        Polozenie = polozenie;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getHaslo() {
        return Haslo;
    }

    public void setHaslo(String haslo) {
        Haslo = haslo;
    }

    public String getNick() {
        return Nick;
    }

    public void setNick(String nick) {
        Nick = nick;
    }

    public String getKlasaPostaci() {
        return KlasaPostaci;
    }

    public void setKlasaPostaci(String klasaPostaci) {
        KlasaPostaci = klasaPostaci;
    }

    public Integer getZloteMonety() {
        return ZloteMonety;
    }

    public void setZloteMonety(Integer zloteMonety) {
        ZloteMonety = zloteMonety;
    }

    public Integer getDoswiadczenie() {
        return Doswiadczenie;
    }

    public void setDoswiadczenie(Integer doswiadczenie) {
        Doswiadczenie = doswiadczenie;
    }

    public String getWyglad() {
        return Wyglad;
    }

    public void setWyglad(String wyglad) {
        Wyglad = wyglad;
    }

    public Character getPlec() {
        return Plec;
    }

    public void setPlec(Character plec) {
        Plec = plec;
    }

    public Integer getDrewno() {
        return Drewno;
    }

    public void setDrewno(Integer drewno) {
        Drewno = drewno;
    }

    public Integer getGrudkaGliny() {
        return GrudkaGliny;
    }

    public void setGrudkaGliny(Integer grudkaGliny) {
        GrudkaGliny = grudkaGliny;
    }

    public Integer getGrudkaZelaza() {
        return GrudkaZelaza;
    }

    public void setGrudkaZelaza(Integer grudkaZelaza) {
        GrudkaZelaza = grudkaZelaza;
    }

    public Integer getWorekZboza() {
        return WorekZboza;
    }

    public void setWorekZboza(Integer worekZboza) {
        WorekZboza = worekZboza;
    }

    public Integer getDeski() {
        return Deski;
    }

    public void setDeski(Integer deski) {
        Deski = deski;
    }

    public Integer getCegly() {
        return Cegly;
    }

    public void setCegly(Integer cegly) {
        Cegly = cegly;
    }

    public Integer getSztabkaZelaza() {
        return SztabkaZelaza;
    }

    public void setSztabkaZelaza(Integer sztabkaZelaza) {
        SztabkaZelaza = sztabkaZelaza;
    }

    public Integer getChleb() {
        return Chleb;
    }

    public void setChleb(Integer chleb) {
        Chleb = chleb;
    }

    public String getHelm() {
        return Helm;
    }

    public void setHelm(String helm) {
        Helm = helm;
    }

    public String getZbroja() {
        return Zbroja;
    }

    public void setZbroja(String zbroja) {
        Zbroja = zbroja;
    }

    public String getButy() {
        return Buty;
    }

    public void setButy(String buty) {
        Buty = buty;
    }

    public String getRekawice() {
        return Rekawice;
    }

    public void setRekawice(String rekawice) {
        Rekawice = rekawice;
    }

    public String getAmulet() {
        return Amulet;
    }

    public void setAmulet(String amulet) {
        Amulet = amulet;
    }

    public String getTarcza() {
        return Tarcza;
    }

    public void setTarcza(String tarcza) {
        Tarcza = tarcza;
    }

    public String getBron() {
        return Bron;
    }

    public void setBron(String bron) {
        Bron = bron;
    }

    public Integer getSen() {
        return Sen;
    }

    public void setSen(Integer sen) {
        Sen = sen;
    }

    public Integer getGlod() {
        return Glod;
    }

    public void setGlod(Integer glod) {
        Glod = glod;
    }

    public Integer getHigiena() {
        return Higiena;
    }

    public void setHigiena(Integer higiena) {
        Higiena = higiena;
    }

    public Integer getPragnienie() {
        return Pragnienie;
    }

    public void setPragnienie(Integer pragnienie) {
        Pragnienie = pragnienie;
    }

    public String getSmok() {
        return Smok;
    }

    public void setSmok(String smok) {
        Smok = smok;
    }

    public Integer getPoziom() {
        return Poziom;
    }

    public void setPoziom(Integer poziom) {
        Poziom = poziom;
    }

    public String getPolozenie() {
        return Polozenie;
    }

    public void setPolozenie(String polozenie) {
        Polozenie = polozenie;
    }

    @Override
    public String toString() {
        return "Uzytkownik{" +
                "Login='" + Login + '\'' +
                ", Haslo='" + Haslo + '\'' +
                ", Nick='" + Nick + '\'' +
                ", KlasaPostaci='" + KlasaPostaci + '\'' +
                ", ZloteMonety=" + ZloteMonety +
                ", Doswiadczenie=" + Doswiadczenie +
                ", Wyglad='" + Wyglad + '\'' +
                ", Plec=" + Plec +
                ", Drewno=" + Drewno +
                ", GrudkaGliny=" + GrudkaGliny +
                ", GrudkaZelaza=" + GrudkaZelaza +
                ", WorekZboza=" + WorekZboza +
                ", Deski=" + Deski +
                ", Cegly=" + Cegly +
                ", SztabkaZelaza=" + SztabkaZelaza +
                ", Chleb=" + Chleb +
                ", Helm='" + Helm + '\'' +
                ", Zbroja='" + Zbroja + '\'' +
                ", Buty='" + Buty + '\'' +
                ", Rekawice='" + Rekawice + '\'' +
                ", Amulet='" + Amulet + '\'' +
                ", Tarcza='" + Tarcza + '\'' +
                ", Bron='" + Bron + '\'' +
                ", Sen=" + Sen +
                ", Glod=" + Glod +
                ", Higiena=" + Higiena +
                ", Pragnienie=" + Pragnienie +
                ", Smok='" + Smok + '\'' +
                ", Poziom=" + Poziom +
                ", Polozenie='" + Polozenie + '\'' +
                '}';
    }
}
