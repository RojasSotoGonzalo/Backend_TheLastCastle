package com.the_last_castle.backend.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.the_last_castle.backend.Entity.PersonaEntity;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, UUID> {
    List<PersonaEntity> findByPeopleNameContaining(String nombre);
}
