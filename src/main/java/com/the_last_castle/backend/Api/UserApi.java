package com.the_last_castle.backend.Api;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.the_last_castle.backend.DTO.PersonaDTO;
import com.the_last_castle.backend.DTO.RolesDTO;
import com.the_last_castle.backend.DTO.UserDTO;
import com.the_last_castle.backend.Entity.PersonaEntity;
import com.the_last_castle.backend.Entity.RolesEntity;
import com.the_last_castle.backend.Entity.UserEntity;
import com.the_last_castle.backend.Service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserApi {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserEntity newUserEntity = userService.createUser(userDTO);
        return new ResponseEntity<>(convertirUserEntidadADTO(newUserEntity), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable UUID userId) {
        Optional<UserDTO> userDTO = userService.getUserDTOById(userId);
        return userDTO.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> usersDTO = userService.getAllUsersDTO();
        return new ResponseEntity<>(usersDTO, HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable UUID userId, @RequestBody UserDTO updatedUserDTO) {
        UserEntity updatedUserEntity = userService.updateUser(userId, updatedUserDTO);
        return new ResponseEntity<>(convertirUserEntidadADTO(updatedUserEntity), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
        return new PersonaDTO(
                entidad.getId(),
                entidad.getPeopleName(),
                entidad.getSurnames(),
                entidad.getCarnet(),
                entidad.getPhone(),
                entidad.getAddress());
    }

    private Set<RolesDTO> convertirRolesEntidadesADTO(Set<RolesEntity> entidades) {
        return entidades.stream()
                .map(this::convertirRolesEntidadADTO)
                .collect(Collectors.toSet());
    }

    private RolesDTO convertirRolesEntidadADTO(RolesEntity entidad) {
        return new RolesDTO(entidad.getIdRoles(), entidad.getRoles());
    }
}
