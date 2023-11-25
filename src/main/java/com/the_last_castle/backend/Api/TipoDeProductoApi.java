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

import com.the_last_castle.backend.DTO.TipoDeProductoDTO;
import com.the_last_castle.backend.Entity.TipoDeProductoEntity;
import com.the_last_castle.backend.Service.TipoDeProductoService;

@RestController
@RequestMapping("/api/v1/tipodeproducto")
public class TipoDeProductoApi {
    @Autowired
    private TipoDeProductoService tipoDeProductoService;

    public TipoDeProductoApi(TipoDeProductoService tipoDeProductoService) {
        this.tipoDeProductoService = tipoDeProductoService;
    }

    @GetMapping
    public ResponseEntity<List<TipoDeProductoDTO>> getAllTiposDeProductosDTO() {
        List<TipoDeProductoDTO> tiposDeProductosDTO = tipoDeProductoService.getAllTiposDeProductosDTO();
        return ResponseEntity.ok(tiposDeProductosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDeProductoDTO> getTipoDeProductoDTOById(@PathVariable UUID id) {
        Optional<TipoDeProductoDTO> tipoDeProductoDTO = tipoDeProductoService.getTipoDeProductoDTOById(id);
        return tipoDeProductoDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoDeProductoEntity> createTipoDeProducto(@RequestBody TipoDeProductoDTO tipoDeProductoDTO) {
        TipoDeProductoEntity tipoDeProducto = tipoDeProductoService.createTipoDeProducto(tipoDeProductoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoDeProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDeProductoEntity> updateTipoDeProducto(
            @PathVariable UUID id,
            @RequestBody TipoDeProductoDTO tipoDeProductoDTO) {
        TipoDeProductoEntity updatedTipoDeProducto = tipoDeProductoService.updateTipoDeProducto(id, tipoDeProductoDTO);
        if (updatedTipoDeProducto != null) {
            return ResponseEntity.ok(updatedTipoDeProducto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoDeProducto(@PathVariable UUID id) {
        tipoDeProductoService.deleteTipoDeProducto(id);
        return ResponseEntity.noContent().build();
    }
}
