package com.the_last_castle.backend.Entity;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "Pr_Brand")
public class MarcaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_brand", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID idBrand;

    @Column(name = "brand_name", length = 50, unique = true)
    private String brandName;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "code_image", length = 500)
    private String codeImage;

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

    public MarcaEntity() {
    }

    public MarcaEntity(UUID idBrand, String brandName, String description, String codeImage, Integer status,
            String version, Date transactionDate, String transactionUser, String transactionHost) {
        this.idBrand = idBrand;
        this.brandName = brandName;
        this.description = description;
        this.codeImage = codeImage;
        this.status = status;
        this.version = version;
        this.transactionDate = transactionDate;
        this.transactionUser = transactionUser;
        this.transactionHost = transactionHost;
    }

    public MarcaEntity(String brandName, String description, String codeImage, Integer status, String version,
            Date transactionDate, String transactionUser, String transactionHost) {
        this.brandName = brandName;
        this.description = description;
        this.codeImage = codeImage;
        this.status = status;
        this.version = version;
        this.transactionDate = transactionDate;
        this.transactionUser = transactionUser;
        this.transactionHost = transactionHost;
    }

    public UUID getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(UUID idBrand) {
        this.idBrand = idBrand;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCodeImage() {
        return codeImage;
    }

    public void setCodeImage(String codeImage) {
        this.codeImage = codeImage;
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
        return "MarcaEntity [idBrand=" + idBrand + ", brandName=" + brandName + ", description=" + description
                + ", codeImage=" + codeImage + ", status=" + status + ", version=" + version + ", transactionDate="
                + transactionDate + ", transactionUser=" + transactionUser + ", transactionHost=" + transactionHost
                + "]";
    }
}
