package com.the_last_castle.backend.Entity;

import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name = "Pr_kind_of_product")
public class TipoDeProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_product_of_kind", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID idProductOfKind;

    @Column(name = "kind_of_product", length = 50, unique = true)
    private String kindOfProduct;

    @Column(name = "status")
    private Integer status;

    @Column(name = "version", length = 50)
    private String version;

    @Column(name = "tx_date")
    @Temporal(TemporalType.DATE)
    private Date transactionDate;

    @Column(name = "tx_user", length = 50)
    private String transactionUser;

    @Column(name = "tx_host", length = 50)
    private String transactionHost;

    public TipoDeProductoEntity() {
    }

    public TipoDeProductoEntity(String kindOfProduct, Integer status, String version, Date transactionDate,
            String transactionUser, String transactionHost) {
        this.kindOfProduct = kindOfProduct;
        this.status = status;
        this.version = version;
        this.transactionDate = transactionDate;
        this.transactionUser = transactionUser;
        this.transactionHost = transactionHost;
    }

    public TipoDeProductoEntity(UUID idProductOfKind, String kindOfProduct, Integer status, String version,
            Date transactionDate, String transactionUser, String transactionHost) {
        this.idProductOfKind = idProductOfKind;
        this.kindOfProduct = kindOfProduct;
        this.status = status;
        this.version = version;
        this.transactionDate = transactionDate;
        this.transactionUser = transactionUser;
        this.transactionHost = transactionHost;
    }

    public UUID getIdProductOfKind() {
        return idProductOfKind;
    }

    public void setIdProductOfKind(UUID idProductOfKind) {
        this.idProductOfKind = idProductOfKind;
    }

    public String getKindOfProduct() {
        return kindOfProduct;
    }

    public void setKindOfProduct(String kindOfProduct) {
        this.kindOfProduct = kindOfProduct;
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
        return "TipoDeProductoEntity [idProductOfKind=" + idProductOfKind + ", kindOfProduct=" + kindOfProduct
                + ", status=" + status + ", version=" + version + ", transactionDate=" + transactionDate
                + ", transactionUser=" + transactionUser + ", transactionHost=" + transactionHost + "]";
    }

}
