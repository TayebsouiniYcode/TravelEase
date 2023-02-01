package com.youcode.paiements.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youcode.paiements.entity.Paiement;
import com.youcode.paiements.service.PaiememtnService;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin()
@RequestMapping("/api/paiement")
public class PaiementController {

    @Autowired
    PaiememtnService paiememtnService;
    
    @PostMapping(value="/checkout")
    public ResponseEntity<Paiement> postMethodName(@RequestBody Paiement paiement) {  
        // check if payement exist or not
        // Paiement paiement2 = this.paiememtnService.getPaiementById(paiement.getId());
        // if (paiement2 == null && paiement2.equals(new Paiement())) {
            return ResponseEntity.ok(this.paiememtnService.checkout(paiement)) ;
        // }
        // return ResponseEntity.ok(null);
    }
}
