package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Uzytkownik;
import com.example.inzynier.tables.ZabiteBestie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ZabiteBestieRepositories")
public interface ZabiteBestieRepositories extends JpaRepository<ZabiteBestie, Integer > {
    List<ZabiteBestie> findByUzytkownik(Uzytkownik uzytkownik);
}
