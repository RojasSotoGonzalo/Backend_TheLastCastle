package com.the_last_castle.backend.DTO;

import java.util.*;
import java.math.BigDecimal;

public class DescuentoDTO {
    private UUID idDiscount;
    private BigDecimal discount;

    public DescuentoDTO(BigDecimal discount) {
        this.discount = discount;
    }

    public DescuentoDTO(UUID idDiscount) {
        this.idDiscount = idDiscount;
    }

    public DescuentoDTO(UUID idDiscount, BigDecimal discount) {
        this.idDiscount = idDiscount;
        this.discount = discount;
    }

    public DescuentoDTO() {
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

    @Override
    public String toString() {
        return "DescuentoDTO [idDiscount=" + idDiscount + ", discount=" + discount + "]";
    }
}
