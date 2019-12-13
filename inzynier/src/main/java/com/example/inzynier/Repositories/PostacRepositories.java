package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Postac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("PostacRepositories")
public interface PostacRepositories extends JpaRepository<Postac, String> {
    Optional<Postac> findByImie(String imie);
    Optional<Postac> findByPlik(String plik);
}
