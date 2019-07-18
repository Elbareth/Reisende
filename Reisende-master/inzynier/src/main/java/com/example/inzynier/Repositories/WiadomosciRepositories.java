package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Wiadomosci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("WiadomosciRepositories")
public interface WiadomosciRepositories extends JpaRepository<Wiadomosci, Integer> {
}
