package com.youcode.paiements.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.paiements.entity.Paiement;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    
    // Optional<Paiement> findById(Long id);
}
