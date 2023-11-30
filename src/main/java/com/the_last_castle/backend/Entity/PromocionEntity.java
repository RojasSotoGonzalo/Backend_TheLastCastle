package com.the_last_castle.backend.Entity;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "Pr_Promotion")
public class PromocionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_promotion", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID idPromotion;

    @Column(name = "Name_Promotion", length = 30, unique = true)
    private String namePromotion;

    @Column(name = "Start_Date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "End_Date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
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

    public PromocionEntity() {
    }

    public PromocionEntity(String namePromotion, Date startDate, Date endDate, Integer status, String version,
            Date transactionDate, String transactionUser, String transactionHost) {
        this.namePromotion = namePromotion;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.version = version;
        this.transactionDate = transactionDate;
        this.transactionUser = transactionUser;
        this.transactionHost = transactionHost;
    }

    public PromocionEntity(UUID idPromotion, String namePromotion, Date startDate, Date endDate, Integer status,
            String version, Date transactionDate, String transactionUser, String transactionHost) {
        this.idPromotion = idPromotion;
        this.namePromotion = namePromotion;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.version = version;
        this.transactionDate = transactionDate;
        this.transactionUser = transactionUser;
        this.transactionHost = transactionHost;
    }

    public UUID getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(UUID idPromotion) {
        this.idPromotion = idPromotion;
    }

    public String getNamePromotion() {
        return namePromotion;
    }

    public void setNamePromotion(String namePromotion) {
        this.namePromotion = namePromotion;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
        return "PromcionesEntity [idPromotion=" + idPromotion + ", namePromotion=" + namePromotion + ", startDate="
                + startDate + ", endDate=" + endDate + ", status=" + status + ", version=" + version
                + ", transactionDate=" + transactionDate + ", transactionUser=" + transactionUser + ", transactionHost="
                + transactionHost + "]";
    }
}
