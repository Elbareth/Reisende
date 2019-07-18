package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Postac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("PostacRepositories")
public interface PostacRepositories extends JpaRepository<Postac, String> {
}
