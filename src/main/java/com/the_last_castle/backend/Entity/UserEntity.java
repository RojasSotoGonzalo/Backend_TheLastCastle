package com.the_last_castle.backend.Entity;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "Use_user")

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID idUser;

    @ManyToOne(cascade = CascadeType.ALL) // Cambiado a ManyToOne con CascadeType.ALL
    @JoinColumn(name = "person_Id_person", referencedColumnName = "Id_person", nullable = false, unique = true)
    private PersonaEntity persona;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = RolesEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RolesEntity> roles;

    @Column(name = "login_user", length = 50)
    private String loginUser;

    @Column(name = "password_user", length = 50)
    private String passwordUser;

    @Column(name = "email", length = 50)
    private String email;

    public UserEntity(PersonaEntity persona, Set<RolesEntity> roles, String loginUser, String passwordUser,
            String email) {
        this.persona = persona;
        this.roles = roles;
        this.loginUser = loginUser;
        this.passwordUser = passwordUser;
        this.email = email;
    }

    public UserEntity(UUID idUser, PersonaEntity persona, Set<RolesEntity> roles, String loginUser, String passwordUser,
            String email) {
        this.idUser = idUser;
        this.persona = persona;
        this.roles = roles;
        this.loginUser = loginUser;
        this.passwordUser = passwordUser;
        this.email = email;
    }

    public UserEntity() {
    }

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public PersonaEntity getPersona() {
        return persona;
    }

    public void setPersona(PersonaEntity persona) {
        this.persona = persona;
    }

    public Set<RolesEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolesEntity> roles) {
        this.roles = roles;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserEntity [idUser=" + idUser + ", persona=" + persona + ", roles=" + roles + ", loginUser=" + loginUser
                + ", passwordUser=" + passwordUser + ", email=" + email + "]";
    }

}
