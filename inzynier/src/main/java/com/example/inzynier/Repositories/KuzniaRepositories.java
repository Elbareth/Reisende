package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Kuznia;
import com.example.inzynier.tables.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("KuzniaRepositories")
public interface KuzniaRepositories extends JpaRepository<Kuznia, Integer> {
    List<Kuznia> findByKlasa(String klasa);
    Optional<List<Kuznia>> findBySprzedajacy(Uzytkownik sprzedajacy);
}
