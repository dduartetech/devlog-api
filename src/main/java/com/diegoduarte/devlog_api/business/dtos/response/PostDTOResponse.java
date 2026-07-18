package com.diegoduarte.devlog_api.business.dtos.response;

import com.diegoduarte.devlog_api.infrastructure.entities.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTOResponse {

    private Long id;
    private String titulo;
    private String conteudo;
    private LocalDateTime dataCriacao;
    private UserEntity user;
}
