package com.example.inzynier.Repositories;

import com.example.inzynier.tables.InnePrzedmioty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("InnePrzedmiotyRepositories")
public interface InnePrzedmiotyRepositories extends JpaRepository<InnePrzedmioty, String> {
}
