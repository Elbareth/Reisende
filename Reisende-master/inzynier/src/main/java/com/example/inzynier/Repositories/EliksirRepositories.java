package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Eliksir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("EliksirRepositories")
public interface EliksirRepositories extends JpaRepository<Eliksir, String> {
}
