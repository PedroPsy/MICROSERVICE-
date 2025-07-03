package com.ms.user.mappers;

import com.ms.user.dto.UserRecordDto;
import com.ms.user.dto.UserResponseDTO;
import com.ms.user.models.UserModel;

public class UserMapper {
    public static UserModel toModel(UserRecordDto dto) {
        var model = new UserModel();
        model.setName(dto.name());
        model.setEmail(dto.email());
        return model;
    }

    public static UserResponseDTO toDto(UserModel model) {
        return new UserResponseDTO(model.getUserId(), model.getName(), model.getEmail());
    }
}
