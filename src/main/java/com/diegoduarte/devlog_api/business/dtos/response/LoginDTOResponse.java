package com.diegoduarte.devlog_api.business.dtos.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTOResponse {
    private String token;
}
