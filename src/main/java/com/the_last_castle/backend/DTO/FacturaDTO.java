package com.the_last_castle.backend.DTO;

import java.util.UUID;

public class FacturaDTO {
    private UUID veSaleIdSale;
    private String description;
    private VentaDTO sale;

    public FacturaDTO(String description, VentaDTO sale) {
        this.description = description;
        this.sale = sale;
    }

    public FacturaDTO(UUID veSaleIdSale, String description, VentaDTO sale) {
        this.veSaleIdSale = veSaleIdSale;
        this.description = description;
        this.sale = sale;
    }

    public UUID getVeSaleIdSale() {
        return veSaleIdSale;
    }

    public void setVeSaleIdSale(UUID veSaleIdSale) {
        this.veSaleIdSale = veSaleIdSale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VentaDTO getSale() {
        return sale;
    }

    public void setSale(VentaDTO sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "FacturaDTO [veSaleIdSale=" + veSaleIdSale + ", description=" + description + ", sale=" + sale + "]";
    }
}
