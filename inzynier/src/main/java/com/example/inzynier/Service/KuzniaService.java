package com.example.inzynier.Service;

import com.example.inzynier.Assembler.KuzniaAssembler;
import com.example.inzynier.Assembler.UzytkownikAssembler;
import com.example.inzynier.DTO.KuzniaDTO;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.Repositories.KuzniaRepositories;
import com.example.inzynier.tables.Kuznia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class KuzniaService {
    //bede dodawac usuwac i edytowac zapytania w kuzni
    //bede wyszukiwac po id i cala liste i  po klasie i po sprzedajacym -- klasa -- wszystkie z danej klasy i w ogole wszystkie
    @Autowired
    private KuzniaAssembler kuzniaAssembler;
    @Autowired
    private KuzniaRepositories kuzniaRepositories;
    @Autowired
    private UzytkownikAssembler uzytkownikAssembler;

    public KuzniaDTO create(KuzniaDTO kuzniaDTO){
        return kuzniaAssembler.toDto(kuzniaRepositories.save(kuzniaAssembler.toEntity(kuzniaDTO)));
    }
    public void delete(Integer id){
        if(!kuzniaRepositories.findById(id).isPresent()) throw new EntityNotFoundException("Can't find this transaction");
        kuzniaRepositories.deleteById(id);
    }
    @Transactional
    public KuzniaDTO update(Integer id, KuzniaDTO kuzniaDTO){
        if(!kuzniaRepositories.findById(id).isPresent()) throw new EntityNotFoundException("Can't find this transaction");
        Kuznia kuznia = kuzniaRepositories.findById(id).get();
        kuzniaAssembler.updateEntity(kuznia, kuzniaDTO);
        return kuzniaDTO;
    }
    public KuzniaDTO findById(Integer id){
        if(!kuzniaRepositories.findById(id).isPresent()) throw new EntityNotFoundException("Can't find this transaction");
        return kuzniaAssembler.toDto(kuzniaRepositories.findById(id).get());
    }
    public List<KuzniaDTO> findAll(){
        return kuzniaAssembler.toDtoWithID(kuzniaRepositories.findAll());
    }
    public List<KuzniaDTO> findByKlasa(String klasa){
        return kuzniaAssembler.toDtoWithID(kuzniaRepositories.findByKlasa(klasa));
    }
    public List<KuzniaDTO> findBySprzedajacy(UzytkownikDTO sprzedajacy){
        if(!kuzniaRepositories.findBySprzedajacy(uzytkownikAssembler.toEntity(sprzedajacy)).isPresent()) throw new EntityNotFoundException("Can't find this transaction");
        return kuzniaAssembler.toDtoWithID(kuzniaRepositories.findBySprzedajacy(uzytkownikAssembler.toEntity(sprzedajacy)).get());
    }
}
