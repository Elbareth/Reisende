package com.example.inzynier.Repositories;

import com.example.inzynier.tables.DialogPostaci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("DialogPostaciRepositories")
public interface DialogPostaciRepositories extends JpaRepository<DialogPostaci, Integer> {
}
