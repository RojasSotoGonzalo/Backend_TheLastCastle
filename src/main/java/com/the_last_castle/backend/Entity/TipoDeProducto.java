package com.the_last_castle.backend.Entity;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "Pr_kind_of_product")
public class TipoDeProducto {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id_product_type", unique = true, nullable = false, columnDefinition = "BINARY(16)")
    private UUID idProductType;

    @Column(name = "kind_of_product", length = 30)
    private String kindOfProduct;

    @Column(name = "status", length = 30)
    private String status;

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
