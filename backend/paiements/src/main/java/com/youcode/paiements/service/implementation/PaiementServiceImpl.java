package com.youcode.paiements.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.paiements.entity.Paiement;
import com.youcode.paiements.repository.PaiementRepository;
import com.youcode.paiements.service.PaiememtnService;

@Service
public class PaiementServiceImpl implements PaiememtnService{
    @Autowired
    PaiementRepository paiementRepository;

    @Override
    public Paiement getPaiementById(Long id) {
        Optional<Paiement> optionalPaiement =  this.paiementRepository.findById(id);
        if (optionalPaiement.isPresent()) {
            return optionalPaiement.get();
        } else {
            return null;
        }
    }

    @Override
    public Paiement checkout(Paiement paiement) {
        return this.paiementRepository.save(paiement);
        
    }
    
}
