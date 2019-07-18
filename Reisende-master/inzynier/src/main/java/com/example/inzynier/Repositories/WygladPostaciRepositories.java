package com.example.inzynier.Repositories;

import com.example.inzynier.tables.WygladPostaci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("WygladPostaciRepositories")
public interface WygladPostaciRepositories extends JpaRepository<WygladPostaci, Integer > {
}
