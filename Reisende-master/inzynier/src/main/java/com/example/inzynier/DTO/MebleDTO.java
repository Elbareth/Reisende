package com.example.inzynier.DTO;

public class MebleDTO {
    private String Nazwa;
    private String Plik;
    private String Kategoria;
    private Integer Glod;
    private Integer Sen;
    private Integer Pragnienie;
    private Integer Higiena;
    private Integer Doswiadczenia;

    public MebleDTO(String nazwa, String plik, String kategoria, Integer glod, Integer sen, Integer pragnienie, Integer higiena, Integer doswiadczenia) {
        Nazwa = nazwa;
        Plik = plik;
        Kategoria = kategoria;
        Glod = glod;
        Sen = sen;
        Pragnienie = pragnienie;
        Higiena = higiena;
        Doswiadczenia = doswiadczenia;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public String getPlik() {
        return Plik;
    }

    public void setPlik(String plik) {
        Plik = plik;
    }

    public String getKategoria() {
        return Kategoria;
    }

    public void setKategoria(String kategoria) {
        Kategoria = kategoria;
    }

    public Integer getGlod() {
        return Glod;
    }

    public void setGlod(Integer glod) {
        Glod = glod;
    }

    public Integer getSen() {
        return Sen;
    }

    public void setSen(Integer sen) {
        Sen = sen;
    }

    public Integer getPragnienie() {
        return Pragnienie;
    }

    public void setPragnienie(Integer pragnienie) {
        Pragnienie = pragnienie;
    }

    public Integer getHigiena() {
        return Higiena;
    }

    public void setHigiena(Integer higiena) {
        Higiena = higiena;
    }

    public Integer getDoswiadczenia() {
        return Doswiadczenia;
    }

    public void setDoswiadczenia(Integer doswiadczenia) {
        Doswiadczenia = doswiadczenia;
    }

    @Override
    public String toString() {
        return "MebleDTO{" +
                "Nazwa='" + Nazwa + '\'' +
                ", Plik='" + Plik + '\'' +
                ", Kategoria='" + Kategoria + '\'' +
                ", Glod=" + Glod +
                ", Sen=" + Sen +
                ", Pragnienie=" + Pragnienie +
                ", Higiena=" + Higiena +
                ", Doswiadczenia=" + Doswiadczenia +
                '}';
    }
}
