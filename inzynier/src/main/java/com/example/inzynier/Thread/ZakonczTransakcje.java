package com.example.inzynier.Thread;

import com.example.inzynier.DTO.EkwipunekDTO;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.Service.EkwipunekService;
import com.example.inzynier.Service.KuzniaService;
import com.example.inzynier.Service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

public class ZakonczTransakcje implements Runnable {
    @Autowired
    private KuzniaService kuzniaService;
    @Autowired
    private UzytkownikService uzytkownikService;
    @Autowired
    private EkwipunekService ekwipunekService;
    @Override
    public void run() {
        while(true){
            kuzniaService.findAll().forEach( it -> {
                if(it.getDataZakonczenia().compareTo(LocalDateTime.now()) <= 0){
                    kuzniaService.delete(it.getId()); // usuwamy tranzakcje
                    List<EkwipunekDTO> ekwipunekDTO = ekwipunekService.findByWlascicielAndNazwa(uzytkownikService.findByLogin(it.getSprzedajacy()), it.getNazwa());//usuwamy element bylemu uzytkownikowi
                    //Przesylamy pieniadze
                    try{
                        ekwipunekDTO.get(0).setWlasciciel(uzytkownikService.findByLogin(it.getKupujacy()));//dodajemy element nowemy uzytkownikowi
                        ekwipunekService.update(ekwipunekDTO.get(0).getId(), ekwipunekDTO.get(0)); // przepisujemy na nowego wlasciciela
                        UzytkownikDTO kupujacy = uzytkownikService.findByLogin(it.getKupujacy());
                        kupujacy.setZloteMonety(kupujacy.getZloteMonety() - it.getAktualnaCena().intValue());
                        uzytkownikService.update(kupujacy.getLogin(), kupujacy);
                    }
                    catch(EntityNotFoundException e){
                        ekwipunekService.delete(ekwipunekDTO.get(0).getId()); // w przypadku gdy brak nowego właściciela usuwamy
                        e.printStackTrace();
                    }
                    UzytkownikDTO sprzedajacy = uzytkownikService.findByLogin(it.getSprzedajacy());
                    sprzedajacy.setZloteMonety(sprzedajacy.getZloteMonety() + it.getAktualnaCena().intValue());
                    uzytkownikService.update(sprzedajacy.getLogin(), sprzedajacy);
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
