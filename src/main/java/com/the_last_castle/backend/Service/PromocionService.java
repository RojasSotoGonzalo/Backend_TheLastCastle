package com.the_last_castle.backend.Service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the_last_castle.backend.DTO.PromocionDTO;
import com.the_last_castle.backend.Entity.PromocionEntity;
import com.the_last_castle.backend.Repository.PromocionRepository;

@Service
public class PromocionService {
    @Autowired
    private PromocionRepository promocionRepository;
    // Método para obtener todas las Promociones en forma DTO

    public List<PromocionDTO> getAllPromocionesDTO() {
        List<PromocionEntity> promocionEntities = promocionRepository.findAll();
        return convertirEntidadADTO(promocionEntities);
    }

    // Método para obtener una Promoción por ID en formato DTO
    public Optional<PromocionDTO> getPromocionDTOById(UUID id) {
        Optional<PromocionEntity> promocionEntity = promocionRepository.findById(id);
        return promocionEntity.map(this::convertirEntidadADTO);
    }

    // Método para convertir una lista de entidades a DTO
    private List<PromocionDTO> convertirEntidadADTO(List<PromocionEntity> entidades) {
        return entidades.stream().map(this::convertirEntidadADTO)
                .collect(Collectors.toList());
    }

    // Método para convertir una entidad a DTO
    private PromocionDTO convertirEntidadADTO(PromocionEntity entidad) {
        return new PromocionDTO(entidad.getIdPromotion(), entidad.getNamePromotion(),
                entidad.getStartDate(), entidad.getEndDate());
    }

    // Método para crear una nueva Promoción
    public PromocionEntity createPromocion(PromocionDTO promocionDTO) {
        PromocionEntity promocion = new PromocionEntity();
        promocion.setNamePromotion(promocionDTO.getNamePromotion());
        promocion.setStartDate(promocionDTO.getStartDate());
        promocion.setEndDate(promocionDTO.getEndDate());
        promocion.setStatus(1);
        promocion.setVersion("1.0");
        promocion.setTransactionDate(new Date());
        promocion.setTransactionHost("System");
        promocion.setTransactionUser("localhost");
        return promocionRepository.save(promocion);
    }

    // Método para actualizar una Promoción existente
    public PromocionEntity updatePromocionEntity(UUID id, PromocionDTO promocionDTO) {
        if (promocionRepository.existsById(id)) {
            PromocionEntity promocion = new PromocionEntity();
            promocion.setIdPromotion(id);
            promocion.setNamePromotion(promocionDTO.getNamePromotion());
            promocion.setStartDate(promocionDTO.getStartDate());
            promocion.setEndDate(promocionDTO.getEndDate());
            promocion.setStatus(1);
            promocion.setVersion("1.0");
            promocion.setTransactionDate(new Date());
            promocion.setTransactionHost("System");
            promocion.setTransactionUser("localhost");
            return promocionRepository.save(promocion);
        } else {
            return null;
        }
    }

    // Método para eliminar una Promoción por ID
    public void deletePromocion(UUID id) {
        promocionRepository.deleteById(id);
    }
}
