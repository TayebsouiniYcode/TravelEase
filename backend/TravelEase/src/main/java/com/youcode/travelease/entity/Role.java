package com.youcode.travelease.entity;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "role_name", unique = true, length = 100)
    private String role_name;

    @Column(name = "description", length = 200)
    private String description;

    public Role ( Long id , String role_name ) {
        this.id = id;
        this.role_name = role_name;
    }

    public Role ( ) {

    }

    public String getDescription ( ) {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public String getRole_name ( ) {
        return role_name;
    }

    public void setRole_name ( String role_name ) {
        this.role_name = role_name;
    }

    public Long getId ( ) {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }
}
