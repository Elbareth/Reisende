package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository("UzytkownikRepositories")
public interface UzytkownikRepositories extends JpaRepository<Uzytkownik, String> {
    Boolean existsByLoginAndHaslo(String login, String haslo);
    ArrayList<Uzytkownik> findAllByOrderByDoswiadczenieDesc();
    Optional<Uzytkownik> findByLogin(String login);
}
