package com.diegoduarte.devlog_api.infrastructure.repositories;

import com.diegoduarte.devlog_api.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail (String email);
}
