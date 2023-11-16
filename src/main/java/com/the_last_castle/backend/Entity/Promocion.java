package com.the_last_castle.backend.Entity;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Pr_Promotion")
public class Promocion {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id_promotion", columnDefinition = "BINARY(16)")
    private UUID idPromotion;

    @Column(name = "Name_Promotion", length = 30)
    private String namePromotion;

    @Column(name = "Start_Date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "End_Date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "version", length = 30)
    private String version;

    @Column(name = "tx_date")
    @Temporal(TemporalType.DATE)
    private Date txDate;

    @Column(name = "tx_user", length = 50)
    private String txUser;

    @Column(name = "tx_host", length = 50)
    private String txHost;
}
