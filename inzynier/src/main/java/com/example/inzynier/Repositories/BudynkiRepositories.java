package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Budynki;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("BudynkiRepositories")
public interface BudynkiRepositories extends JpaRepository<Budynki, String> {
}
