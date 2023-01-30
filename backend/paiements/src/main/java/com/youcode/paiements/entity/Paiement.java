package com.youcode.paiements.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Paiement {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private Long idCommande;

    private Double montant;

    private Long numeroCarte;

    public Paiement() {
    }

    public Paiement(Long id, Long idCommande, Double montant, Long numeroCarte) {
        this.id = id;
        this.idCommande = idCommande;
        this.montant = montant;
        this.numeroCarte = numeroCarte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Long getNumeroCarte() {
        return numeroCarte;
    }

    public void setNumeroCarte(Long numeroCarte) {
        this.numeroCarte = numeroCarte;
    }

    @Override
    public String toString() {
        return "Paiement{" +
                "id=" + id +
                ", idCommande=" + idCommande +
                ", montant=" + montant +
                ", numeroCarte=" + numeroCarte +
                '}';
    }
}