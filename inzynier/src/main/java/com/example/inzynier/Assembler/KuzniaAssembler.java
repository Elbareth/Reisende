package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.KuzniaDTO;
import com.example.inzynier.Repositories.UzytkownikRepositories;
import com.example.inzynier.Repositories.ZbrojaRepositories;
import com.example.inzynier.tables.Kuznia;
import com.example.inzynier.tables.Uzytkownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KuzniaAssembler {
    @Autowired
    private UzytkownikRepositories uzytkownikRepositories;
    @Autowired
    private ZbrojaRepositories zbrojaRepositories;
    public KuzniaDTO toDto(Kuznia kuznia){
        String login = null;
        if(!(kuznia.getKupujacy() == null)){
            login = kuznia.getKupujacy().getLogin();
        }
        return new KuzniaDTO(kuznia.getSprzedajacy().getLogin(), login, kuznia.getAktualnaCena(), kuznia.getCzyStala(), kuznia.getIloscLicytujacych(), kuznia.getNazwa().getNazwa(), kuznia.getPlik(), kuznia.getKlasa(), kuznia.getOpis(), kuznia.getDataZakonczenia());
    }
    public List<KuzniaDTO> toDto(List<Kuznia> listaKuznia){
        List<KuzniaDTO> listaKuzniaDto = new ArrayList<>();
        listaKuznia.forEach(param ->{
            listaKuzniaDto.add(toDto(param));
        });
        return listaKuzniaDto;
    }
    public KuzniaDTO toDtoWithID(Kuznia kuznia){
        String login = null;
        if(!(kuznia.getKupujacy() == null)){
            login = kuznia.getKupujacy().getLogin();
        }
        return new KuzniaDTO(kuznia.getId(), kuznia.getSprzedajacy().getLogin(), login, kuznia.getAktualnaCena(), kuznia.getCzyStala(), kuznia.getIloscLicytujacych(), kuznia.getNazwa().getNazwa(), kuznia.getPlik(), kuznia.getKlasa(), kuznia.getOpis(), kuznia.getDataZakonczenia());
    }
    public List<KuzniaDTO> toDtoWithID(List<Kuznia> listaKuznia){
        List<KuzniaDTO> listaKuzniaDto = new ArrayList<>();
        listaKuznia.forEach(param ->{
            listaKuzniaDto.add(toDtoWithID(param));
        });
        return listaKuzniaDto;
    }
    public Kuznia toEntity(KuzniaDTO kuzniaDTO){
        Uzytkownik uzytkownik = null;
        if(uzytkownikRepositories.findByLogin(kuzniaDTO.getKupujacy()).isPresent()){
            uzytkownik = uzytkownikRepositories.findByLogin(kuzniaDTO.getKupujacy()).get();
        }
        return new Kuznia(uzytkownikRepositories.findByLogin(kuzniaDTO.getSprzedajacy()).get(), uzytkownik, kuzniaDTO.getAktualnaCena(), kuzniaDTO.getCzyStala(), kuzniaDTO.getIloscLicytujacych(), zbrojaRepositories.findByNazwa(kuzniaDTO.getNazwa()).get(), kuzniaDTO.getPlik(), kuzniaDTO.getKlasa(), kuzniaDTO.getOpis(), kuzniaDTO.getDataZakonczenia());
    }
    public List<Kuznia> toEntity(List<KuzniaDTO> listaKuzniaDto){
        List<Kuznia> listaKuznia = new ArrayList<>();
        listaKuzniaDto.forEach(param ->{
            listaKuznia.add(toEntity(param));
        });
        return listaKuznia;
    }
    public void updateEntity(Kuznia kuznia, KuzniaDTO kuzniaDTO){
        kuznia.setSprzedajacy(uzytkownikRepositories.findByLogin(kuzniaDTO.getSprzedajacy()).get());
        kuznia.setKupujacy(uzytkownikRepositories.findByLogin(kuzniaDTO.getKupujacy()).get());
        kuznia.setAktualnaCena(kuzniaDTO.getAktualnaCena());
        kuznia.setCzyStala(kuzniaDTO.getCzyStala());
        kuznia.setIloscLicytujacych(kuzniaDTO.getIloscLicytujacych());
        kuznia.setKlasa(kuzniaDTO.getKlasa());
        kuznia.setNazwa(zbrojaRepositories.findByNazwa(kuzniaDTO.getNazwa()).get());
        kuznia.setOpis(kuzniaDTO.getOpis());
        kuznia.setPlik(kuzniaDTO.getPlik());
    }
}
