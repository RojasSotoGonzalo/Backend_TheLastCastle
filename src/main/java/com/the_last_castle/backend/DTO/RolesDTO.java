package com.the_last_castle.backend.DTO;

import java.util.Date;
import java.util.UUID;

public class RolesDTO {
    private UUID idRoles;
    private String roles;
    private String status;
    private String version;
    private Date txDate;
    private String txUser;
    private String txHost;

    public RolesDTO(UUID idRoles, String roles, String status, String version, Date txDate, String txUser,
            String txHost) {
        this.idRoles = idRoles;
        this.roles = roles;
        this.status = status;
        this.version = version;
        this.txDate = txDate;
        this.txUser = txUser;
        this.txHost = txHost;
    }

    public RolesDTO(UUID idRoles, String roles) {
        this.idRoles = idRoles;
        this.roles = roles;
    }

    public UUID getIdRoles() {
        return idRoles;
    }

    public String getRoles() {
        return roles;
    }

    public String getStatus() {
        return status;
    }

    public String getVersion() {
        return version;
    }

    public Date getTxDate() {
        return txDate;
    }

    public String getTxUser() {
        return txUser;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setIdRoles(UUID idRoles) {
        this.idRoles = idRoles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    public void setTxUser(String txUser) {
        this.txUser = txUser;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    @Override
    public String toString() {
        return "RolesDTO [idRoles=" + idRoles + ", roles=" + roles + ", status=" + status + ", version=" + version
                + ", txDate=" + txDate + ", txUser=" + txUser + ", txHost=" + txHost + "]";
    }

}
