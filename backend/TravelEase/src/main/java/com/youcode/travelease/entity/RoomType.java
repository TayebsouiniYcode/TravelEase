package com.youcode.travelease.entity;

import javax.persistence.*;

@Entity
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId ( ) {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    @Column(name = "type")
    private String type;

    public String getType ( ) {
        return type;
    }

    public void setType ( String type ) {
        this.type = type;
    }
}
