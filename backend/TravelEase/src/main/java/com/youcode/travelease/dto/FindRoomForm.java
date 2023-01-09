package com.youcode.travelease.dto;

import java.time.LocalDate;

public class FindRoomForm {
    private String city;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String type;
    private Integer capacity;

    public String getCity ( ) {
        return city;
    }

    public void setCity ( String city ) {
        this.city = city;
    }

    public LocalDate getDateDebut ( ) {
        return dateDebut;
    }

    public void setDateDebut ( LocalDate dateDebut ) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin ( ) {
        return dateFin;
    }

    public void setDateFin ( LocalDate dateFin ) {
        this.dateFin = dateFin;
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
}
