package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Postac;
import com.example.inzynier.tables.Questy;
import com.example.inzynier.tables.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("QuestyRepositories")
public interface QuestyRepositories extends JpaRepository<Questy,Integer> {
    Optional<List<Questy>> findByWykonujacy(Uzytkownik uzytkownik);
    List<Questy> findByCzyWykonane(Boolean czyWykonane);
    List<Questy> findByPostac(Postac postac);
    Optional<Questy> findByNoweZadanie(String noweZadanie);
    Optional<Questy> findByNoweZadanieAndWykonujacy(String noweZadanie, Uzytkownik uzytkownik);
    List<Questy> findByWykonujacyAndCzyWykonane(Uzytkownik uzytkownik, Boolean czyWykonane);
    List<Questy> findByNoweZadanieAndWykonujacyAndCzyWykonane(String noweZadanie, Uzytkownik uzytkownik, Boolean czyWykonane);
}
