package com.the_last_castle.backend.DTO;

import java.util.UUID;

public class MarcaDTO {
    private UUID idBrand;
    private String brandName;
    private String description;
    private String codeImage;

    public MarcaDTO(String brandName, String description, String codeImage) {
        this.brandName = brandName;
        this.description = description;
        this.codeImage = codeImage;
    }

    public MarcaDTO(UUID idBrand, String brandName, String description, String codeImage) {
        this.idBrand = idBrand;
        this.brandName = brandName;
        this.description = description;
        this.codeImage = codeImage;
    }

    public MarcaDTO() {
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

    @Override
    public String toString() {
        return "MarcaDTO [idBrand=" + idBrand + ", brandName=" + brandName + ", description=" + description
                + ", codeImage=" + codeImage + "]";
    }

}
