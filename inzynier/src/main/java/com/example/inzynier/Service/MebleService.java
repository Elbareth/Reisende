package com.example.inzynier.Service;

import com.example.inzynier.Assembler.MebleAssembler;
import com.example.inzynier.DTO.MebleDTO;
import com.example.inzynier.Repositories.MebleRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MebleService {
    @Autowired
    private MebleRepositories mebleRepositories;
    @Autowired
    private MebleAssembler mebleAssembler;
    //Tylko do odczytu
    //bede wyszukiwac po nazwie i kategorii i lista
    //Lista mebli do kuchni
    //Lista mebli do lazienki
    //Lista mebli do sypialni
    //Lista mebli dodatkow
    public MebleDTO getByNazwa(String nazwa){
        return mebleAssembler.toDto(mebleRepositories.findByNazwa(nazwa));
    }

    public List<MebleDTO> getByKategoria(String kategoria){
        return mebleAssembler.toDto(mebleRepositories.findByKategoria(kategoria));
    }

    public List<MebleDTO> getListAll(){
        return mebleAssembler.toDto(mebleRepositories.findAll());
    }

    public List<MebleDTO> getListKuchnii(){
        List<MebleDTO> listaMebli = new ArrayList<>();
        listaMebli.addAll(getByKategoria("Szafki"));
        listaMebli.addAll(getByKategoria("Zlew"));
        listaMebli.addAll(getByKategoria("Kuchnia"));
        listaMebli.addAll(getByKategoria("Lodowki"));
        listaMebli.addAll(getByKategoria("Krzesla"));
        listaMebli.addAll(getByKategoria("Stoly"));
        return listaMebli;
    }

    public List<String> getListKuchniiPliki(){
        List<String> listaMebli = new ArrayList<>();
        getListKuchnii().forEach( it
                -> listaMebli.add(it.getPlik())
        );
        return listaMebli;
    }

    public List<MebleDTO> getListLazienki(){
        List<MebleDTO> listaMebli = new ArrayList<>();
        listaMebli.addAll(getByKategoria("Umywalki"));
        listaMebli.addAll(getByKategoria("Toalety"));
        listaMebli.addAll(getByKategoria("Wanna"));
        return listaMebli;
    }

    public List<String> getListLazienkiPlik(){
        List<String> listaMebli = new ArrayList<>();
        getListLazienki().forEach( it
                -> listaMebli.add(it.getPlik())
        );
        return listaMebli;
    }

    public List<MebleDTO> getListSypialnii(){
        List<MebleDTO> listaMebli = new ArrayList<>();
        listaMebli.addAll(getByKategoria("Lozka"));
        listaMebli.addAll(getByKategoria("Szafa"));
        listaMebli.addAll(getByKategoria("Kominki"));
        listaMebli.addAll(getByKategoria("Fotele"));
        listaMebli.addAll(getByKategoria("Sofa"));
        listaMebli.addAll(getByKategoria("Barki"));
        return listaMebli;
    }

    public List<String> getListSypialniiPlik(){
        List<String> listaMebli = new ArrayList<>();
        getListSypialnii().forEach( it
                -> listaMebli.add(it.getPlik())
        );
        return listaMebli;
    }

    public List<MebleDTO> getListDodatki(){
        List<MebleDTO> listaMebli = new ArrayList<>();
        listaMebli.addAll(getByKategoria("Okna"));
        listaMebli.addAll(getByKategoria("Drzwi"));
        listaMebli.addAll(getByKategoria("Podloga"));
        listaMebli.addAll(getByKategoria("Obrazy"));
        listaMebli.addAll(getByKategoria("Dywany"));
        listaMebli.addAll(getByKategoria("Kwiaty"));
        listaMebli.addAll(getByKategoria("Wazony"));
        listaMebli.addAll(getByKategoria("Trofea"));
        listaMebli.addAll(getByKategoria("Kojec"));
        return listaMebli;
    }

    public List<String> getListDodatkiPlik(){
        List<String> listaMebli = new ArrayList<>();
        getListDodatki().forEach( it
                -> listaMebli.add(it.getPlik())
        );
        return listaMebli;
    }

    public MebleDTO findByPlik(String plik){
        return mebleAssembler.toDto(mebleRepositories.findByPlik(plik));
    }
}
