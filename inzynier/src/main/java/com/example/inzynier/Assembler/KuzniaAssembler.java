package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.KuzniaDTO;
import com.example.inzynier.tables.Kuznia;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class KuzniaAssembler {
    @Autowired
    private UzytkownikAssembler uzytkownikAssembler;
    @Autowired
    private ZbrojaAssembler zbrojaAssembler;
    public KuzniaDTO toDto(Kuznia kuznia){
        return new KuzniaDTO(uzytkownikAssembler.toDto(kuznia.getSprzedajacy()), kuznia.getAktualnaCena(), kuznia.getCzyStala(), kuznia.getIloscLicytujacych(), zbrojaAssembler.toDto(kuznia.getNazwa()), kuznia.getPlik(), kuznia.getKlasa(), kuznia.getOpis());
    }
    public List<KuzniaDTO> toDto(List<Kuznia> listaKuznia){
        List<KuzniaDTO> listaKuzniaDto = new ArrayList<>();
        listaKuznia.forEach(param ->{
            listaKuzniaDto.add(toDto(param));
        });
        return listaKuzniaDto;
    }
    public Kuznia toEntity(KuzniaDTO kuzniaDTO){
        return new Kuznia(uzytkownikAssembler.toEntity(kuzniaDTO.getSprzedajacy()), kuzniaDTO.getAktualnaCena(), kuzniaDTO.getCzyStala(), kuzniaDTO.getIloscLicytujacych(), zbrojaAssembler.toEntity(kuzniaDTO.getNazwa()), kuzniaDTO.getPlik(), kuzniaDTO.getKlasa(), kuzniaDTO.getOpis());
    }
    public List<Kuznia> toEntity(List<KuzniaDTO> listaKuzniaDto){
        List<Kuznia> listaKuznia = new ArrayList<>();
        listaKuzniaDto.forEach(param ->{
            listaKuznia.add(toEntity(param));
        });
        return listaKuznia;
    }
    public void updateEntity(){
        //TODO
    }
}
