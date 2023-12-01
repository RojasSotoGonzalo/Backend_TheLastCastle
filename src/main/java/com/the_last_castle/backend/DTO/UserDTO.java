package com.the_last_castle.backend.DTO;

import java.util.Set;
import java.util.UUID;

public class UserDTO {
    private UUID idUser;
    private PersonaDTO persona;
    private Set<RolesDTO> roles;
    private String loginUser;
    private String passwordUser;
    private String email;

    public UserDTO(PersonaDTO persona, Set<RolesDTO> roles, String loginUser, String passwordUser, String email) {
        this.persona = persona;
        this.roles = roles;
        this.loginUser = loginUser;
        this.passwordUser = passwordUser;
        this.email = email;
    }

    public UserDTO(UUID idUser, PersonaDTO persona, Set<RolesDTO> roles, String loginUser, String passwordUser,
            String email) {
        this.idUser = idUser;
        this.persona = persona;
        this.roles = roles;
        this.loginUser = loginUser;
        this.passwordUser = passwordUser;
        this.email = email;
    }

    public UserDTO() {
    }

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public Set<RolesDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolesDTO> roles) {
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
        return "UserDTO [idUser=" + idUser + ", persona=" + persona + ", roles=" + roles + ", loginUser=" + loginUser
                + ", passwordUser=" + passwordUser + ", email=" + email + "]";
    }

}
