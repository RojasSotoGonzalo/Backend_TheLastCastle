package com.the_last_castle.backend.Entity;

import java.math.BigDecimal;
import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "Ve_Sale")
public class venta {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id_Sale", unique = true, nullable = false, columnDefinition = "BINARY(16)")
    private UUID idSale;

    @ManyToOne
    @JoinColumn(name = "Use_user_id_user", nullable = false)
    private user user;
    /*
     * @ManyToOne
     * 
     * @JoinColumn(name = "Product_id_product", nullable = false)
     * private Producto product;
     */
    @Column(name = "Sale_price", precision = 5, scale = 7)
    private BigDecimal salePrice;

    @Column(name = "amount_Sale")
    private int amountSale;

    @Column(name = "Status", length = 50)
    private String status;

    @Column(name = "Version", length = 50)
    private String version;

    @Column(name = "tx_date")
    @Temporal(TemporalType.DATE)
    private Date txDate;

    @Column(name = "tx_user", length = 50)
    private String txUser;

    @Column(name = "tx_host", length = 50, nullable = false)
    private String txHost;
}
