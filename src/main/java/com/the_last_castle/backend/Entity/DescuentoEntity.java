package com.the_last_castle.backend.Entity;

import java.util.*;
import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Table(name = "Pr_Discount")
public class DescuentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_discount", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID idDiscount;

    @Column(name = "discount", precision = 3, scale = 2)
    private BigDecimal discount;

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

    public DescuentoEntity() {
    }

    public DescuentoEntity(BigDecimal discount, Integer status, String version, Date transactionDate,
            String transactionUser, String transactionHost) {
        this.discount = discount;
        this.status = status;
        this.version = version;
        this.transactionDate = transactionDate;
        this.transactionUser = transactionUser;
        this.transactionHost = transactionHost;
    }

    public DescuentoEntity(UUID idDiscount, BigDecimal discount, Integer status, String version, Date transactionDate,
            String transactionUser, String transactionHost) {
        this.idDiscount = idDiscount;
        this.discount = discount;
        this.status = status;
        this.version = version;
        this.transactionDate = transactionDate;
        this.transactionUser = transactionUser;
        this.transactionHost = transactionHost;
    }

    public UUID getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(UUID idDiscount) {
        this.idDiscount = idDiscount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
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
        return "DescuentoEntity [idDiscount=" + idDiscount + ", discount=" + discount + ", status=" + status
                + ", version=" + version + ", transactionDate=" + transactionDate + ", transactionUser="
                + transactionUser + ", transactionHost=" + transactionHost + "]";
    }

}
