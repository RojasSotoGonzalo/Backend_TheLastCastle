package com.the_last_castle.backend.DTO;

import java.util.UUID;

public class TipoDeProductoDTO {
    private UUID idProductOfKind;
    private String kindOfProduct;

    public TipoDeProductoDTO(String kindOfProduct) {
        this.kindOfProduct = kindOfProduct;
    }

    public TipoDeProductoDTO(UUID idProductOfKind, String kindOfProduct) {
        this.idProductOfKind = idProductOfKind;
        this.kindOfProduct = kindOfProduct;
    }

    public UUID getIdProductOfKind() {
        return idProductOfKind;
    }

    public void setIdProductOfKind(UUID idProductOfKind) {
        this.idProductOfKind = idProductOfKind;
    }

    public String getKindOfProduct() {
        return kindOfProduct;
    }

    public void setKindOfProduct(String kindOfProduct) {
        this.kindOfProduct = kindOfProduct;
    }

    @Override
    public String toString() {
        return "TipoDeProductoDTO [idProductOfKind=" + idProductOfKind + ", kindOfProduct=" + kindOfProduct + "]";
    }

}
