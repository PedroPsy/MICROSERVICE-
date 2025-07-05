package com.ms.user.mappers;

import com.ms.user.dto.UserRecordDto;
import com.ms.user.dto.UserResponseDTO;
import com.ms.user.models.UserModel;

import java.util.UUID;

public class UserMapper {

    public static UserModel toModel(UserRecordDto dto) {
        var model = new UserModel();
        model.setName(dto.name());
        model.setEmail(dto.email());
        return model;
    }

    public static UserModel toModel(UUID id, UserRecordDto dto) {
        var model = new UserModel();
        model.setUserId(id); // garante que o ID seja mantido
        model.setName(dto.name());
        model.setEmail(dto.email());
        return model;
    }

    public static UserResponseDTO toDto(UserModel model) {
        return new UserResponseDTO(model.getUserId(), model.getName(), model.getEmail());
    }
}

