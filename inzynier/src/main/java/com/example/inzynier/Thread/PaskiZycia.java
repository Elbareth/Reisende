package com.example.inzynier.Thread;

import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.Service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


public class PaskiZycia implements Runnable {
    @Autowired
    private UzytkownikService uzytkownikService;
    @Override
    public void run() {
        //TODO po sprawdzeniu chce zeby paski zycia aktualizowaly sie -2 pukty na godzine
        long lastTime = System.currentTimeMillis();
        while(true){
            long test = System.currentTimeMillis();
            if(test - lastTime >=  3600000){
                List<UzytkownikDTO> all = uzytkownikService.findAll();
                for(int i=0;i<all.size();i++){
                    all.get(i).setHigiena(all.get(i).getHigiena()-2);
                    all.get(i).setSen(all.get(i).getSen()-2);
                    all.get(i).setGlod(all.get(i).getGlod()-2);
                    all.get(i).setPragnienie(all.get(i).getPragnienie()-2);
                    uzytkownikService.update(all.get(i).getLogin(), all.get(i));
                }
                lastTime = System.currentTimeMillis();
            }
        }
    }
}
