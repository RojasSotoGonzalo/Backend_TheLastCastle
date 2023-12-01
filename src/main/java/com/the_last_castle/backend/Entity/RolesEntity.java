package com.the_last_castle.backend.Entity;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "Use_Roles")
public class RolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_roles", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID idRoles;

    @Column(name = "Roles", length = 50)
    private String roles;

    @Column(name = "status")
    private Integer status;

    @Column(name = "version", nullable = false, length = 50)
    private String version;

    @Column(name = "tx_date")
    @Temporal(TemporalType.DATE)
    private Date transactionDate;

    @Column(name = "tx_user", nullable = false, length = 50)
    private String transactionUser;

    @Column(name = "tx_host", nullable = false, length = 50)
    private String transactionHost;

    public RolesEntity() {
    }

    public RolesEntity(UUID idRoles, String roles, Integer status, String version, Date transactionDate,
            String transactionUser, String transactionHost) {
        this.idRoles = idRoles;
        this.roles = roles;
        this.status = status;
        this.version = version;
        this.transactionDate = transactionDate;
        this.transactionUser = transactionUser;
        this.transactionHost = transactionHost;
    }

    public RolesEntity(String roles, Integer status, String version, Date transactionDate, String transactionUser,
            String transactionHost) {
        this.roles = roles;
        this.status = status;
        this.version = version;
        this.transactionDate = transactionDate;
        this.transactionUser = transactionUser;
        this.transactionHost = transactionHost;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionUser() {
        return transactionUser;
    }

    public void setTransactionUser(String transactionUser) {
        this.transactionUser = transactionUser;
    }

    public String getTransactionHost() {
        return transactionHost;
    }

    public void setTransactionHost(String transactionHost) {
        this.transactionHost = transactionHost;
    }

    @Override
    public String toString() {
        return "RolesEntity [idRoles=" + idRoles + ", roles=" + roles + ", status=" + status + ", version=" + version
                + ", transactionDate=" + transactionDate + ", transactionUser=" + transactionUser + ", transactionHost="
                + transactionHost + "]";
    }
}
