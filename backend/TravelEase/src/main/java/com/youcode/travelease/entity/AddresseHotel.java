package com.youcode.travelease.entity;

import javax.persistence.*;

@Entity
public class AddresseHotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "address")
    private String address;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public String getAddress ( ) {
        return address;
    }

    @Column(name = "country")
    private String country;

    public void setAddress ( String address ) {
        this.address = address;
    }

    @Column(name = "city")
    private String city;

    public Hotel getHotel ( ) {
        return hotel;
    }

    public void setHotel ( Hotel hotel ) {
        this.hotel = hotel;
    }

    public String getCountry ( ) {
        return country;
    }

    public void setCountry ( String country ) {
        this.country = country;
    }

    public String getCity ( ) {
        return city;
    }

    public void setCity ( String city ) {
        this.city = city;
    }

    public Long getId ( ) {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }
}
