package com.the_last_castle.backend.Entity;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "Pr_Brand")
public class Marca {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id_brand", columnDefinition = "BINARY(16)")
    private UUID idBrand;

    @Column(name = "brand", length = 50)
    private String brand;

    @Column(name = "Description", length = 500)
    private String description;

    @Column(name = "code_image", length = 250)
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
