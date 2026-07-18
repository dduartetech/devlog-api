package com.diegoduarte.devlog_api.business.mapper;

import com.diegoduarte.devlog_api.business.dtos.request.ComentDTORequest;
import com.diegoduarte.devlog_api.business.dtos.response.ComentDTOResponse;
import com.diegoduarte.devlog_api.infrastructure.entities.ComentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ComentMapper {

    ComentEntity toEntity(ComentDTORequest dto);
    ComentDTOResponse toDTO(ComentEntity entity);
}
