package com.example.inzynier.Service;

import com.example.inzynier.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DialogService {

    @Autowired
    private DialogPostaciService dialogPostaciService;
    @Autowired
    private EkwipunekService ekwipunekService;
    @Autowired
    private QuestyService questyService;
    @Autowired
    private UzytkownikService uzytkownikService;

    public Integer checkDialog(UzytkownikDTO uzytkownikDTO, ModelMap modelMap, DialogPostaciDTO dialogPostaciDTO, String dialog, Integer index){
        Integer tmp = 0;
        switch (dialogPostaciDTO.getPostac()){
            case "Wiedzma Jagma":
                return checkWiedzmaJagma(dialogPostaciDTO, modelMap, uzytkownikDTO, dialog, index);
            case "Zielarka":
                return checkZielarka(dialogPostaciDTO, modelMap, uzytkownikDTO, dialog, index);
            case "Kolekcjoner":
                return checkKolekcjoner(dialogPostaciDTO, modelMap, uzytkownikDTO, dialog, index);
            case "Astrolog":
                return checkAstrolog(dialogPostaciDTO, modelMap, uzytkownikDTO, dialog, index);
            case "Bibliotekarz":
                return checkBibliotekarz(dialogPostaciDTO, modelMap, uzytkownikDTO, dialog, index);
            case "Pokerzysta":
                return checkPokerzysta(dialogPostaciDTO, modelMap, uzytkownikDTO, dialog, index);
            case "Chomik":
                return checkChomik(dialogPostaciDTO, modelMap, uzytkownikDTO, dialog, index);
        }
        return tmp;
    }
    private Integer checkWiedzmaJagma(DialogPostaciDTO dialogPostaciDTO, ModelMap modelMap, UzytkownikDTO uzytkownikDTO, String dialog, Integer index){
        QuestyDTO questyDTO = questyService.findByNoweZadanie(dialogPostaciDTO.getNazwaQuesta(), uzytkownikDTO.getLogin());
        String [] tmp = questyDTO.getNoweZadanie().split("-");
        switch (dialog) {
            case "Nic z tego! Zbieraj jagody sama":
                modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() - 2).getTekst());
                index = dialogPostaciDTO.getId() - 3;
                questyDTO.setNoweZadanie(tmp[0]+"-"+index);
                break;
            case "Ty: Tak. Prosze oto one.":
                try {
                    if (ekwipunekService.findByWlascicielAndNazwa(uzytkownikDTO, "Jagody").size() >= 10) {
                        modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() + 1).getTekst());
                        List<EkwipunekDTO> ekwipunekDTO = ekwipunekService.findByWlascicielAndNazwa(uzytkownikDTO, "Jagody");
                        for (int i = 0; i < 10; i++) {
                            ekwipunekService.delete(ekwipunekDTO.get(i).getId());
                        }
                    }
                    else {
                        modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() - 2).getTekst());
                        index = dialogPostaciDTO.getId() - 3;
                        questyDTO.setNoweZadanie(tmp[0]+"-"+index);
                    }
                }
                catch (EntityNotFoundException e){
                    modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() - 2).getTekst());
                    index = dialogPostaciDTO.getId() - 3;
                    questyDTO.setNoweZadanie(tmp[0]+"-"+index);
                }
                break;
            case " Nie. Potrzebuje wiecej czasu":
                modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() -2).getTekst());
                index = dialogPostaciDTO.getId() - 3;
                questyDTO.setNoweZadanie(tmp[0]+"-"+index);
                break;
        }
        questyService.update(questyDTO.getId(), questyDTO);
        return index;
    }
    private Integer checkZielarka(DialogPostaciDTO dialogPostaciDTO, ModelMap modelMap, UzytkownikDTO uzytkownikDTO, String dialog, Integer index){
        QuestyDTO questyDTO = questyService.findByNoweZadanie(dialogPostaciDTO.getNazwaQuesta(), uzytkownikDTO.getLogin());
        String [] tmp = questyDTO.getNoweZadanie().split("-");
        switch (dialog){
            case " Nie. Ne bchodzi mnie to":
                modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() - 2).getTekst());
                index = dialogPostaciDTO.getId() - 3;
                questyDTO.setNoweZadanie(tmp[0]+"-"+index);
                break;
            case "Ty: Prosze. To ziola dla Ciebie":
                try{
                    if(ekwipunekService.findByWlascicielAndNazwa(uzytkownikDTO, "Rumianek").size() >= 10 &&
                            ekwipunekService.findByWlascicielAndNazwa(uzytkownikDTO, "Lawenda").size() >=5 &&
                            ekwipunekService.findByWlascicielAndNazwa(uzytkownikDTO, "Szalawia").size() >= 15){
                        modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() + 1).getTekst());
                        List<EkwipunekDTO> rumianek = ekwipunekService.findByWlascicielAndNazwa(uzytkownikDTO, "Rumianek");
                        for(int i=0;i<10;i++){
                            ekwipunekService.delete(rumianek.get(i).getId());
                        }
                        List<EkwipunekDTO> lawenda = ekwipunekService.findByWlascicielAndNazwa(uzytkownikDTO, "Lawenda");
                        for(int k=0;k<5;k++){
                            ekwipunekService.delete(lawenda.get(k).getId());
                        }
                        List<EkwipunekDTO> szalwia = ekwipunekService.findByWlascicielAndNazwa(uzytkownikDTO, "Szalwia");
                        for(int l=0;l<15;l++){
                            ekwipunekService.delete(szalwia.get(l).getId());
                        }
                    }
                    else{
                        modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() - 2).getTekst());
                        index = dialogPostaciDTO.getId() - 3;
                        questyDTO.setNoweZadanie(tmp[0]+"-"+index);
                    }
                }
                catch(EntityNotFoundException e){
                    modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() - 2).getTekst());
                    index = dialogPostaciDTO.getId() - 3;
                    questyDTO.setNoweZadanie(tmp[0]+"-"+index);
                }
                break;
            case "(...)":
                modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() -2).getTekst());
                index = dialogPostaciDTO.getId() - 3;
                questyDTO.setNoweZadanie(tmp[0]+"-"+index);
                break;
        }
        questyService.update(questyDTO.getId(), questyDTO);
        return index;
    }
    private Integer checkKolekcjoner(DialogPostaciDTO dialogPostaciDTO, ModelMap modelMap, UzytkownikDTO uzytkownikDTO, String dialog, Integer index){
        QuestyDTO questyDTO = questyService.findByNoweZadanie(dialogPostaciDTO.getNazwaQuesta(), uzytkownikDTO.getLogin());
        String [] tmp = questyDTO.getNoweZadanie().split("-");
        switch (dialog){
            case "Ty: Tak sie skalada ze mam jedna lalke i z chcecia ja sprzedam":
                try{
                    if(ekwipunekService.findByWlascicielAndNazwa(uzytkownikDTO, "Lalka").size() >= 1){
                        modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() + 1).getTekst());
                        EkwipunekDTO lalka = ekwipunekService.findByWlascicielAndNazwa(uzytkownikDTO, "Lalka").get(0);
                        ekwipunekService.delete(lalka.getId());
                    }
                    else{
                        modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() - 2).getTekst());
                        index = dialogPostaciDTO.getId() - 3;
                        questyDTO.setNoweZadanie(tmp[0]+"-"+index);
                    }
                }
                catch(EntityNotFoundException e){
                    modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() - 2).getTekst());
                    index = dialogPostaciDTO.getId() - 3;
                    questyDTO.setNoweZadanie(tmp[0]+"-"+index);
                }
                break;
            case " Niestety nie mam Ci co sprzedac.":
                modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() -2).getTekst());
                index = dialogPostaciDTO.getId() - 3;
                questyDTO.setNoweZadanie(tmp[0]+"-"+index);
                break;
        }
        questyService.update(questyDTO.getId(), questyDTO);
        return index;
    }
    private Integer checkAstrolog(DialogPostaciDTO dialogPostaciDTO, ModelMap modelMap, UzytkownikDTO uzytkownikDTO, String dialog, Integer index){
        QuestyDTO questyDTO = questyService.findByNoweZadanie(dialogPostaciDTO.getNazwaQuesta(), uzytkownikDTO.getLogin());
        String [] tmp = questyDTO.getNoweZadanie().split("-");
        switch (dialog){
            case "Ty: Jasne. Mozesz sprobowac":
                modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() + 1).getTekst());
                break;
            case "Nie dzieki. Nie wierze w takie bzdury.":
                modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() + 2).getTekst());
                index = dialogPostaciDTO.getId() + 1;
                questyDTO.setNoweZadanie(tmp[0]+"-"+index);
                break;
            case "Nie mam na to czasu":
                modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() -2).getTekst());
                index = dialogPostaciDTO.getId() - 3;
                questyDTO.setNoweZadanie(tmp[0]+"-"+index);
                break;
            case "Ty: Tak. Oto ona. Prosze":
                try{
                    if(ekwipunekService.findByWlascicielAndNazwa(uzytkownikDTO, "Luneta").size() >= 1){
                        modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() + 1).getTekst());
                        EkwipunekDTO luneta = ekwipunekService.findByWlascicielAndNazwa(uzytkownikDTO, "Luneta").get(0);
                        ekwipunekService.delete(luneta.getId());
                    }
                    else{
                        modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() -2).getTekst());
                        index = dialogPostaciDTO.getId() - 3;
                        questyDTO.setNoweZadanie(tmp[0]+"-"+index);
                        break;
                    }
                }
                catch (EntityNotFoundException e){
                    modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() -2).getTekst());
                    index = dialogPostaciDTO.getId() - 3;
                    questyDTO.setNoweZadanie(tmp[0]+"-"+index);
                    break;
                }
                break;
            case " Jeszcze nie. Potrzebuje czasu. ":
                modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() -2).getTekst());
                index = dialogPostaciDTO.getId() - 3;
                questyDTO.setNoweZadanie(tmp[0]+"-"+index);
                break;
        }
        questyService.update(questyDTO.getId(), questyDTO);
        return index;
    }
    private Integer checkBibliotekarz(DialogPostaciDTO dialogPostaciDTO, ModelMap modelMap, UzytkownikDTO uzytkownikDTO, String dialog, Integer index){
        QuestyDTO questyDTO = questyService.findByNoweZadanie(dialogPostaciDTO.getNazwaQuesta(), uzytkownikDTO.getLogin());
        String [] tmp = questyDTO.getNoweZadanie().split("-");
        switch (dialog){
            case " Witaj! Chce sprzedac ksiazke":
                try{
                    //za sprzedana ksiazke dostajemy pieniadze - kazda ksiazka kosztuje 100 Zlotych Monet
                    if(ekwipunekService.findByWlascicielAndNazwa(uzytkownikDTO, "KsiazkaZWrozbami").size() >= 1){
                        EkwipunekDTO ksiazkaZWrozbami = ekwipunekService.findByWlascicielAndNazwa(uzytkownikDTO, "KsiazkaZWrozbami").get(0);
                        ekwipunekService.delete(ksiazkaZWrozbami.getId());
                        uzytkownikDTO.setZloteMonety(uzytkownikDTO.getZloteMonety() + 100);
                        uzytkownikService.update(uzytkownikDTO.getLogin(), uzytkownikDTO);
                    }
                    else if(ekwipunekService.findByWlascicielAndNazwa(uzytkownikDTO, "Zielnik").size() >= 1){
                        EkwipunekDTO zielnik = ekwipunekService.findByWlascicielAndNazwa(uzytkownikDTO, "Zielnik").get(0);
                        ekwipunekService.delete(zielnik.getId());
                        uzytkownikDTO.setZloteMonety(uzytkownikDTO.getZloteMonety() + 100);
                        uzytkownikService.update(uzytkownikDTO.getLogin(), uzytkownikDTO);
                    }
                    else{
                        modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() -2).getTekst());
                        index = dialogPostaciDTO.getId() - 3;
                        questyDTO.setNoweZadanie(tmp[0]+"-"+index);
                        break;
                    }
                }
                catch (EntityNotFoundException e){
                    modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() -2).getTekst());
                    index = dialogPostaciDTO.getId() - 3;
                    questyDTO.setNoweZadanie(tmp[0]+"-"+index);
                    break;
                }
                break;
            case " Witaj! Tak sie tylko rozgladam":
                modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() -2).getTekst());
                index = dialogPostaciDTO.getId() - 3;
                questyDTO.setNoweZadanie(tmp[0]+"-"+index);
                break;
        }
        questyService.update(questyDTO.getId(), questyDTO);
        return index;
    }
    private Integer checkPokerzysta(DialogPostaciDTO dialogPostaciDTO, ModelMap modelMap, UzytkownikDTO uzytkownikDTO, String dialog, Integer index){
        QuestyDTO questyDTO = questyService.findByNoweZadanie(dialogPostaciDTO.getNazwaQuesta(), uzytkownikDTO.getLogin());
        String [] tmp = questyDTO.getNoweZadanie().split("-");
        if(dialog.equals(" Innym razem")){
            modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() -2).getTekst());
            index = dialogPostaciDTO.getId() - 3;
            questyDTO.setNoweZadanie(tmp[0]+"-"+index);
        }
        questyService.update(questyDTO.getId(), questyDTO);
        return index;
    }
    private Integer checkChomik(DialogPostaciDTO dialogPostaciDTO, ModelMap modelMap, UzytkownikDTO uzytkownikDTO, String dialog, Integer index){
        QuestyDTO questyDTO = questyService.findByNoweZadanie(dialogPostaciDTO.getNazwaQuesta(), uzytkownikDTO.getLogin());
        String [] tmp = questyDTO.getNoweZadanie().split("-");
        switch (dialog){
            case "Ty: Dam mu cos do jedzenia":
                if(uzytkownikDTO.getWorekZboza() >= 10){
                    uzytkownikDTO.setWorekZboza(uzytkownikDTO.getWorekZboza() - 10);
                    uzytkownikService.update(uzytkownikDTO.getLogin(), uzytkownikDTO);
                    break;
                }
                else{
                    modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() -2).getTekst());
                    index = dialogPostaciDTO.getId() - 3;
                    questyDTO.setNoweZadanie(tmp[0]+"-"+index);
                    break;
                }
            case " Ide. Nic tu po mnie":
                modelMap.put("dialog", dialogPostaciService.findById(dialogPostaciDTO.getId() -2).getTekst());
                index = dialogPostaciDTO.getId() - 3;
                questyDTO.setNoweZadanie(tmp[0]+"-"+index);
                break;
        }
        questyService.update(questyDTO.getId(), questyDTO);
        return index;
    }
}
