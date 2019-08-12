package com.example.inzynier.Service;

import com.example.inzynier.Assembler.UzytkownikAssembler;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.Repositories.UzytkownikRepositories;
import com.example.inzynier.tables.Uzytkownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class UzytkownikService {
    @Autowired
    private UzytkownikRepositories  uzytkownikRepositories;
    @Autowired
    private UzytkownikAssembler uzytkownikAssembler;
    //wyszukiwanie po loginie
    //czy dany uzytkownik istnieje -- haslo i login
    //dodawanie modyfikowanie i usuwanie
    public UzytkownikDTO findByLogin(String login){
        return uzytkownikAssembler.toDto(uzytkownikRepositories.findById(login).get());
    }
    public Boolean isUserExist(String login, String haslo){
       return  uzytkownikRepositories.existsByLoginAndHaslo(login, haslo);
    }
    public Boolean isThisLoginInUse(String login){
        return uzytkownikRepositories.existsById(login);
    }
    public UzytkownikDTO create(UzytkownikDTO uzytkownikDTO){
        return uzytkownikAssembler.toDto(uzytkownikRepositories.save(uzytkownikAssembler.toEntity(uzytkownikDTO)));
    }
    public void delete(String login){
        if(isThisLoginInUse(login)) uzytkownikRepositories.deleteById(login);
        else throw new EntityNotFoundException("There is no user with this login");
    }
    @Transactional
    public UzytkownikDTO update(String login, UzytkownikDTO uzytkownikDTO){
        Uzytkownik user = uzytkownikRepositories.getOne(login);
        uzytkownikAssembler.updateEntity(user,uzytkownikDTO);
        return uzytkownikAssembler.toDto(user);
    }
    //lista uzytkownikow posortowanych po punktach doswiadczenia
    public List<UzytkownikDTO> listRaking(){
        return uzytkownikAssembler.toDto(uzytkownikRepositories.findAllByOrderByDoswiadczenieDesc());
    }
}
