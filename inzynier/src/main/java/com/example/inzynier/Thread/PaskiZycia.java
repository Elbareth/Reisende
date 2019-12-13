package com.example.inzynier.Thread;

import com.example.inzynier.BasicService.PoborMonet;
import com.example.inzynier.DTO.UzytkownikDTO;
import com.example.inzynier.Service.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class PaskiZycia implements Runnable {
    @Autowired
    private UzytkownikService uzytkownikService;
    private PoborMonet pobor = new PoborMonet();
    @Override
    public void run() {
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
                    if(all.get(i).getHigiena() <= 0 ||
                       all.get(i).getSen() <= 0     ||
                       all.get(i).getGlod() <= 0    ||
                       all.get(i).getPragnienie() <= 0){
                            all.get(i).setHigiena(0);
                            all.get(i).setSen(0);
                            all.get(i).setGlod(0);
                            all.get(i).setPragnienie(0);
                            pobor.poborMonet(10, all.get(i));
                    }
                    uzytkownikService.update(all.get(i).getLogin(), all.get(i));
                }
                lastTime = System.currentTimeMillis();
            }
        }
    }
}
