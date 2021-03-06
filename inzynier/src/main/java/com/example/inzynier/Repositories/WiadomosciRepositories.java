package com.example.inzynier.Repositories;

import com.example.inzynier.tables.Uzytkownik;
import com.example.inzynier.tables.Wiadomosci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository("WiadomosciRepositories")
public interface WiadomosciRepositories extends JpaRepository<Wiadomosci, Integer> {
    List<Wiadomosci> findAllByOdbiorcaOrderByDataDesc(Uzytkownik odbiorca);
    List<Wiadomosci> findAllByNadawcaOrderByDataDesc(Uzytkownik nadawca);
}
