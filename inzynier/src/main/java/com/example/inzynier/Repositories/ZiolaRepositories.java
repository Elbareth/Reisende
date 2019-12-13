package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Ziola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("ZiolaRepositories")
public interface ZiolaRepositories extends JpaRepository<Ziola,String> {
    Optional<Ziola> findByNazwa(String nazwa);
    Optional<Ziola> findByPlik(String plik);
}
