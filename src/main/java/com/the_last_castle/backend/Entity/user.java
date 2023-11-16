package com.the_last_castle.backend.Entity;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "Use_user")
public class user {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id_user", unique = true, nullable = false, columnDefinition = "BINARY(16)")
    private UUID idUser;

    @OneToOne
    @JoinColumn(name = "person_Id_person", referencedColumnName = "Id_person", nullable = false, unique = true)
    private Persona persona;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Roles.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles;

    @Column(name = "login_user", length = 50)
    private String loginUser;

    @Column(name = "password_user", length = 50)
    private String passwordUser;

    @Column(name = "email", length = 50)
    private String email;
}
