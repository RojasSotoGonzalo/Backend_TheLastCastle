package com.the_last_castle.backend.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the_last_castle.backend.DTO.PersonaDTO;
import com.the_last_castle.backend.Entity.PersonaEntity;
import com.the_last_castle.backend.Repository.PersonaRepository;

@Service
public class PersonaService {
    @Autowired
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    // Método para obtener todas las Personas en formato DTO
    public List<PersonaDTO> getAllPersonasDTO() {
        List<PersonaEntity> personaEntities = personaRepository.findAll();
        return convertirEntidadesADTO(personaEntities);
    }

    // Método para obtener una Persona por ID en formato DTO
    public Optional<PersonaDTO> getPersonaDTOById(UUID id) {
        Optional<PersonaEntity> personaEntity = personaRepository.findById(id);
        return personaEntity.map(this::convertirEntidadADTO);
    }

    // Método para convertir una lista de entidades en DTO
    private List<PersonaDTO> convertirEntidadesADTO(List<PersonaEntity> entidades) {
        return entidades.stream()
                .map(this::convertirEntidadADTO)
                .collect(Collectors.toList());
    }

    // Método para convertir una entidad a DTO
    private PersonaDTO convertirEntidadADTO(PersonaEntity entidad) {
        return new PersonaDTO(entidad.getId(), entidad.getPeopleName(), entidad.getSurnames(),
                entidad.getCarnet(), entidad.getPhone(), entidad.getAddress());
    }

    // Método para crear una nueva persona
    public PersonaEntity createPersona(PersonaDTO personaDTO) {
        PersonaEntity persona = new PersonaEntity();
        persona.setPeopleName(personaDTO.getPeopleName());
        persona.setSurnames(personaDTO.getSurnames());
        persona.setCarnet(personaDTO.getCarnet());
        persona.setPhone(personaDTO.getPhone());
        persona.setAddress(personaDTO.getAddress());
        // Puedes establecer otros campos según tus necesidades
        return personaRepository.save(persona);
    }

    // Método para editar una persona.
    public PersonaEntity updatePersona(UUID id, PersonaDTO personaDTO) {
        if (personaRepository.existsById(id)) {
            PersonaEntity persona = new PersonaEntity();
            persona.setId(id);
            persona.setPeopleName(personaDTO.getPeopleName());
            persona.setSurnames(personaDTO.getSurnames());
            persona.setCarnet(personaDTO.getCarnet());
            persona.setPhone(personaDTO.getPhone());
            persona.setAddress(personaDTO.getAddress());
            // Puedes establecer otros campos según tus necesidades
            return personaRepository.save(persona);
        }
        return null;
    }

    // Método para eliminar una persona por id
    public void deletePersona(UUID id) {
        personaRepository.deleteById(id);
    }

    public List<PersonaDTO> buscarPorNombre(String nombre) {
        List<PersonaEntity> personasEntities = personaRepository.findByPeopleNameContaining(nombre);
        return convertirEntidadesADTO(personasEntities);
    }
}
