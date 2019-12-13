package com.example.inzynier.Repositories;

import com.example.inzynier.tables.InnePrzedmioty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("InnePrzedmiotyRepositories")
public interface InnePrzedmiotyRepositories extends JpaRepository<InnePrzedmioty, String> {
    Optional<InnePrzedmioty> findByNazwa(String nazwa);
    Optional<InnePrzedmioty> findByPlik(String plik);
}
