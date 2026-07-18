package com.diegoduarte.devlog_api.infrastructure.repositories;

import com.diegoduarte.devlog_api.infrastructure.entities.ComentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentRepository extends JpaRepository<ComentEntity, Long> {
}
