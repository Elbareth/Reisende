package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Zbroja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ZbrojaRepositories")
public interface ZbrojaRepositories extends JpaRepository<Zbroja,String> {
}
