package com.diegoduarte.devlog_api.business.mapper;

import com.diegoduarte.devlog_api.business.dtos.request.UserDTORequest;
import com.diegoduarte.devlog_api.business.dtos.response.UserDTOResponse;
import com.diegoduarte.devlog_api.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(UserDTORequest dto);
    UserDTOResponse toDTO(UserEntity entity);
}