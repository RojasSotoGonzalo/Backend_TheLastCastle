package com.the_last_castle.backend.Service;

import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the_last_castle.backend.DTO.DescuentoDTO;
import com.the_last_castle.backend.Entity.DescuentoEntity;
import com.the_last_castle.backend.Repository.DescuentoRepository;

@Service
public class DescuentoService {
    @Autowired
    private DescuentoRepository descuentoRepository;

    // Método para obtener los Descuento en forma DTO
    public List<DescuentoDTO> getAllCategoriasDTO() {
        List<DescuentoEntity> descuentoEntities = descuentoRepository.findAll();
        return convertirEntidadADTO(descuentoEntities);
    }

    // Método para obtener un Descuento por ID en formato DTO
    public Optional<DescuentoDTO> getDescuentoDTOById(UUID id) {
        Optional<DescuentoEntity> descuentoEntity = descuentoRepository.findById(id);
        return descuentoEntity.map(this::convertirEntidadADTO);
    }

    // Método para convertir una lista de entidades a DTO
    private List<DescuentoDTO> convertirEntidadADTO(List<DescuentoEntity> entidades) {
        return entidades.stream().map(this::convertirEntidadADTO)
                .collect(Collectors.toList());
    }

    // Método para convetir una entidad a DTO
    private DescuentoDTO convertirEntidadADTO(DescuentoEntity entidad) {
        return new DescuentoDTO(entidad.getIdDiscount(), entidad.getDiscount());
    }

    // Método para crear un nuevo Descuento
    public DescuentoEntity createDescuento(DescuentoDTO descuentoDTO) {
        System.err.println(descuentoDTO.getDiscount());
        DescuentoEntity descuento = new DescuentoEntity();
        descuento.setDiscount(descuentoDTO.getDiscount());
        descuento.setStatus(1);
        descuento.setVersion("1.0");
        descuento.setTransactionDate(new Date());
        descuento.setTransactionHost("System");
        descuento.setTransactionUser("localhost");
        return descuentoRepository.save(descuento);
    }

    // Método para actualizar un Descuento exitente
    public DescuentoEntity upDescuentoEntity(UUID id, DescuentoDTO descuentoDTO) {
        if (descuentoRepository.existsById(id)) {
            DescuentoEntity descuento = new DescuentoEntity();
            descuento.setIdDiscount(id);
            descuento.setDiscount(descuentoDTO.getDiscount());
            descuento.setStatus(1);
            descuento.setVersion("1.0");
            descuento.setTransactionDate(new Date());
            descuento.setTransactionHost("System");
            descuento.setTransactionUser("localhost");
            return descuentoRepository.save(descuento);
        } else {
            return null;
        }
    }

    // Método para eliminar un Descuento por ID
    public void deleteDescuento(UUID id) {
        descuentoRepository.deleteById(id);
    }
}
