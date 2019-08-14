package com.example.inzynier.DTO;

public class UzytkownikDTO {
    private String login;
    private String haslo;
    private String nick;
    private String klasaPostaci;
    private Integer zloteMonety;
    private Integer doswiadczenie;
    private String wyglad;
    private Character plec;
    private Integer drewno;
    private Integer grudkaGliny;
    private Integer grudkaZelaza;
    private Integer worekZboza;
    private Integer deski;
    private Integer cegly;
    private Integer sztabkaZelaza;
    private Integer chleb;
    private String helm;
    private String zbroja;
    private String buty;
    private String rekawice;
    private String amulet;
    private String tarcza;
    private String bron;
    private Integer sen;
    private Integer glod;
    private Integer higiena;
    private Integer pragnienie;
    private String smok;
    private Integer poziom;
    private String polozenie;

    public UzytkownikDTO(){

    }

    public UzytkownikDTO(
            String login,
            String haslo,
            String nick,
            String klasaPostaci,
            Integer zloteMonety,
            Integer doswiadczenie,
            String wyglad,
            Character plec,
            Integer drewno,
            Integer grudkaGliny,
            Integer grudkaZelaza,
            Integer worekZboza,
            Integer deski,
            Integer cegly,
            Integer sztabkaZelaza,
            Integer chleb,
            String helm,
            String zbroja,
            String buty,
            String rekawice,
            String amulet,
            String tarcza,
            String bron,
            Integer sen,
            Integer glod,
            Integer higiena,
            Integer pragnienie,
            String smok,
            Integer poziom,
            String polozenie) {
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
        return "UzytkownikDTO{" +
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
