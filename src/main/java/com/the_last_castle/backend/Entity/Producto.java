package com.the_last_castle.backend.Entity;

import java.math.BigDecimal;
import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "Pr_Product")
public class Producto {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id_product", unique = true, nullable = false, columnDefinition = "BINARY(16)")
    private UUID idProduct;

    @ManyToOne
    @JoinColumn(name = "kind_of_product_id_product_type", nullable = false)
    private TipoDeProducto tipoDeProducto;

    @Column(name = "name_product", length = 30)
    private String nameProduct;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "Pr_Brand_has_Products", joinColumns = @JoinColumn(name = "Product_id_product"), inverseJoinColumns = @JoinColumn(name = "Brand_id_brand"))
    private Set<Marca> marca;

    @Column(name = "price", precision = 5, scale = 7)
    private BigDecimal price;

    @Column(name = "stock", length = 50)
    private String stock;

    @Column(name = "description", length = 500, nullable = false)
    private String description;

    @Column(name = "code_image", length = 50)
    private String codeImage;

    @Column(name = "status", length = 50)
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
