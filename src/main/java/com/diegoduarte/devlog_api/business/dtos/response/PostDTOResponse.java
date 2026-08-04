package com.diegoduarte.devlog_api.business.dtos.response;

import com.diegoduarte.devlog_api.infrastructure.entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataCriacao;
    private String autorNome;
}
