package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("UzytkownikRepositories")
public interface UzytkownikRepositories extends JpaRepository<Uzytkownik, String> {
}
