package com.the_last_castle.backend.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.the_last_castle.backend.Entity.Roles;

@Repository
public interface RepositoryRoles extends JpaRepository<Roles, UUID> {

}
