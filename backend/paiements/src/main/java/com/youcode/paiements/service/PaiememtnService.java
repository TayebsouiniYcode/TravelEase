package com.youcode.paiements.service;

import org.springframework.stereotype.Service;

import com.youcode.paiements.entity.Paiement;

@Service
public interface PaiememtnService {
    Paiement getPaiementById(Long id);

    Paiement checkout(Paiement paiement);
}
