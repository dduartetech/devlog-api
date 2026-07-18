package com.diegoduarte.devlog_api.infrastructure.repositories;

import com.diegoduarte.devlog_api.infrastructure.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
