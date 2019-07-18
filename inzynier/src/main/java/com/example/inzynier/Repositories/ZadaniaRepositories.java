package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Zadania;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ZadaniaRepositories")
public interface ZadaniaRepositories extends JpaRepository<Zadania, String> {
}
