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

import com.the_last_castle.backend.DTO.PromocionDTO;
import com.the_last_castle.backend.Entity.PromocionEntity;
import com.the_last_castle.backend.Service.PromocionService;

@RestController
@RequestMapping("/api/v1/promocion")
public class PromocionApi {
    @Autowired
    private PromocionService promocionService;

    @GetMapping
    public List<PromocionDTO> getAllPromociones() {
        return promocionService.getAllPromocionesDTO();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PromocionDTO> getPromocionById(@PathVariable UUID id) {
        Optional<PromocionDTO> promocionDTO = promocionService.getPromocionDTOById(id);
        return promocionDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PromocionEntity> createPromocion(@RequestBody PromocionDTO promocionDTO) {
        PromocionEntity promocionEntity = promocionService.createPromocion(promocionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(promocionEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PromocionEntity> updatePromocion(@PathVariable UUID id,
            @RequestBody PromocionDTO promocionDTO) {
        PromocionEntity promocionEntity = promocionService.updatePromocionEntity(id, promocionDTO);
        return promocionEntity != null ? ResponseEntity.ok(promocionEntity) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePromocion(@PathVariable UUID id) {
        promocionService.deletePromocion(id);
        return ResponseEntity.noContent().build();
    }
}
