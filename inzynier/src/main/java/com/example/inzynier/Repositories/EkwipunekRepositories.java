package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Ekwipunek;
import com.example.inzynier.tables.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("EkwipunekRepositories")
public interface EkwipunekRepositories extends JpaRepository<Ekwipunek, Integer > {
    Optional<List<Ekwipunek>> findByWlasciciel(Uzytkownik wlasciciel);
    Optional<List<Ekwipunek>> findByWlascicielAndNazwa(Uzytkownik wlasciciel, String nazwa);
}
