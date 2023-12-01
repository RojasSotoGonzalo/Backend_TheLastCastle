package com.the_last_castle.backend.DTO;

import java.util.UUID;

public class RolesDTO {
    private UUID idRoles;
    private String roles;

    public RolesDTO(UUID idRoles) {
        this.idRoles = idRoles;
    }

    public RolesDTO(String roles) {
        this.roles = roles;
    }

    public RolesDTO(UUID idRoles, String roles) {
        this.idRoles = idRoles;
        this.roles = roles;
    }

    public RolesDTO() {
    }

    public UUID getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(UUID idRoles) {
        this.idRoles = idRoles;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "RolesDTO [idRoles=" + idRoles + ", roles=" + roles + "]";
    }
}
