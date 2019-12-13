package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Postac;
import com.example.inzynier.tables.Zadania;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("ZadaniaRepositories")
public interface ZadaniaRepositories extends JpaRepository<Zadania, String> {
    Optional<Zadania> findByNazwa(String nazwa);
    List<Zadania> findByPostac(Postac postac);
}
