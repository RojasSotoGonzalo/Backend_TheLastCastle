package com.the_last_castle.backend.Entity;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "Use_Roles")
public class Roles {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id_roles", unique = true, nullable = false, columnDefinition = "BINARY(16)")
    private UUID idRoles;

    @Column(name = "Roles", length = 50)
    private String roles;

    @Column(name = "Status", length = 50)
    private String status;

    @Column(name = "Version", length = 50)
    private String version;

    @Column(name = "tx_Date")
    @Temporal(TemporalType.DATE)
    private Date txDate;

    @Column(name = "tx_user", length = 50)
    private String txUser;

    @Column(name = "tx_host", length = 50)
    private String txHost;
}
