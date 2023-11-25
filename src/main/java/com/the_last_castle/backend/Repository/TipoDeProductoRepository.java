package com.the_last_castle.backend.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.the_last_castle.backend.Entity.TipoDeProductoEntity;

@Repository
public interface TipoDeProductoRepository extends JpaRepository<TipoDeProductoEntity, UUID> {

}
