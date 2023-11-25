package com.the_last_castle.backend.Api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.the_last_castle.backend.DTO.ProductoDTO;
import com.the_last_castle.backend.Entity.ProductoEntity;
import com.the_last_castle.backend.Service.ProductoService;

@RestController
@RequestMapping("/api/v1/producto")
public class ProductoApi {
    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<ProductoEntity> createProducto(@RequestBody ProductoDTO productoDTO) {
        ProductoEntity createdProducto = productoService.createProducto(productoDTO);
        return new ResponseEntity<>(createdProducto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getAllProductos() {
        List<ProductoDTO> productos = productoService.getAllProductosDTO();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> getProductoById(@PathVariable UUID id) {
        Optional<ProductoDTO> producto = productoService.getProductoDTOById(id);
        return producto.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoEntity> updateProducto(@PathVariable UUID id,
            @RequestBody ProductoDTO updatedProductoDTO) {
        ProductoEntity updatedProducto = productoService.updateProducto(id, updatedProductoDTO);
        return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable UUID id) {
        productoService.deleteProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
