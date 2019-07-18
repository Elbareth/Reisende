package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Smok;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("SmokRepositories")
public interface SmokRepositories extends JpaRepository<Smok,String> {
}
