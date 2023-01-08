package com.youcode.travelease.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "number", length = 10)
    private String number;

    @Column(name = "price")
    private Double price;

    @Column(name = "capacity")
    private Integer capacity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    private Hotel hotel;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set < Reservation > reservations = new LinkedHashSet <> ( );

    public String getDescription ( ) {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public String getType ( ) {
        return type;
    }

    public void setType ( String type ) {
        this.type = type;
    }

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
