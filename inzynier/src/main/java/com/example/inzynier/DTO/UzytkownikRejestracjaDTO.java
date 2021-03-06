package com.example.inzynier.DTO;

import java.util.Objects;

public class UzytkownikRejestracjaDTO {
    private String login;
    private String haslo;
    private String nick;
    private String klasaPostaci;
    private Character plec;

    public UzytkownikRejestracjaDTO() {
    }

    public UzytkownikRejestracjaDTO(String login,
                                    String haslo,
                                    String nick,
                                    String klasaPostaci,
                                    Character plec) {
        this.login = login;
        this.haslo = haslo;
        this.nick = nick;
        this.klasaPostaci = klasaPostaci;
        this.plec = plec;
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

    public Character getPlec() {
        return plec;
    }

    public void setPlec(Character plec) {
        this.plec = plec;
    }

    @Override
    public String toString() {
        return "UzytkownikRejestracjaDTO{" +
                "login='" + login + '\'' +
                ", haslo='" + haslo + '\'' +
                ", nick='" + nick + '\'' +
                ", klasaPostaci='" + klasaPostaci + '\'' +
                ", plec=" + plec +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UzytkownikRejestracjaDTO that = (UzytkownikRejestracjaDTO) o;
        return login.equals(that.login) &&
                haslo.equals(that.haslo) &&
                nick.equals(that.nick) &&
                klasaPostaci.equals(that.klasaPostaci) &&
                plec.equals(that.plec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login,
                haslo,
                nick,
                klasaPostaci,
                plec);
    }
}

