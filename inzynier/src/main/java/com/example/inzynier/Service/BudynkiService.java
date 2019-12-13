package com.example.inzynier.Service;

import com.example.inzynier.Assembler.BudynkiAssembler;
import com.example.inzynier.DTO.BudynkiDTO;
import com.example.inzynier.Repositories.BudynkiRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BudynkiService {
    @Autowired
    private BudynkiRepositories budynkiRepositories;
    @Autowired
    private BudynkiAssembler budynkiAssembler;
    private List<String> listaBudynkowOnClick;
    //budynki nie beda dodawane ani modyfikowane ani usuwane w kodzie
    //potrzebuje jedynie liste budynkow oraz wyszukiwanie po nazwie
    //potrzebuje listy budynkow dla danej planszy
    //i ta lista bedzie dzielona na budynki ktore mozna przyciskac lub na budynki do ktorych mozna tylko wejsc
    //stworzyc metode onClick i przeslonic ja odpowiednimy klasami budynkow?????
    public BudynkiService(){
        listaBudynkowOnClick = new ArrayList<>();
        listaBudynkowOnClick.add("ZdzbloZboza");
        listaBudynkowOnClick.add("Piekarnia");
        listaBudynkowOnClick.add("KopalniaGliny");
        listaBudynkowOnClick.add("Cegielnia");
        listaBudynkowOnClick.add("KopalniaZelaza");
        listaBudynkowOnClick.add("Kuznia");
        listaBudynkowOnClick.add("Zbrojownia");
        listaBudynkowOnClick.add("Drzewo");
        listaBudynkowOnClick.add("Tartak");
        listaBudynkowOnClick.add("Targ");
        listaBudynkowOnClick.add("Studnia");
    }
    public BudynkiDTO findByName(String name){
        if(!budynkiRepositories.findByNazwa(name).isPresent()) return null;
        return budynkiAssembler.toDto(budynkiRepositories.findByNazwa(name).get());
    }
    public BudynkiDTO findByPlik(String plik){
        if(!budynkiRepositories.findByPlik(plik).isPresent()) return null;
        return budynkiAssembler.toDto(budynkiRepositories.findByPlik(plik).get());
    }
    public List<BudynkiDTO> findAll(){
        return budynkiAssembler.toDto(budynkiRepositories.findAll());
    }
    public List<BudynkiDTO> findByPlanszaOnClick(String plansza){
        List<BudynkiDTO> listaOnClick = new ArrayList<>();
        findAll().forEach( it -> {
            if (it.getPlansza().equals(plansza) && listaBudynkowOnClick.contains(it.getNazwa())) {
                listaOnClick.add(it);
            }
        });
        return listaOnClick;
    }
    public List<BudynkiDTO> findByPlanszaInside(String plansza){
        List<BudynkiDTO> listaInside = new ArrayList<>();
        findAll().forEach( it -> {
            if (it.getPlansza().equals(plansza) && !listaBudynkowOnClick.contains(it.getNazwa())) {
                listaInside.add(it);
            }
        });
        return listaInside;
    }
}
