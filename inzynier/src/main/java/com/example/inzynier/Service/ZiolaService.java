package com.example.inzynier.Service;

import com.example.inzynier.Assembler.ZiolaAssembler;
import com.example.inzynier.DTO.ZiolaDTO;
import com.example.inzynier.Repositories.ZiolaRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ZiolaService {
    //wyszukiwanie po nazwie i lista i po planszy
    //brak modyfikacji dodawania oraz usuwania
    @Autowired
    private ZiolaRepositories ziolaRepositories;
    @Autowired
    private ZiolaAssembler ziolaAssembler;
    public ZiolaDTO findByNazwa(String nazwa){
        if(!ziolaRepositories.findByNazwa(nazwa).isPresent()) throw new EntityNotFoundException("Ther is no flower with that name");
        return ziolaAssembler.toDto(ziolaRepositories.findByNazwa(nazwa).get());
    }
    public List<ZiolaDTO> findAll(){
        return ziolaAssembler.toDto(ziolaRepositories.findAll());
    }
    public ZiolaDTO findByPlik(String plik){
        if(!ziolaRepositories.findByPlik(plik).isPresent()) throw new EntityNotFoundException("Ther is no flower with that file");
        return ziolaAssembler.toDto(ziolaRepositories.findByPlik(plik).get());
    }
    public List<ZiolaDTO> findByPlansza(String plansza){
        List<ZiolaDTO> listaZiol = new ArrayList<>();
        List<ZiolaDTO> tmp = ziolaAssembler.toDto(ziolaRepositories.findAll());
        tmp.forEach( it->{
            List<String> listaPlansz = new ArrayList<>();
            List<Integer> listaPozycjiX = new ArrayList<>();
            List<Integer> listaPozycjiY = new ArrayList<>();
            for(int i=0;i<it.getPlansza().size();i++){
                if(it.getPlansza().get(i).equals(plansza)){
                    listaPlansz.add(it.getPlansza().get(i));
                    listaPozycjiX.add(it.getPolozenieX().get(i));
                    listaPozycjiY.add((it.getPolozenieY().get(i)));
                }
            }
            if(listaPlansz.size() > 0){
                ZiolaDTO ziolo = new ZiolaDTO(
                        it.getNazwa(),
                        listaPlansz,
                        listaPozycjiX,
                        listaPozycjiY,
                        it.getOpis(),
                        it.getPlik());
                listaZiol.add(ziolo);
            }
        });
        return listaZiol;
    }
}
