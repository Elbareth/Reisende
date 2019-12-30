package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Bestie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("BestieRepositories")
public interface BestieRepositories extends JpaRepository<Bestie, Integer> {
    Optional<Bestie> findByNazwa(String nazwa);
}
