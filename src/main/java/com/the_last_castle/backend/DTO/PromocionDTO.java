package com.the_last_castle.backend.DTO;

import java.util.Date;
import java.util.UUID;

public class PromocionDTO {
    private UUID idPromotion;
    private String namePromotion;
    private Date startDate;
    private Date endDate;
    private Boolean status;
    private String version;
    private Date txDate;
    private String txUser;
    private String txHost;

    public PromocionDTO(String namePromotion, Date startDate, Date endDate, Boolean status, String version, Date txDate,
            String txUser, String txHost) {
        this.namePromotion = namePromotion;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.version = version;
        this.txDate = txDate;
        this.txUser = txUser;
        this.txHost = txHost;
    }

    public PromocionDTO(UUID idPromotion, String namePromotion, Date startDate, Date endDate) {
        this.idPromotion = idPromotion;
        this.namePromotion = namePromotion;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    public String getTxUser() {
        return txUser;
    }

    public void setTxUser(String txUser) {
        this.txUser = txUser;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    @Override
    public String toString() {
        return "PromocionDTO [idPromotion=" + idPromotion + ", namePromotion=" + namePromotion + ", startDate="
                + startDate + ", endDate=" + endDate + ", status=" + status + ", version=" + version + ", txDate="
                + txDate + ", txUser=" + txUser + ", txHost=" + txHost + "]";
    }
}
