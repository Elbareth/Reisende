package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Eliksir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("EliksirRepositories")
public interface EliksirRepositories extends JpaRepository<Eliksir, String> {
    Optional<Eliksir> findByNazwa(String nazwa);
    Optional<Eliksir> findByPlik(String plik);
}
