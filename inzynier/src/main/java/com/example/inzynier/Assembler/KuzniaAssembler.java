package com.example.inzynier.Assembler;

import com.example.inzynier.DTO.KuzniaDTO;
import com.example.inzynier.tables.Kuznia;

import java.util.ArrayList;
import java.util.List;

public class KuzniaAssembler {
    public KuzniaDTO toDto(Kuznia kuznia){
        return new KuzniaDTO(kuznia.getSprzedajacy(), kuznia.getAktualnaCena(), kuznia.getCzyStala(), kuznia.getIloscLicytujacych(), kuznia.getNazwa(), kuznia.getPlik(), kuznia.getKlasa(), kuznia.getOpis());
    }
    public List<KuzniaDTO> toDto(List<Kuznia> listaKuznia){
        List<KuzniaDTO> listaKuzniaDto = new ArrayList<>();
        listaKuznia.forEach(param ->{
            listaKuzniaDto.add(toDto(param));
        });
        return listaKuzniaDto;
    }
    public Kuznia toEntity(KuzniaDTO kuzniaDTO){
        return new Kuznia(kuzniaDTO.getSprzedajacy(), kuzniaDTO.getAktualnaCena(), kuzniaDTO.getCzyStala(), kuzniaDTO.getIloscLicytujacych(), kuzniaDTO.getNazwa(), kuzniaDTO.getPlik(), kuzniaDTO.getKlasa(), kuzniaDTO.getOpis());
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
