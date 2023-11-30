package com.the_last_castle.backend.DTO;

import java.util.*;

public class PromocionDTO {
    private UUID idPromotion;
    private String namePromotion;
    private Date startDate;
    private Date endDate;

    public PromocionDTO(String namePromotion, Date startDate, Date endDate) {
        this.namePromotion = namePromotion;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public PromocionDTO(UUID idPromotion, String namePromotion, Date startDate, Date endDate) {
        this.idPromotion = idPromotion;
        this.namePromotion = namePromotion;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public PromocionDTO() {
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

    @Override
    public String toString() {
        return "PromocionDTO [idPromotion=" + idPromotion + ", namePromotion=" + namePromotion + ", startDate="
                + startDate + ", endDate=" + endDate + "]";
    }
}
