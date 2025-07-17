package com.ms.user.mappers;

import com.ms.user.dto.UserDto;
import com.ms.user.models.UserModel;

import java.util.UUID;

public class UserMapper {

    public static UserModel toModel(UserDto dto) {
        var model = new UserModel();
        model.setName(dto.name());
        model.setEmail(dto.email());
        return model;
    }


    public static UserModel toModel(UUID id, UserDto dto) {
        var model = new UserModel();
        model.setUserId(id); // garante que o ID seja mantido
        model.setName(dto.name());
        model.setEmail(dto.email());
        return model;
    }

    public static UserDto toDto(UserModel model) {
        return new UserDto(model.getUserId(), model.getName(), model.getEmail());
    }
}

