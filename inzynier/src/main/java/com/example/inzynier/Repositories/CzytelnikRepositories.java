package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Czytelnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CzytelnikRepositories")
public interface CzytelnikRepositories extends JpaRepository<Czytelnik, Integer> {
}
