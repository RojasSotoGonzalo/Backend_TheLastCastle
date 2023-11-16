package com.the_last_castle.backend.DTO;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.Date;

public class DescuentoDTO {
    private UUID idDiscount;
    private BigDecimal discount;
    private String status;
    private String version;
    private Date txDate;
    private String txUser;
    private String txHost;

    public DescuentoDTO(UUID idDiscount, BigDecimal discount, String status, String version, Date txDate, String txUser,
            String txHost) {
        this.idDiscount = idDiscount;
        this.discount = discount;
        this.status = status;
        this.version = version;
        this.txDate = txDate;
        this.txUser = txUser;
        this.txHost = txHost;
    }

    public DescuentoDTO(BigDecimal discount, String status, String version, Date txDate, String txUser, String txHost) {
        this.discount = discount;
        this.status = status;
        this.version = version;
        this.txDate = txDate;
        this.txUser = txUser;
        this.txHost = txHost;
    }

    public DescuentoDTO(UUID idDiscount, BigDecimal discount) {
        this.idDiscount = idDiscount;
        this.discount = discount;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
        return "DescuentoDTO [idDiscount=" + idDiscount + ", discount=" + discount + ", status=" + status + ", version="
                + version + ", txDate=" + txDate + ", txUser=" + txUser + ", txHost=" + txHost + "]";
    }

}
