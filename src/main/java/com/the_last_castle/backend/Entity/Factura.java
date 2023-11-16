package com.the_last_castle.backend.Entity;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "Ve_bill")
public class Factura {
    @Id
    @Column(name = "Ve_Sale_id_Sale", unique = true, nullable = false, columnDefinition = "BINARY(16)")
    private UUID veSaleIdSale;

    @Column(name = "Description", length = 500)
    private String description;

    @OneToOne
    @JoinColumn(name = "Ve_Sale_id_Sale", referencedColumnName = "id_Sale", nullable = false, insertable = false, updatable = false)
    private venta sale;
}
