package com.diegoduarte.devlog_api.business.dtos.response;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTOResponse {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private boolean ativo;
}
