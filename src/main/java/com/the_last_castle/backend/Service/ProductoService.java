package com.the_last_castle.backend.Service;

import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the_last_castle.backend.DTO.CategoriaDTO;
import com.the_last_castle.backend.DTO.MarcaDTO;
import com.the_last_castle.backend.DTO.ProductoDTO;
import com.the_last_castle.backend.DTO.TipoDeProductoDTO;
import com.the_last_castle.backend.Entity.CategoriaEntity;
import com.the_last_castle.backend.Entity.MarcaEntity;
import com.the_last_castle.backend.Entity.ProductoEntity;
import com.the_last_castle.backend.Entity.TipoDeProductoEntity;
import com.the_last_castle.backend.Repository.CategoriaRespository;
import com.the_last_castle.backend.Repository.MarcaRepository;
import com.the_last_castle.backend.Repository.ProductoRespository;
import com.the_last_castle.backend.Repository.TipoDeProductoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductoService {
    @Autowired
    private ProductoRespository productoRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private CategoriaRespository categoriaRepository;

    @Autowired
    TipoDeProductoRepository TipoDeProductoRepository;

    public ProductoEntity createProducto(ProductoDTO productoDTO) {
        // Fetch entities from repositories based on UUIDs
        CategoriaEntity categoriaEntity = categoriaRepository.findById(productoDTO.getCategory().getIdCategory())
                .orElseThrow(() -> new EntityNotFoundException("Categoria not found"));
        List<MarcaEntity> marcas = fetchMarcaEntities(productoDTO.getBrands());
        List<TipoDeProductoEntity> tipos = fetchTipoDeProductoEntities(productoDTO.getKinds());

        ProductoEntity newProducto = new ProductoEntity(
                categoriaEntity,
                productoDTO.getName(),
                productoDTO.getPrice(),
                productoDTO.getStock(),
                productoDTO.getDescription(),
                productoDTO.getCodeImage(),
                1,
                "1.0",
                new Date(), // Set the current date as the transaction date
                "user", // Set the transaction user (replace with actual user)
                "host", // Set the transaction host (replace with actual host)
                marcas,
                tipos);

        // Save the new product
        return productoRepository.save(newProducto);
    }

    private List<MarcaEntity> fetchMarcaEntities(List<MarcaDTO> list) {
        return list.stream()
                .map(marcaDTO -> marcaRepository.findById(marcaDTO.getIdBrand())
                        .orElseThrow(() -> new EntityNotFoundException("Marca not found")))
                .collect(Collectors.toList());
    }

    private List<TipoDeProductoEntity> fetchTipoDeProductoEntities(List<TipoDeProductoDTO> list) {
        return list.stream()
                .map(tipoDTO -> TipoDeProductoRepository.findById(tipoDTO.getIdProductOfKind())
                        .orElseThrow(() -> new EntityNotFoundException("TipoDeProducto not found")))
                .collect(Collectors.toList());
    }

    public void deleteProducto(UUID productId) {
        productoRepository.deleteById(productId);
    }

    public ProductoEntity updateProducto(UUID productId, ProductoDTO updatedProductoDTO) {
        ProductoEntity existingProducto = productoRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Producto not found"));

        CategoriaEntity categoriaEntity = categoriaRepository.findById(updatedProductoDTO.getCategory().getIdCategory())
                .orElseThrow(() -> new EntityNotFoundException("Categoria not found"));
        List<MarcaEntity> updatedMarcas = fetchMarcaEntities(updatedProductoDTO.getBrands());
        List<TipoDeProductoEntity> updatedTipos = fetchTipoDeProductoEntities(updatedProductoDTO.getKinds());

        // Update fields
        existingProducto.setCategory(categoriaEntity);
        existingProducto.setName(updatedProductoDTO.getName());
        existingProducto.setPrice(updatedProductoDTO.getPrice());
        existingProducto.setStock(updatedProductoDTO.getStock());
        existingProducto.setDescription(updatedProductoDTO.getDescription());
        existingProducto.setCodeImage(updatedProductoDTO.getCodeImage());
        existingProducto.setTransactionDate(new Date());
        existingProducto.setTransactionUser("user"); // Replace with actual user
        existingProducto.setTransactionHost("host"); // Replace with actual host
        existingProducto.setBrands(updatedMarcas);
        existingProducto.setKinds(updatedTipos);

        return productoRepository.save(existingProducto);
    }

    public List<ProductoDTO> getAllProductosDTO() {
        List<ProductoEntity> productoEntities = productoRepository.findAll();
        return convertirProductosEntidadesADTO(productoEntities);

    }

    public Optional<ProductoDTO> getProductoDTOById(UUID id) {
        Optional<ProductoEntity> productoEntity = productoRepository.findById(id);
        return productoEntity.map(this::convertirProductoEntidadADTO);
    }

    private List<ProductoDTO> convertirProductosEntidadesADTO(List<ProductoEntity> entidades) {
        return entidades.stream()
                .map(this::convertirProductoEntidadADTO)
                .collect(Collectors.toList());
    }

    private ProductoDTO convertirProductoEntidadADTO(ProductoEntity entidad) {
        // Implement conversion logic from ProductoEntity to ProductoDTO

        return new ProductoDTO(
                entidad.getIdProduct(),
                convertirCategoriaEntidadADTO(entidad.getCategory()),
                entidad.getName(),
                entidad.getPrice(),
                entidad.getStock(),
                entidad.getDescription(),
                entidad.getCodeImage(),
                convertirMarcasEntidadesADTO(entidad.getBrands()),
                convertirTiposEntidadesADTO(entidad.getKinds()));
    }

    private CategoriaDTO convertirCategoriaEntidadADTO(CategoriaEntity entidad) {
        // Implement conversion logic from CategoriaEntity to CategoriaDTO
        // Example:
        return new CategoriaDTO(entidad.getIdCategory(), entidad.getCategory());
    }

    private List<MarcaDTO> convertirMarcasEntidadesADTO(List<MarcaEntity> entidades) {
        return entidades.stream()
                .map(this::convertirMarcaEntidadADTO)
                .collect(Collectors.toList());
    }

    private MarcaDTO convertirMarcaEntidadADTO(MarcaEntity entidad) {
        // Implement conversion logic from MarcaEntity to MarcaDTO
        // Example:
        return new MarcaDTO(entidad.getIdBrand(), entidad.getBrandName(), entidad.getDescription(),
                entidad.getCodeImage());
    }

    private List<TipoDeProductoDTO> convertirTiposEntidadesADTO(List<TipoDeProductoEntity> entidades) {
        return entidades.stream()
                .map(this::convertirTipoEntidadADTO)
                .collect(Collectors.toList());
    }

    private TipoDeProductoDTO convertirTipoEntidadADTO(TipoDeProductoEntity entidad) {
        // Implement conversion logic from TipoDeProductoEntity to TipoDeProductoDTO
        // Example:
        return new TipoDeProductoDTO(entidad.getIdProductOfKind(), entidad.getKindOfProduct());
    }
}
