package com.the_last_castle.backend.Entity;

import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name = "Pr_Category")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_category", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID idCategory;

    @Column(name = "category", length = 50, unique = true)
    private String category;

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

    public CategoriaEntity() {
    }

    public CategoriaEntity(String category, Integer status, String version, Date transactionDate,
            String transactionUser, String transactionHost) {
        this.category = category;
        this.status = status;
        this.version = version;
        this.transactionDate = transactionDate;
        this.transactionUser = transactionUser;
        this.transactionHost = transactionHost;
    }

    public CategoriaEntity(UUID idCategory, String category, Integer status, String version, Date transactionDate,
            String transactionUser, String transactionHost) {
        this.idCategory = idCategory;
        this.category = category;
        this.status = status;
        this.version = version;
        this.transactionDate = transactionDate;
        this.transactionUser = transactionUser;
        this.transactionHost = transactionHost;
    }

    public UUID getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(UUID idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
        return "CategoriaEntity [idCategory=" + idCategory + ", category=" + category + ", status=" + status
                + ", version=" + version + ", transactionDate=" + transactionDate + ", transactionUser="
                + transactionUser + ", transactionHost=" + transactionHost + "]";
    }

}
