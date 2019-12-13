package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Budynki;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("BudynkiRepositories")
public interface BudynkiRepositories extends JpaRepository<Budynki, String> {
    Optional<Budynki> findByNazwa(String nazwa);
    Optional<Budynki> findByPlik(String plik);
}
