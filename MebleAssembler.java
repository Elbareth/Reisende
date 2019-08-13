package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.MebleDTO;
import com.example.inzynier.tables.Meble;

import java.util.ArrayList;
import java.util.List;

public class MebleAssembler {
    public MebleDTO toDto(Meble meble){
        return new MebleDTO(meble.getNazwa(), meble.getPlik(), meble.getKategoria(),meble.getCena(), meble.getGlod(), meble.getSen(), meble.getPragnienie(), meble.getHigiena(), meble.getDoswiadczenia());
    }
    public List<MebleDTO> toDto(List<Meble> listaMeble){
        List<MebleDTO> listaMebleDto = new ArrayList<>();
        listaMeble.forEach(param ->{
            listaMebleDto.add(toDto(param));
        });
        return listaMebleDto;
    }
    public Meble toEntity(MebleDTO mebleDTO){
        return new Meble(mebleDTO.getNazwa(), mebleDTO.getPlik(), mebleDTO.getKategoria(),mebleDTO.getCena(), mebleDTO.getGlod(), mebleDTO.getSen(), mebleDTO.getPragnienie(), mebleDTO.getHigiena(), mebleDTO.getDoswiadczenia());
    }
    public List<Meble> toEntity(List<MebleDTO> listaMebleDto){
        List<Meble> listaMeble = new ArrayList<>();
        listaMebleDto.forEach(param ->{
            listaMeble.add(toEntity(param));
        });
        return listaMeble;
    }
}
