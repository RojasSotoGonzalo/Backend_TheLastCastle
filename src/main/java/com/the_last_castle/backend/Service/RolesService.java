package com.the_last_castle.backend.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.the_last_castle.backend.DTO.RolesDTO;
import com.the_last_castle.backend.Entity.RolesEntity;
import com.the_last_castle.backend.Repository.RolesRepository;

@Service
public class RolesService {
    @Autowired
    private final RolesRepository rolesRepository;

    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    // Método para obtener todos los Roles en formato DTO
    public List<RolesDTO> getAllRolesDTO() {
        List<RolesEntity> rolesEntities = rolesRepository.findAll();
        return convertirEntidadesADTO(rolesEntities);
    }

    // Método para obtener un Rol por ID en formato DTO
    public Optional<RolesDTO> getRolesDTOById(UUID id) {
        Optional<RolesEntity> rolesEntity = rolesRepository.findById(id);
        return rolesEntity.map(this::convertirEntidadADTO);
    }

    // Método para convertir una lista de entidades en DTO
    private List<RolesDTO> convertirEntidadesADTO(List<RolesEntity> entidades) {
        return entidades.stream()
                .map(this::convertirEntidadADTO)
                .collect(Collectors.toList());
    }

    // Método para convertir una entidad a DTO
    private RolesDTO convertirEntidadADTO(RolesEntity entidad) {
        return new RolesDTO(entidad.getIdRoles(), entidad.getRoles());
    }

    // Método para crear un nuevo rol
    public RolesEntity createRoles(RolesDTO rolesDTO) {
        RolesEntity roles = new RolesEntity();
        roles.setRoles(rolesDTO.getRoles());
        roles.setStatus(1);
        roles.setVersion("1.0");
        roles.setTransactionDate(new Date());
        roles.setTransactionUser("system");
        roles.setTransactionHost("localhost");
        return rolesRepository.save(roles);
    }

    // Método para editar un rol.
    public RolesEntity updateRoles(UUID id, RolesDTO rolesDTO) {
        if (rolesRepository.existsById(id)) {
            RolesEntity roles = new RolesEntity();
            roles.setIdRoles(id);
            roles.setRoles(rolesDTO.getRoles());
            roles.setStatus(1);
            roles.setVersion("1.0");
            roles.setTransactionDate(new Date());
            roles.setTransactionUser("system");
            roles.setTransactionHost("localhost");

            return rolesRepository.save(roles);
        }
        return null;
    }

    // Método para eliminar un rol por id
    public void deleteRoles(UUID id) {
        rolesRepository.deleteById(id);
    }
}
