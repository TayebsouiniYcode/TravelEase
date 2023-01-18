package com.youcode.travelease.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.travelease.util.ResponseMessage;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "firstname", length = 50)
    private String firstname;

    @Column(name = "lastname", length = 50)
    private String lastname;

    @Column(name = "email", unique = true, length = 100)
    private String email;

    @Column(name = "username", unique = true, length = 50)
    private String username;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "phone", length = 30)
    private String phone;

    @ManyToMany(cascade = {CascadeType.PERSIST , CascadeType.MERGE},fetch = EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set < Role > roles = new LinkedHashSet <> ( );

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set < Reservation > reservations = new LinkedHashSet <> ( );

    @Transient
    private ResponseMessage message;

    public ResponseMessage getMessage ( ) {
        return message;
    }

    public void setMessage ( ResponseMessage message ) {
        this.message = message;
    }

    public Set < Reservation > getReservations ( ) {
        return reservations;
    }

    public void setReservations ( Set < Reservation > reservations ) {
        this.reservations = reservations;
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

    public void changeRole ( Role role ) {
        this.roles.clear ();
        this.roles.add ( role );
    }

//    @ManyToMany
//    @JoinTable(name = "user_authorities",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "authorities_id"))
//    private Set < Authority > authorities = new LinkedHashSet <> ( );


}
