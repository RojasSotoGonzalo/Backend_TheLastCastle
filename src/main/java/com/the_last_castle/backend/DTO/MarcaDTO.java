package com.the_last_castle.backend.DTO;

import java.util.Date;
import java.util.UUID;

public class MarcaDTO {
    private UUID idBrand;
    private String brand;
    private String description;
    private String codeImage;
    private String status;
    private String version;
    private Date txDate;
    private String txUser;
    private String txHost;

    public MarcaDTO(UUID idBrand, String brand, String description, String codeImage) {
        this.idBrand = idBrand;
        this.brand = brand;
        this.description = description;
        this.codeImage = codeImage;
    }

    public MarcaDTO(UUID idBrand, String brand, String description, String codeImage, String status, String version,
            Date txDate, String txUser, String txHost) {
        this.idBrand = idBrand;
        this.brand = brand;
        this.description = description;
        this.codeImage = codeImage;
        this.status = status;
        this.version = version;
        this.txDate = txDate;
        this.txUser = txUser;
        this.txHost = txHost;
    }

    public UUID getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(UUID idBrand) {
        this.idBrand = idBrand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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
        return "MarcaDTO [idBrand=" + idBrand + ", brand=" + brand + ", description=" + description + ", codeImage="
                + codeImage + ", status=" + status + ", version=" + version + ", txDate=" + txDate + ", txUser="
                + txUser + ", txHost=" + txHost + "]";
    }

}
