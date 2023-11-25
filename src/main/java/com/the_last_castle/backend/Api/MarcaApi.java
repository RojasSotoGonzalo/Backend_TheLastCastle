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

import com.the_last_castle.backend.DTO.MarcaDTO;
import com.the_last_castle.backend.Entity.MarcaEntity;
import com.the_last_castle.backend.Service.MarcaService;

@RestController
@RequestMapping("/api/v1/marca")
public class MarcaApi {
    @Autowired
    private MarcaService marcaService;

    public MarcaApi(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public ResponseEntity<List<MarcaDTO>> getAllMarcas() {
        List<MarcaDTO> marcas = marcaService.getAllMarcasDTO();
        return ResponseEntity.ok(marcas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaDTO> getMarcaById(@PathVariable UUID id) {
        Optional<MarcaDTO> marca = marcaService.getMarcaDTOById(id);
        return marca.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MarcaEntity> createMarca(@RequestBody MarcaDTO marcaDTO) {
        MarcaEntity nuevaMarca = marcaService.createMarca(marcaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMarca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaEntity> updateMarca(@PathVariable UUID id, @RequestBody MarcaDTO marcaDTO) {
        MarcaEntity marcaActualizada = marcaService.updateMarca(id, marcaDTO);
        return marcaActualizada != null
                ? ResponseEntity.ok(marcaActualizada)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarca(@PathVariable UUID id) {
        marcaService.deleteMarca(id);
        return ResponseEntity.noContent().build();
    }
}
