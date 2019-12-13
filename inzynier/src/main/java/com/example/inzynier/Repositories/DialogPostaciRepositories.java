package com.example.inzynier.Repositories;

import com.example.inzynier.tables.DialogPostaci;
import com.example.inzynier.tables.Postac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("DialogPostaciRepositories")
public interface DialogPostaciRepositories extends JpaRepository<DialogPostaci, Integer> {
    List<DialogPostaci> findByNazwaQuesta(String nazwaQuesta);
    List<DialogPostaci> findByPostac(Postac postac);
    Optional<DialogPostaci> findByIdAndNazwaQuestaAndTekst(Integer id, String nazwaQuesta, String tekst);
    Optional<DialogPostaci> findByTekst(String tekst);
    List<DialogPostaci> findByNazwaQuestaAndPostac(String nazwaQuesta, Postac postac);
}
