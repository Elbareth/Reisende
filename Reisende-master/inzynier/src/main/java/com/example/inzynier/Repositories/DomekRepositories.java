package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Domek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("DomekRepositories")
public interface DomekRepositories extends JpaRepository<Domek, String> {
}
