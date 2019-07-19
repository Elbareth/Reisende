package com.example.inzynier.Assembler;

public class ZadaniaAssembler {
    public WygladPostaciDTO toDto(WygladPostaci wygladPostaci){
        return new WygladPostaciDTO(wygladPostaci.getNazwa(), wygladPostaci.getKlasa(), wygladPostaci.getPlik(), wygladPostaci.getKategoria());
    }
    public List<WygladPostaciDTO> toDto(List<WygladPostaci> listaWygladPostaci){
        List<WygladPostaciDTO> listaWygladPostaciDto = new ArrayList<>();
        listaWygladPostaci.forEach(param ->{
            listaWygladPostaciDto.add(toDto(param));
        });
        return listaWygladPostaciDto;
    }
    public WygladPostaci toEntity(WygladPostaciDTO wygladPostaciDTO){
        return new WygladPostaci(wygladPostaciDTO.getNazwa(), wygladPostaciDTO.getKlasa(), wygladPostaciDTO.getPlik(), wygladPostaciDTO.getKategoria());
    }
    public List<WygladPostaci> toEntity(List<WygladPostaciDTO> listaWygladPostaciDto){
        List<WygladPostaci> listaWygladPostaci = new ArrayList<>();
        listaWygladPostaciDto.forEach(param ->{
            listaWygladPostaci.add(toEntity(param));
        });
        return listaWygladPostaci;
    }
}
