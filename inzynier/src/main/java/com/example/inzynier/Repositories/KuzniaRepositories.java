package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Kuznia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("KuzniaRepositories")
public interface KuzniaRepositories extends JpaRepository<Kuznia, Integer> {
}
