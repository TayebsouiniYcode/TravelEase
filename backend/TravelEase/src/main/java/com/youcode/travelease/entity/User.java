package com.youcode.travelease.entity;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    @ManyToMany(cascade = {CascadeType.PERSIST , CascadeType.MERGE})
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set < Role > roles = new LinkedHashSet <> ( );

    @ManyToMany
    @JoinTable(name = "user_authorities",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authorities_id"))
    private Set < Authority > authorities = new LinkedHashSet <> ( );

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set < Reservation > reservations = new LinkedHashSet <> ( );

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "username", unique = true, length = 50)
    private String username;

    @Column(name = "email", unique = true, length = 100)
    private String email;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "phone", length = 30)
    private String phone;

    @Column(name = "lastname", length = 50)
    private String lastname;

    @Column(name = "firstname", length = 50)
    private String firstname;

    public Set < Reservation > getReservations ( ) {
        return reservations;
    }

    public void setReservations ( Set < Reservation > reservations ) {
        this.reservations = reservations;
    }

    public Address getAddress ( ) {
        return address;
    }

    public void setAddress ( Address address ) {
        this.address = address;
    }

    public Set < Authority > getAuthorities ( ) {
        return authorities;
    }

    public void setAuthorities ( Set < Authority > authorities ) {
        this.authorities = authorities;
    }

    public Set < Role > getRoles ( ) {
        return roles;
    }

    public void setRoles ( Set < Role > roles ) {
        this.roles = roles;
    }

    public Long getId ( ) {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public Timestamp getModifiedAt ( ) {
        return modifiedAt;
    }

    public void setModifiedAt ( Timestamp modifiedAt ) {
        this.modifiedAt = modifiedAt;
    }

    public Timestamp getCreatedAt ( ) {
        return createdAt;
    }

    public void setCreatedAt ( Timestamp createdAt ) {
        this.createdAt = createdAt;
    }

    public Double getBalance ( ) {
        return balance;
    }

    public void setBalance ( Double balance ) {
        this.balance = balance;
    }

    public String getPassword ( ) {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    public String getUsername ( ) {
        return username;
    }

    public void setUsername ( String username ) {
        this.username = username;
    }

    public String getEmail ( ) {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public String getPhone ( ) {
        return phone;
    }

    public void setPhone ( String phone ) {
        this.phone = phone;
    }

    public String getLastname ( ) {
        return lastname;
    }

    public void setLastname ( String lastname ) {
        this.lastname = lastname;
    }

    public String getFirstname ( ) {
        return firstname;
    }

    public void setFirstname ( String firstname ) {
        this.firstname = firstname;
    }
}
