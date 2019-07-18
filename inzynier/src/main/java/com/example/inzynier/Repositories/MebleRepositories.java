package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Meble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("MebleRepositories")
public interface MebleRepositories extends JpaRepository<Meble, String> {
}
