package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.QuestyDTO;
import com.example.inzynier.tables.Questy;

import java.util.ArrayList;
import java.util.List;

public class QuestyAssembler {
    public QuestyDTO toDto(Questy questy){
        return new QuestyDTO(questy.getPostac(), questy.getWykonujacy(), questy.getNoweZadanie(), questy.getTresc(), questy.getNagroda(), questy.getCzyWykonane());
    }
    public List<QuestyDTO> toDto(List<Questy> listaQuesty){
        List<QuestyDTO> listaQuestyDto = new ArrayList<>();
        listaQuesty.forEach(param ->{
            listaQuestyDto.add(toDto(param));
        });
        return listaQuestyDto;
    }
    public Questy toEntity(QuestyDTO questyDTO){
        return new Questy(questyDTO.getPostac(), questyDTO.getWykonujacy(), questyDTO.getNoweZadanie(), questyDTO.getTresc(), questyDTO.getNagroda(), questyDTO.getCzyWykonane());
    }
    public List<Questy> toEntity(List<QuestyDTO> listaQuestyDto){
        List<Questy> listaQuesty = new ArrayList<>();
        listaQuestyDto.forEach(param ->{
            listaQuesty.add(toEntity(param));
        });
        return listaQuesty;
    }
    public void updateEntity(){
        //TODO
    }
}
