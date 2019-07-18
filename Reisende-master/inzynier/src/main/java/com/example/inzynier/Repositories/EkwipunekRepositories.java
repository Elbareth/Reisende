package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Ekwipunek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("EkwipunekRepositories")
public interface EkwipunekRepositories extends JpaRepository<Ekwipunek, Integer > {
}
