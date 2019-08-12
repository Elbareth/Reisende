package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Uzytkownik;
import com.example.inzynier.tables.Wiadomosci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository("WiadomosciRepositories")
public interface WiadomosciRepositories extends JpaRepository<Wiadomosci, Integer> {
    public List<Wiadomosci> findAllByOdbiorcaOrderByDataAsc(Uzytkownik odbiorca);
    public List<Wiadomosci> findAllByNadawcaOrderByDataAsc(Uzytkownik nadawca);
}
