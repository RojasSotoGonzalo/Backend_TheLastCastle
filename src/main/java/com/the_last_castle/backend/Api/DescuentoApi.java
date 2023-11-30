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

import com.the_last_castle.backend.DTO.DescuentoDTO;
import com.the_last_castle.backend.Entity.DescuentoEntity;
import com.the_last_castle.backend.Service.DescuentoService;

@RestController
@RequestMapping("/api/v1/descuento")
public class DescuentoApi {
    @Autowired
    private DescuentoService descuentoService;

    @GetMapping
    public List<DescuentoDTO> getAllDescuentos() {
        return descuentoService.getAllCategoriasDTO();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DescuentoDTO> getDescuentoById(@PathVariable UUID id) {
        Optional<DescuentoDTO> descuentoDTO = descuentoService.getDescuentoDTOById(id);
        return descuentoDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DescuentoEntity> createDescuento(@RequestBody DescuentoDTO descuentoDTO) {
        DescuentoEntity descuentoEntity = descuentoService.createDescuento(descuentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(descuentoEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DescuentoEntity> updateDescuento(@PathVariable UUID id,
            @RequestBody DescuentoDTO descuentoDTO) {
        DescuentoEntity descuentoEntity = descuentoService.upDescuentoEntity(id, descuentoDTO);
        return descuentoEntity != null ? ResponseEntity.ok(descuentoEntity) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDescuento(@PathVariable UUID id) {
        descuentoService.deleteDescuento(id);
        return ResponseEntity.noContent().build();
    }

}
