package com.the_last_castle.backend.Entity;

import java.math.BigDecimal;
import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "Pr_Product")
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_product", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID idProduct;

    @ManyToOne
    @JoinColumn(name = "pr_category_id_category", nullable = false, unique = true)
    private CategoriaEntity category;

    @Column(name = "name_product", length = 50)
    private String name;

    @Column(name = "price", precision = 20, scale = 5)
    private BigDecimal price;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "code_image", length = 500)
    private String codeImage;

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

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = MarcaEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "Pr_Brand_has_Products", joinColumns = @JoinColumn(name = "id_product"), inverseJoinColumns = @JoinColumn(name = "id_brand"))
    private List<MarcaEntity> brands;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = TipoDeProductoEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "Pr_Product_has_kindofproduct", joinColumns = @JoinColumn(name = "id_product"), inverseJoinColumns = @JoinColumn(name = "id_product_of_kind"))
    private List<TipoDeProductoEntity> kinds;

    public ProductoEntity(UUID idProduct, CategoriaEntity category, String name, BigDecimal price, Integer stock,
            String description, String codeImage, Integer status, String version, Date transactionDate,
            String transactionUser, String transactionHost, List<MarcaEntity> brands,
            List<TipoDeProductoEntity> kinds) {
        this.idProduct = idProduct;
        this.category = category;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.codeImage = codeImage;
        this.status = status;
        this.version = version;
        this.transactionDate = transactionDate;
        this.transactionUser = transactionUser;
        this.transactionHost = transactionHost;
        this.brands = brands;
        this.kinds = kinds;
    }

    public ProductoEntity(CategoriaEntity category, String name, BigDecimal price, Integer stock, String description,
            String codeImage, Integer status, String version, Date transactionDate, String transactionUser,
            String transactionHost, List<MarcaEntity> brands, List<TipoDeProductoEntity> kinds) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.codeImage = codeImage;
        this.status = status;
        this.version = version;
        this.transactionDate = transactionDate;
        this.transactionUser = transactionUser;
        this.transactionHost = transactionHost;
        this.brands = brands;
        this.kinds = kinds;
    }

    public ProductoEntity() {
    }

    public UUID getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(UUID idProduct) {
        this.idProduct = idProduct;
    }

    public CategoriaEntity getCategory() {
        return category;
    }

    public void setCategory(CategoriaEntity category) {
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

    public List<MarcaEntity> getBrands() {
        return brands;
    }

    public void setBrands(List<MarcaEntity> brands) {
        this.brands = brands;
    }

    public List<TipoDeProductoEntity> getKinds() {
        return kinds;
    }

    public void setKinds(List<TipoDeProductoEntity> kinds) {
        this.kinds = kinds;
    }

    @Override
    public String toString() {
        return "ProductoEntity [idProduct=" + idProduct + ", category=" + category + ", name=" + name + ", price="
                + price + ", stock=" + stock + ", description=" + description + ", codeImage=" + codeImage + ", status="
                + status + ", version=" + version + ", transactionDate=" + transactionDate + ", transactionUser="
                + transactionUser + ", transactionHost=" + transactionHost + ", brands=" + brands + ", kinds=" + kinds
                + "]";
    }
}
