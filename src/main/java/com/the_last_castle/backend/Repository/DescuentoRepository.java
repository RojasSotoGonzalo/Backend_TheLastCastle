package com.the_last_castle.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.the_last_castle.backend.Entity.DescuentoEntity;

import java.util.UUID;

@Repository
public interface DescuentoRepository extends JpaRepository<DescuentoEntity, UUID> {

}
