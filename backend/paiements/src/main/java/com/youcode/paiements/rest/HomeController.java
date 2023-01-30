package com.youcode.paiements.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/paiement")
@CrossOrigin()
public class HomeController {

    @GetMapping("/testApi")
    public String testApi() {
        return "this api is worked";
    }
    
}
