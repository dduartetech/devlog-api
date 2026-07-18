package com.diegoduarte.devlog_api.business.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTORequest {

    @NotBlank(message = "Titulo é obrigatório")
    private String titulo;

    @NotBlank(message = "Conteúdo é obrigatório")
    private String conteudo;

}
