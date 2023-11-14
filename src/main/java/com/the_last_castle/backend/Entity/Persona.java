package com.the_last_castle.backend.Entity;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "Use_person")
public class Persona {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "Id_person", unique = true, nullable = false)
    private UUID id;
    @Column(name = "people_name", unique = true, nullable = false)
    private String peopleName;

    @Column(name = "surnames", unique = true, nullable = false)
    private String surnames;

    @Column(name = "carnet", unique = true, nullable = false)
    private String carnet;

    @Column(name = "phone", unique = true, nullable = false)
    private String phone;

    @Column(name = "address", unique = true, nullable = false)
    private String address;
}
