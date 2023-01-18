package com.youcode.travelease.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")

    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Room room;

    public Room getRoom ( ) {
        return room;
    }

    public void setRoom ( Room room ) {
        this.room = room;
    }

    public User getUser ( ) {
        return user;
    }

    public void setUser ( User user ) {
        this.user = user;
    }

    public LocalDate getDateFin ( ) {
        return dateFin;
    }

    public void setDateFin ( LocalDate dateFin ) {
        this.dateFin = dateFin;
    }

    public LocalDate getDateDebut ( ) {
        return dateDebut;
    }

    public void setDateDebut ( LocalDate dateDebut ) {
        this.dateDebut = dateDebut;
    }

    public Long getId ( ) {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }
}
