package com.youcode.travelease.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Room {
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set < Reservation > reservations = new LinkedHashSet <> ( );

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "number", length = 10)
    private String number;

    @Column(name = "number_of_personne")
    private Integer numberOfPersonne;

    @Column(name = "price")
    private Double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Column(name = "capacity")
    private Integer capacity;

    public Integer getCapacity ( ) {
        return capacity;
    }

    public void setCapacity ( Integer capacity ) {
        this.capacity = capacity;
    }

    public Set < Reservation > getReservations ( ) {
        return reservations;
    }

    public void setReservations ( Set < Reservation > reservations ) {
        this.reservations = reservations;
    }

    public Hotel getHotel ( ) {
        return hotel;
    }

    public void setHotel ( Hotel hotel ) {
        this.hotel = hotel;
    }

    public Double getPrice ( ) {
        return price;
    }

    public void setPrice ( Double price ) {
        this.price = price;
    }

    public Integer getNumberOfPersonne ( ) {
        return numberOfPersonne;
    }

    public void setNumberOfPersonne ( Integer numberOfPersonne ) {
        this.numberOfPersonne = numberOfPersonne;
    }

    public String getNumber ( ) {
        return number;
    }

    public void setNumber ( String number ) {
        this.number = number;
    }

    public Long getId ( ) {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }
}
