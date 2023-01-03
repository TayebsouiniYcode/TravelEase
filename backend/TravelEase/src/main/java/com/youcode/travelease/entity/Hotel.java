package com.youcode.travelease.entity;

import com.youcode.travelease.util.ResponseMessage;

import javax.persistence.*;
import java.util.LinkedHashSet;
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

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set < Room > rooms = new LinkedHashSet <> ( );

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "addresse_hotel_id")
    private AddresseHotel addresseHotel;

    public Set < Room > getRooms ( ) {
        return rooms;
    }

    public void setRooms ( Set < Room > rooms ) {
        this.rooms = rooms;
    }

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
