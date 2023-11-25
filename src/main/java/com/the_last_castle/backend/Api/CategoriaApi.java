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

import com.the_last_castle.backend.DTO.CategoriaDTO;
import com.the_last_castle.backend.Entity.CategoriaEntity;
import com.the_last_castle.backend.Service.CategoriaService;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaApi {
    @Autowired
    private CategoriaService categoriaService;

    public CategoriaApi(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<CategoriaDTO> getAllCategorias() {
        return categoriaService.getAllCategoriasDTO();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> getCategoriaById(@PathVariable UUID id) {
        Optional<CategoriaDTO> categoriaDTO = categoriaService.getCategoriaDTOById(id);
        return categoriaDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CategoriaEntity> createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        CategoriaEntity categoriaEntity = categoriaService.createCategoria(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaEntity> updateCategoria(@PathVariable UUID id,
            @RequestBody CategoriaDTO categoriaDTO) {
        CategoriaEntity categoriaEntity = categoriaService.updateCategoria(id, categoriaDTO);
        return categoriaEntity != null ? ResponseEntity.ok(categoriaEntity) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable UUID id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
