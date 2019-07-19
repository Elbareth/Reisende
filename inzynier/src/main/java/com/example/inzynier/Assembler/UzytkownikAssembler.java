package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.tables.Uzytkownik;

import java.util.ArrayList;
import java.util.List;

public class UzytkownikAssembler {
    public UzytkownikDTO toDto(Uzytkownik uzytkownik){
        return new UzytkownikDTO(uzytkownik.getLogin(), uzytkownik.getHaslo(), uzytkownik.getNick(), uzytkownik.getKlasaPostaci(), uzytkownik.getZloteMonety(), uzytkownik.getDoswiadczenie(), uzytkownik.getWyglad(), uzytkownik.getPlec(), uzytkownik.getDrewno(), uzytkownik.getGrudkaGliny(), uzytkownik.getGrudkaZelaza(), uzytkownik.getWorekZboza(), uzytkownik.getDeski(), uzytkownik.getCegly(), uzytkownik.getSztabkaZelaza(), uzytkownik.getChleb(), uzytkownik.getHelm(), uzytkownik.getZbroja(), uzytkownik.getButy(), uzytkownik.getRekawice(), uzytkownik.getAmulet(), uzytkownik.getTarcza(), uzytkownik.getBron(), uzytkownik.getSen(), uzytkownik.getGlod(), uzytkownik.getHigiena(), uzytkownik.getPragnienie(), uzytkownik.getSmok(), uzytkownik.getPoziom(), uzytkownik.getPolozenie());
    }
    public List<UzytkownikDTO> toDto(List<Uzytkownik> listaUzytkownik){
        List<UzytkownikDTO> listaUytkownikDto = new ArrayList<>();
        listaUzytkownik.forEach(param ->{
            listaUytkownikDto.add(toDto(param));
        });
        return listaUytkownikDto;
    }
    public Uzytkownik toEntity(UzytkownikDTO uzytkownikDTO){
        return new Uzytkownik(uzytkownikDTO.getLogin(), uzytkownikDTO.getHaslo(), uzytkownikDTO.getNick(), uzytkownikDTO.getKlasaPostaci(), uzytkownikDTO.getZloteMonety(), uzytkownikDTO.getDoswiadczenie(), uzytkownikDTO.getWyglad(), uzytkownikDTO.getPlec(), uzytkownikDTO.getDrewno(), uzytkownikDTO.getGrudkaGliny(), uzytkownikDTO.getGrudkaZelaza(), uzytkownikDTO.getWorekZboza(), uzytkownikDTO.getDeski(), uzytkownikDTO.getCegly(), uzytkownikDTO.getSztabkaZelaza(), uzytkownikDTO.getChleb(), uzytkownikDTO.getHelm(), uzytkownikDTO.getZbroja(), uzytkownikDTO.getButy(), uzytkownikDTO.getRekawice(), uzytkownikDTO.getAmulet(), uzytkownikDTO.getTarcza(), uzytkownikDTO.getBron(), uzytkownikDTO.getSen(), uzytkownikDTO.getGlod(), uzytkownikDTO.getHigiena(), uzytkownikDTO.getPragnienie(), uzytkownikDTO.getSmok(), uzytkownikDTO.getPoziom(), uzytkownikDTO.getPolozenie());
    }
    public List<Uzytkownik> toEntity(List<UzytkownikDTO> listaUzytkownikDto){
        List<Uzytkownik> listaUzytkownik = new ArrayList<>();
        listaUzytkownikDto.forEach(param ->{
            listaUzytkownik.add(toEntity(param));
        });
        return listaUzytkownik;
    }
    public void updateEntity(){
        //TODO
    }
}
