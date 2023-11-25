package com.the_last_castle.backend.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.the_last_castle.backend.DTO.MarcaDTO;
import com.the_last_castle.backend.Entity.MarcaEntity;
import com.the_last_castle.backend.Repository.MarcaRepository;

@Service
public class MarcaService {
    @Autowired
    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public List<MarcaDTO> getAllMarcasDTO() {
        List<MarcaEntity> marcaEntities = marcaRepository.findAll();
        return convertirEntidadesADTO(marcaEntities);
    }

    public Optional<MarcaDTO> getMarcaDTOById(UUID id) {
        Optional<MarcaEntity> marcaEntity = marcaRepository.findById(id);
        return marcaEntity.map(this::convertirEntidadADTO);
    }

    private List<MarcaDTO> convertirEntidadesADTO(List<MarcaEntity> entidades) {
        return entidades.stream()
                .map(this::convertirEntidadADTO)
                .collect(Collectors.toList());
    }

    private MarcaDTO convertirEntidadADTO(MarcaEntity entidad) {
        return new MarcaDTO(entidad.getIdBrand(), entidad.getBrandName(), entidad.getDescription(),
                entidad.getCodeImage());
    }

    public MarcaEntity createMarca(MarcaDTO marcaDTO) {
        MarcaEntity marca = new MarcaEntity();
        marca.setBrandName(marcaDTO.getBrandName());
        marca.setDescription(marcaDTO.getDescription());
        marca.setCodeImage(marcaDTO.getCodeImage());
        marca.setStatus(1);
        marca.setVersion("1.0");
        marca.setTransactionDate(new Date());
        marca.setTransactionUser("system");
        marca.setTransactionHost("localhost");
        return marcaRepository.save(marca);
    }

    public MarcaEntity updateMarca(UUID id, MarcaDTO marcaDTO) {
        if (marcaRepository.existsById(id)) {
            MarcaEntity marca = new MarcaEntity();
            marca.setIdBrand(id);
            marca.setBrandName(marcaDTO.getBrandName());
            marca.setDescription(marcaDTO.getDescription());
            marca.setCodeImage(marcaDTO.getCodeImage());
            marca.setStatus(1);
            marca.setVersion("1.0");
            marca.setTransactionDate(new Date());
            marca.setTransactionUser("system");
            marca.setTransactionHost("localhost");

            return marcaRepository.save(marca);
        }
        return null;
    }

    public void deleteMarca(UUID id) {
        marcaRepository.deleteById(id);
    }
}
