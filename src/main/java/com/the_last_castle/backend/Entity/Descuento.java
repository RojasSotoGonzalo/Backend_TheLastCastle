package com.the_last_castle.backend.Entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "Pr_Discount")
public class Descuento {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id_discount", unique = true, nullable = false)
    private UUID idDiscount;

    @Column(name = "discount", precision = 6, scale = 8)
    private BigDecimal discount;

    @Column(name = "status", length = 30)
    private String status;

    @Column(name = "version", length = 30)
    private String version;

    @Temporal(TemporalType.DATE)
    @Column(name = "tx_date")
    private Date txDate;

    @Column(name = "tx_user", length = 50)
    private String txUser;

    @Column(name = "tx_host", length = 50)
    private String txHost;
}
