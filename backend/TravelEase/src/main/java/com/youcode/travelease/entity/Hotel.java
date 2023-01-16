package com.youcode.travelease.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.travelease.util.ResponseMessage;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "approved")
    private Boolean approved;

    @ManyToOne
    @JoinColumn(name = "proprietaire_id")
    @JsonIgnore
    private User proprietaire;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "addresse_hotel_id")
    private AddresseHotel addresseHotel;

    @OneToMany(mappedBy = "hotel", orphanRemoval = true)
    private List < Room > rooms = new ArrayList <> ( );

    public AddresseHotel getAddresseHotel ( ) {
        return addresseHotel;
    }

    public void setAddresseHotel ( AddresseHotel addresseHotel ) {
        this.addresseHotel = addresseHotel;
    }

    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public Long getId ( ) {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    @Transient
    private ResponseMessage message;

    public User getProprietaire ( ) {
        return proprietaire;
    }

    public void setProprietaire ( User proprietaire ) {
        this.proprietaire = proprietaire;
    }

    public List < Room > getRooms ( ) {
        return rooms;
    }

    public void setRooms ( List < Room > rooms ) {
        this.rooms = rooms;
    }

    public Boolean getApproved ( ) {
        return approved;
    }

    public void setApproved ( Boolean approved ) {
        this.approved = approved;
    }

    public ResponseMessage getMessage ( ) {
        return message;
    }

    public void setMessage ( ResponseMessage message ) {
        this.message = message;
    }
}
