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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.the_last_castle.backend.DTO.PersonaDTO;
import com.the_last_castle.backend.Entity.PersonaEntity;
import com.the_last_castle.backend.Service.PersonaService;

@RestController
@RequestMapping("/api/v1/persona")
public class PersonaApi {
    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<PersonaDTO>> getAllPersonas() {
        List<PersonaDTO> personas = personaService.getAllPersonasDTO();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> getPersonaById(@PathVariable UUID id) {
        Optional<PersonaDTO> personaDTO = personaService.getPersonaDTOById(id);
        return personaDTO.map(persona -> new ResponseEntity<>(persona, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<PersonaDTO>> buscarPorNombre(@RequestParam String nombre) {
        List<PersonaDTO> personas = personaService.buscarPorNombre(nombre);
        if (!personas.isEmpty()) {
            return new ResponseEntity<>(personas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<PersonaEntity> createPersona(@RequestBody PersonaDTO personaDTO) {
        PersonaEntity persona = personaService.createPersona(personaDTO);
        return new ResponseEntity<>(persona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaEntity> updatePersona(@PathVariable UUID id, @RequestBody PersonaDTO personaDTO) {
        PersonaEntity updatedPersona = personaService.updatePersona(id, personaDTO);
        return updatedPersona != null
                ? new ResponseEntity<>(updatedPersona, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable UUID id) {
        personaService.deletePersona(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
