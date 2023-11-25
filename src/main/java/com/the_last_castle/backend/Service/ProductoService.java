package com.the_last_castle.backend.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the_last_castle.backend.DTO.ProductoDTO;
import com.the_last_castle.backend.Entity.ProductoEntity;
import com.the_last_castle.backend.Repository.ProductoRespository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRespository productoRepository;

    public ProductoService(ProductoRespository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoDTO> getAllProductosDTO() {
        List<ProductoEntity> productoEntities = productoRepository.findAll();
        return convertirEntidadesADTO(productoEntities);
    }

    public Optional<ProductoDTO> getProductoDTOById(UUID id) {
        Optional<ProductoEntity> productoEntity = productoRepository.findById(id);
        return productoEntity.map(this::convertirEntidadADTO);
    }

    public ProductoDTO createProducto(ProductoDTO productoDTO) {
        ProductoEntity producto = new ProductoEntity();
        BeanUtils.copyProperties(productoDTO, producto);
        // Asignar la fecha y otros campos de auditoría si es necesario
        producto.setStatus(1);
        producto.setVersion("1.0");
        producto.setTransactionDate(new Date());
        producto.setTransactionUser("system");
        producto.setTransactionHost("localhost");

        ProductoEntity nuevoProducto = productoRepository.save(producto);

        ProductoDTO nuevoProductoDTO = new ProductoDTO();
        BeanUtils.copyProperties(nuevoProducto, nuevoProductoDTO);

        return nuevoProductoDTO;
    }

    public ProductoDTO updateProducto(UUID id, ProductoDTO productoDTO) {
        if (productoRepository.existsById(id)) {
            ProductoEntity producto = new ProductoEntity();
            BeanUtils.copyProperties(productoDTO, producto);
            // Asignar la fecha y otros campos de auditoría si es necesario
            producto.setStatus(1);
            producto.setVersion("1.0");
            producto.setTransactionDate(new Date());
            producto.setTransactionUser("system");
            producto.setTransactionHost("localhost");
            producto.setIdProduct(id);

            ProductoEntity productoActualizado = productoRepository.save(producto);

            ProductoDTO productoActualizadoDTO = new ProductoDTO();
            BeanUtils.copyProperties(productoActualizado, productoActualizadoDTO);

            return productoActualizadoDTO;
        }
        return null;
    }

    public void deleteProducto(UUID id) {
        productoRepository.deleteById(id);
    }

    private List<ProductoDTO> convertirEntidadesADTO(List<ProductoEntity> entidades) {
        return entidades.stream()
                .map(this::convertirEntidadADTO)
                .collect(Collectors.toList());
    }

    private ProductoDTO convertirEntidadADTO(ProductoEntity entidad) {
        ProductoDTO productoDTO = new ProductoDTO();
        BeanUtils.copyProperties(entidad, productoDTO);
        return productoDTO;
    }
}
