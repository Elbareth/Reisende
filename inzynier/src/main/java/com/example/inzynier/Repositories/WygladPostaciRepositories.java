package com.example.inzynier.Repositories;

import com.example.inzynier.tables.WygladPostaci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository("WygladPostaciRepositories")
public interface WygladPostaciRepositories extends JpaRepository<WygladPostaci, Integer > {
    public Optional<WygladPostaci> findByNazwa(String nazwa);
    public Optional<WygladPostaci> findByPlik(String plik);
}
