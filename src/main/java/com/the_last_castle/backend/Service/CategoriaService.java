package com.the_last_castle.backend.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the_last_castle.backend.DTO.CategoriaDTO;
import com.the_last_castle.backend.Entity.CategoriaEntity;
import com.the_last_castle.backend.Repository.CategoriaRespository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRespository categoriaRepository;

    // Método para obtener todos los Categoria en formato DTO
    public List<CategoriaDTO> getAllCategoriasDTO() {
        List<CategoriaEntity> categoriaEntities = categoriaRepository.findAll();
        return convertirEntidadesADTO(categoriaEntities);
    }

    // Método para obtener un Categoria por ID en formato DTO
    public Optional<CategoriaDTO> getCategoriaDTOById(UUID id) {
        Optional<CategoriaEntity> categoriaEntity = categoriaRepository.findById(id);
        return categoriaEntity.map(this::convertirEntidadADTO);
    }

    // Método para convertir una lista de entidades a DTO
    private List<CategoriaDTO> convertirEntidadesADTO(List<CategoriaEntity> entidades) {
        return entidades.stream()
                .map(this::convertirEntidadADTO)
                .collect(Collectors.toList());
    }

    // Método para convertir una entidad a DTO
    private CategoriaDTO convertirEntidadADTO(CategoriaEntity entidad) {
        return new CategoriaDTO(entidad.getIdCategory(), entidad.getCategory());
    }

    // Método para crear un nuevo Categoria
    public CategoriaEntity createCategoria(CategoriaDTO categoriaDTO) {
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setCategory(categoriaDTO.getCategory());
        categoria.setStatus(1);
        categoria.setVersion("1.0");
        categoria.setTransactionDate(new Date());
        categoria.setTransactionUser("system");
        categoria.setTransactionHost("localhost");
        return categoriaRepository.save(categoria);
    }

    // Método para actualizar un categorias existente
    public CategoriaEntity updateCategoria(UUID id, CategoriaDTO categoriaDTO) {
        if (categoriaRepository.existsById(id)) {
            CategoriaEntity categoria = new CategoriaEntity();
            categoria.setIdCategory(id);
            categoria.setCategory(categoriaDTO.getCategory());
            categoria.setStatus(1);
            categoria.setVersion("1.0");
            categoria.setTransactionDate(new Date());
            categoria.setTransactionUser("system");
            categoria.setTransactionHost("localhost");

            return categoriaRepository.save(categoria);
        }
        return null;// Puedes manejar esto de una manera más adecuada según tus necesidades.
    }

    // Método para eliminar un Categoira por ID
    public void deleteCategoria(UUID id) {
        categoriaRepository.deleteById(id);
    }

}
