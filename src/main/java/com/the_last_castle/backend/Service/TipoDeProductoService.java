package com.the_last_castle.backend.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the_last_castle.backend.DTO.TipoDeProductoDTO;
import com.the_last_castle.backend.Entity.TipoDeProductoEntity;
import com.the_last_castle.backend.Repository.TipoDeProductoRepository;

@Service
public class TipoDeProductoService {
    @Autowired
    TipoDeProductoRepository TipoDeProductoRepository;

    // Método para obtener todos los tipos de productos en formato DTO
    public List<TipoDeProductoDTO> getAllTiposDeProductosDTO() {
        List<TipoDeProductoEntity> tipoDeProductoEntities = TipoDeProductoRepository.findAll();
        return convertirEntidadesADTO(tipoDeProductoEntities);
    }

    // Método para obtener un tipo de producto por ID en formato DTO
    public Optional<TipoDeProductoDTO> getTipoDeProductoDTOById(UUID id) {
        Optional<TipoDeProductoEntity> tipoDeProductoEntity = TipoDeProductoRepository.findById(id);
        return tipoDeProductoEntity.map(this::convertirEntidadADTO);
    }

    // Método para convertir una lista de entidades a DTO
    private List<TipoDeProductoDTO> convertirEntidadesADTO(List<TipoDeProductoEntity> entidades) {
        return entidades.stream()
                .map(this::convertirEntidadADTO)
                .collect(Collectors.toList());
    }

    // Método para convertir una entidad a DTO
    private TipoDeProductoDTO convertirEntidadADTO(TipoDeProductoEntity entidad) {
        return new TipoDeProductoDTO(entidad.getIdProductOfKind(), entidad.getKindOfProduct());
    }

    // Método para crear un nuevo tipo de producto
    public TipoDeProductoEntity createTipoDeProducto(TipoDeProductoDTO tipoDeProductoDTO) {
        TipoDeProductoEntity tipoDeProducto = new TipoDeProductoEntity();
        tipoDeProducto.setKindOfProduct(tipoDeProductoDTO.getKindOfProduct());
        tipoDeProducto.setStatus(1);
        tipoDeProducto.setVersion("1.0");
        tipoDeProducto.setTransactionDate(new Date());
        tipoDeProducto.setTransactionUser("system");
        tipoDeProducto.setTransactionHost("localhost");
        return TipoDeProductoRepository.save(tipoDeProducto);
    }

    // Método para actualizar un tipo de producto existente
    public TipoDeProductoEntity updateTipoDeProducto(UUID id, TipoDeProductoDTO tipoDeProductoDTO) {
        if (TipoDeProductoRepository.existsById(id)) {
            TipoDeProductoEntity tipoDeProducto = new TipoDeProductoEntity();
            tipoDeProducto.setIdProductOfKind(id);
            tipoDeProducto.setKindOfProduct(tipoDeProductoDTO.getKindOfProduct());
            tipoDeProducto.setStatus(1);
            tipoDeProducto.setVersion("1.0");
            tipoDeProducto.setTransactionDate(new Date());
            tipoDeProducto.setTransactionUser("system");
            tipoDeProducto.setTransactionHost("localhost");

            return TipoDeProductoRepository.save(tipoDeProducto);
        }
        return null; // Puedes manejar esto de una manera más adecuada según tus necesidades.
    }

    // Método para eliminar un tipo de producto por ID
    public void deleteTipoDeProducto(UUID id) {
        TipoDeProductoRepository.deleteById(id);
    }

}
