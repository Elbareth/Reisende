package com.example.inzynier.Service;

import com.example.inzynier.Assembler.PostacAssembler;
import com.example.inzynier.Assembler.QuestyAssembler;
import com.example.inzynier.Assembler.UzytkownikAssembler;
import com.example.inzynier.DTO.QuestyDTO;
import com.example.inzynier.Repositories.QuestyRepositories;
import com.example.inzynier.tables.Questy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestyService {
    //Wyszukiwanie po Wykonujacym, czyWykonane i po id
    //Po nazwie i postaci
    //Bede tez dodawac, usuwac oraz modyfikowac
    @Autowired
    private QuestyRepositories questyRepositories;
    @Autowired
    private QuestyAssembler questyAssembler;
    @Autowired
    private UzytkownikService uzytkownikService;
    @Autowired
    private UzytkownikAssembler uzytkownikAssembler;
    @Autowired
    private PostacService postacService;
    @Autowired
    private PostacAssembler postacAssembler;

    public QuestyDTO create(QuestyDTO questyDTO){
        return questyAssembler.toDtoWithId(questyRepositories.save(questyAssembler.toEntity(questyDTO)));
    }
    public void delete(Integer id){
        if(!questyRepositories.findById(id).isPresent()) throw new EntityNotFoundException("Cant find quest by id");
        questyRepositories.deleteById(id);
    }
    @Transactional
    public QuestyDTO update(Integer id, QuestyDTO questyDTO){
        if(!questyRepositories.findById(id).isPresent()) throw new EntityNotFoundException("Cant find quest by id");
        Questy questy = questyRepositories.findById(id).get();
        questyAssembler.updateEntity(questy, questyDTO);
        return questyDTO;
    }
    public List<QuestyDTO> findByWykonujacy(String wykonujacy){
        if(!questyRepositories.findByWykonujacy(uzytkownikAssembler.toEntity(uzytkownikService.findByLogin(wykonujacy))).isPresent()) throw new EntityNotFoundException("Can'f ind this quest");
        return questyAssembler.toDtoWithId(questyRepositories.findByWykonujacy(uzytkownikAssembler.toEntity(uzytkownikService.findByLogin(wykonujacy))).get());
    }
    public List<QuestyDTO> findByCzyWykonane(Boolean czyWykonane){
        return questyAssembler.toDtoWithId(questyRepositories.findByCzyWykonane(czyWykonane));
    }
    public List<QuestyDTO> findByPostac(String postac){
        return questyAssembler.toDtoWithId(questyRepositories.findByPostac(postacAssembler.toEntity(postacService.findByImie(postac))));
    }
    public QuestyDTO findByNoweZadanie(String noweZadanie, String uzytkownik){
        //if(!questyRepositories.findByNoweZadanie(noweZadanie).isPresent()) throw new EntityNotFoundException("Can't find quest by name");
        //return questyAssembler.toDtoWithId(questyRepositories.findByNoweZadanie(noweZadanie).get());
        final QuestyDTO[] listaQuestow = {null};
        questyRepositories.findAll().forEach( it->{
            String [] tmp = it.getNoweZadanie().split("-");
            if(tmp[0].equals(noweZadanie) && it.getWykonujacy().getLogin().equals(uzytkownik)){
                listaQuestow[0] = questyAssembler.toDtoWithId(it);
            }
        });
        return listaQuestow[0];
    }
    public QuestyDTO findByNoweZadanieAndWykonujacy(String noweZadanie, String uzytkownik){
        if(!questyRepositories.findByNoweZadanieAndWykonujacy(noweZadanie, uzytkownikAssembler.toEntity(uzytkownikService.findByLogin(uzytkownik))).isPresent()) throw new EntityNotFoundException("Cant find quest");
        return questyAssembler.toDtoWithId(questyRepositories.findByNoweZadanieAndWykonujacy(noweZadanie, uzytkownikAssembler.toEntity(uzytkownikService.findByLogin(uzytkownik))).get());
    }
    public List<QuestyDTO> findByWykonujacyAndCzyWykonane(String uzytkownik, Boolean czyWykonane){
        List<QuestyDTO> lista = new ArrayList<>();
        lista = questyAssembler.toDtoWithId(questyRepositories.findByWykonujacyAndCzyWykonane(uzytkownikAssembler.toEntity(uzytkownikService.findByLogin(uzytkownik)), czyWykonane));
        return lista;
    }
    public List<QuestyDTO> findByNoweZadanieAndWykonujacyAndCzyWykonane(String noweZadanie, String uzytkownik, Boolean czyWykonane){
        return questyAssembler.toDtoWithId(questyRepositories.findByNoweZadanieAndWykonujacyAndCzyWykonane(noweZadanie, uzytkownikAssembler.toEntity(uzytkownikService.findByLogin(uzytkownik)), czyWykonane));
    }
}
