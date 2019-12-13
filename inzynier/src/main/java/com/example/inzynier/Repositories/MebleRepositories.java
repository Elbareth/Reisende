package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Meble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("MebleRepositories")
public interface MebleRepositories extends JpaRepository<Meble, String> {
    Meble findByNazwa(String nazwa);
    List<Meble> findByKategoria(String kategoria);
    Meble findByPlik(String plik);
}
