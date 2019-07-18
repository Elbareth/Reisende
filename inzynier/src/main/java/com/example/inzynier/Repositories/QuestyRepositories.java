package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Questy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("QuestyRepositories")
public interface QuestyRepositories extends JpaRepository<Questy,Integer> {
}
