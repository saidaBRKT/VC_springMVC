package com.visionaryCrofting.demo.repositories;

import com.visionaryCrofting.demo.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long> {
    Commande findByRef(String ref);
}
