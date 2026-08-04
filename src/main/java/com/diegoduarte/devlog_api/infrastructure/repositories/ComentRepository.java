package com.diegoduarte.devlog_api.infrastructure.repositories;

import com.diegoduarte.devlog_api.infrastructure.entities.ComentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentRepository extends JpaRepository<ComentEntity, Long> {

    List<ComentEntity> findByPostId(Long postId);
}
