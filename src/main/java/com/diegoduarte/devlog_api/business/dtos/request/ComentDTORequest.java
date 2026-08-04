package com.diegoduarte.devlog_api.business.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComentDTORequest {

    @NotBlank(message = "Conteúdo é obrigatório")
    private String conteudo;

    @NotNull(message = "Post é obrigatório")
    private Long postId;
}
