package com.youcode.travelease.util;

import java.time.LocalDate;

public class ReservationForm {
    private Long idRoom;
    private Long idUser;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    public Long getIdRoom ( ) {
        return idRoom;
    }

    public void setIdRoom ( Long idRoom ) {
        this.idRoom = idRoom;
    }

    public Long getIdUser ( ) {
        return idUser;
    }

    public void setIdUser ( Long idUser ) {
        this.idUser = idUser;
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

    @Override
    public String toString ( ) {
        return "ReservationForm{" +
                "idRoom=" + idRoom +
                ", idUser=" + idUser +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                '}';
    }
}
