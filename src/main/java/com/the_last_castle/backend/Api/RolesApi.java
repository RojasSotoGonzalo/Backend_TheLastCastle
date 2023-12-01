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

import com.the_last_castle.backend.DTO.RolesDTO;
import com.the_last_castle.backend.Entity.RolesEntity;
import com.the_last_castle.backend.Service.RolesService;

@RestController
@RequestMapping("/api/v1/rol")
public class RolesApi {
    @Autowired
    private RolesService rolesService;

    @GetMapping
    public ResponseEntity<List<RolesDTO>> getAllRoles() {
        List<RolesDTO> roles = rolesService.getAllRolesDTO();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolesDTO> getRolesById(@PathVariable UUID id) {
        Optional<RolesDTO> rolesDTO = rolesService.getRolesDTOById(id);
        return rolesDTO.map(roles -> new ResponseEntity<>(roles, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<RolesEntity> createRoles(@RequestBody RolesDTO rolesDTO) {
        RolesEntity roles = rolesService.createRoles(rolesDTO);
        return new ResponseEntity<>(roles, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolesEntity> updateRoles(@PathVariable UUID id, @RequestBody RolesDTO rolesDTO) {
        RolesEntity updatedRoles = rolesService.updateRoles(id, rolesDTO);
        return updatedRoles != null
                ? new ResponseEntity<>(updatedRoles, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoles(@PathVariable UUID id) {
        rolesService.deleteRoles(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
