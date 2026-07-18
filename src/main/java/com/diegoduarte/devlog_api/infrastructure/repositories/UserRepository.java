package com.diegoduarte.devlog_api.infrastructure.repositories;

import com.diegoduarte.devlog_api.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
