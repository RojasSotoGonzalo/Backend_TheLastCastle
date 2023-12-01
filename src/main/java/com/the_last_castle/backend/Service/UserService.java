package com.the_last_castle.backend.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.the_last_castle.backend.DTO.PersonaDTO;
import com.the_last_castle.backend.DTO.RolesDTO;
import com.the_last_castle.backend.DTO.UserDTO;
import com.the_last_castle.backend.Entity.PersonaEntity;
import com.the_last_castle.backend.Entity.RolesEntity;
import com.the_last_castle.backend.Entity.UserEntity;
import com.the_last_castle.backend.Repository.PersonaRepository;
import com.the_last_castle.backend.Repository.RolesRepository;
import com.the_last_castle.backend.Repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public UserEntity createUser(UserDTO userDTO) {
        // Fetch entities from repositories based on UUIDs
        PersonaEntity personaEntity = personaRepository.findById(userDTO.getPersona().getId())
                .orElseThrow(() -> new EntityNotFoundException("Persona not found"));
        Set<RolesEntity> rolesEntities = fetchRolesEntities(userDTO.getRoles());
        // Codificar la contraseña antes de asignarla al nuevo usuario
        String encodedPassword = passwordEncoder.encode(userDTO.getPasswordUser());
        System.err.println(encodedPassword);
        UserEntity newUser = new UserEntity(
                personaEntity,
                rolesEntities,
                userDTO.getLoginUser(),
                encodedPassword,
                userDTO.getEmail());

        // Save the new user
        return userRepository.save(newUser);
    }

    private Set<RolesEntity> fetchRolesEntities(Set<RolesDTO> rolesDTOSet) {
        return rolesDTOSet.stream()
                .map(rolesDTO -> rolesRepository.findById(rolesDTO.getIdRoles())
                        .orElseThrow(() -> new EntityNotFoundException("Role not found")))
                .collect(Collectors.toSet());
    }

    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }

    public UserEntity updateUser(UUID userId, UserDTO updatedUserDTO) {
        UserEntity existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        PersonaEntity personaEntity = personaRepository.findById(updatedUserDTO.getPersona().getId())
                .orElseThrow(() -> new EntityNotFoundException("Persona not found"));
        Set<RolesEntity> updatedRoles = fetchRolesEntities(updatedUserDTO.getRoles());

        existingUser.setPersona(personaEntity);
        existingUser.setRoles(updatedRoles);
        existingUser.setLoginUser(updatedUserDTO.getLoginUser());
        existingUser.setPasswordUser(updatedUserDTO.getPasswordUser());
        existingUser.setEmail(updatedUserDTO.getEmail());

        return userRepository.save(existingUser);
    }

    public List<UserDTO> getAllUsersDTO() {
        List<UserEntity> userEntities = userRepository.findAll();
        return convertirUsersEntidadesADTO(userEntities);
    }

    public Optional<UserDTO> getUserDTOById(UUID id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity.map(this::convertirUserEntidadADTO);
    }

    private List<UserDTO> convertirUsersEntidadesADTO(List<UserEntity> entidades) {
        return entidades.stream()
                .map(this::convertirUserEntidadADTO)
                .collect(Collectors.toList());
    }

    private UserDTO convertirUserEntidadADTO(UserEntity entidad) {
        return new UserDTO(
                entidad.getIdUser(),
                convertirPersonaEntidadADTO(entidad.getPersona()),
                convertirRolesEntidadesADTO(entidad.getRoles()),
                entidad.getLoginUser(),
                entidad.getPasswordUser(),
                entidad.getEmail());
    }

    private PersonaDTO convertirPersonaEntidadADTO(PersonaEntity entidad) {
        return new PersonaDTO(entidad.getId(), entidad.getPeopleName(), entidad.getSurnames(), entidad.getCarnet(),
                entidad.getPhone(), entidad.getAddress()

        );
    }

    private Set<RolesDTO> convertirRolesEntidadesADTO(Set<RolesEntity> entidades) {
        return entidades.stream()
                .map(this::convertirRolesEntidadADTO)
                .collect(Collectors.toSet());
    }

    private RolesDTO convertirRolesEntidadADTO(RolesEntity entidad) {
        return new RolesDTO(entidad.getIdRoles(), entidad.getRoles());
    }

    public List<UserDTO> getUsersByName(String peopleName) {
        List<UserEntity> userEntities = userRepository.findByPersonaPeopleNameContainingIgnoreCase(peopleName);
        return convertirUsersEntidadesADTO(userEntities);
    }
}