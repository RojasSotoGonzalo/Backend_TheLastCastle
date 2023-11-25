package com.the_last_castle.backend.DTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ProductoDTO {
    private UUID idProduct;
    private CategoriaDTO category;
    private String name;
    private BigDecimal price;
    private Integer stock;
    private String description;
    private String codeImage;
    private List<MarcaDTO> brands;
    private List<TipoDeProductoDTO> kinds;

    public ProductoDTO(UUID idProduct, CategoriaDTO category, String name, BigDecimal price, Integer stock,
            String description, String codeImage, List<MarcaDTO> brands, List<TipoDeProductoDTO> kinds) {
        this.idProduct = idProduct;
        this.category = category;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.codeImage = codeImage;
        this.brands = brands;
        this.kinds = kinds;
    }

    public ProductoDTO(CategoriaDTO category, String name, BigDecimal price, Integer stock, String description,
            String codeImage, List<MarcaDTO> brands, List<TipoDeProductoDTO> kinds) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.codeImage = codeImage;
        this.brands = brands;
        this.kinds = kinds;
    }

    public ProductoDTO() {
    }

    public UUID getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(UUID idProduct) {
        this.idProduct = idProduct;
    }

    public CategoriaDTO getCategory() {
        return category;
    }

    public void setCategory(CategoriaDTO category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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

    public List<MarcaDTO> getBrands() {
        return brands;
    }

    public void setBrands(List<MarcaDTO> brands) {
        this.brands = brands;
    }

    public List<TipoDeProductoDTO> getKinds() {
        return kinds;
    }

    public void setKinds(List<TipoDeProductoDTO> kinds) {
        this.kinds = kinds;
    }

    @Override
    public String toString() {
        return "ProductoDTO [idProduct=" + idProduct + ", category=" + category + ", name=" + name + ", price=" + price
                + ", stock=" + stock + ", description=" + description + ", codeImage=" + codeImage + ", brands="
                + brands + ", kinds=" + kinds + "]";
    }
}
