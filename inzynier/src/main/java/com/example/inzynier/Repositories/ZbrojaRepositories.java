package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Zbroja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("ZbrojaRepositories")
public interface ZbrojaRepositories extends JpaRepository<Zbroja,String> {
    Optional<Zbroja> findByNazwa(String nazwa);
    Optional<Zbroja> findByPlik(String plik);
    List<Zbroja> findByKlasa(String klasa);
}
