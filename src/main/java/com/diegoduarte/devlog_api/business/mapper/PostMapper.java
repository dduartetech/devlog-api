package com.diegoduarte.devlog_api.business.mapper;

import com.diegoduarte.devlog_api.business.dtos.request.PostDTORequest;
import com.diegoduarte.devlog_api.business.dtos.response.PostDTOResponse;
import com.diegoduarte.devlog_api.infrastructure.entities.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostEntity toEntity(PostDTORequest dto);

    @Mapping(source = "user.nome", target = "autorNome")
    PostDTOResponse toDTO(PostEntity entity);
}
