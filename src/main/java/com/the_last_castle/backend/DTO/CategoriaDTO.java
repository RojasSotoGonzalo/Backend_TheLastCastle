package com.TheLastCastle.Producto.Dto;

import java.util.UUID;

public class CategoriaDTO {
    private UUID idCategory;
    private String category;

    public CategoriaDTO(String category) {
        this.category = category;
    }

    public CategoriaDTO(UUID idCategory, String category) {
        this.idCategory = idCategory;
        this.category = category;
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

    @Override
    public String toString() {
        return "CategoriaDTO [idCategory=" + idCategory + ", category=" + category + "]";
    }

}
