package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Ksiazki;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("KsiazkiRepositories")
public interface KsiazkiRepositories extends JpaRepository<Ksiazki, Integer> {
    Optional<Ksiazki> findByNazwa(String nazwa);
}
