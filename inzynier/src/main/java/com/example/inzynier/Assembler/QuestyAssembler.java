package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.QuestyDTO;
import com.example.inzynier.Service.PostacService;
import com.example.inzynier.Service.UzytkownikService;
import com.example.inzynier.tables.Questy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuestyAssembler {
    @Autowired
    private UzytkownikAssembler uzytkownikAssembler;
    @Autowired
    private UzytkownikService uzytkownikService;
    @Autowired
    private PostacAssembler postacAssembler;
    @Autowired
    private PostacService postacService;

    public QuestyDTO toDto(Questy questy){
        return new QuestyDTO(questy.getPostac().getImie(), questy.getWykonujacy().getLogin(), questy.getNoweZadanie(), questy.getTresc(), questy.getNagroda(), questy.getCzyWykonane());
    }
    public List<QuestyDTO> toDto(List<Questy> listaQuesty){
        List<QuestyDTO> listaQuestyDto = new ArrayList<>();
        listaQuesty.forEach(param ->{
            listaQuestyDto.add(toDto(param));
        });
        return listaQuestyDto;
    }
    public QuestyDTO toDtoWithId(Questy questy){
        return new QuestyDTO(questy.getId(), questy.getPostac().getImie(), questy.getWykonujacy().getLogin(), questy.getNoweZadanie(), questy.getTresc(), questy.getNagroda(), questy.getCzyWykonane());
    }
    public List<QuestyDTO> toDtoWithId(List<Questy> listaQuesty){
        List<QuestyDTO> listaQuestyDto = new ArrayList<>();
        listaQuesty.forEach(param ->{
            listaQuestyDto.add(toDtoWithId(param));
        });
        return listaQuestyDto;
    }
    public Questy toEntity(QuestyDTO questyDTO){
        return new Questy(postacAssembler.toEntity(postacService.findByImie(questyDTO.getPostac())), uzytkownikAssembler.toEntity(uzytkownikService.findByLogin(questyDTO.getWykonujacy())), questyDTO.getNoweZadanie(), questyDTO.getTresc(), questyDTO.getNagroda(), questyDTO.getCzyWykonane());
    }
    public List<Questy> toEntity(List<QuestyDTO> listaQuestyDto){
        List<Questy> listaQuesty = new ArrayList<>();
        listaQuestyDto.forEach(param ->{
            listaQuesty.add(toEntity(param));
        });
        return listaQuesty;
    }
    public void updateEntity(Questy questy, QuestyDTO questyDTO){
        questy.setNagroda(questyDTO.getNagroda());
        questy.setNoweZadanie(questyDTO.getNoweZadanie());
        questy.setPostac(postacAssembler.toEntity(postacService.findByImie(questyDTO.getPostac())));
        questy.setTresc(questyDTO.getTresc());
        questy.setWykonujacy(uzytkownikAssembler.toEntity(uzytkownikService.findByLogin(questyDTO.getWykonujacy())));
        questy.setCzyWykonane(questyDTO.getCzyWykonane());
    }
}
