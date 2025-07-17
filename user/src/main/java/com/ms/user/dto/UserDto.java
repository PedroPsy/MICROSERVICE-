package com.ms.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record UserDto(UUID userId, @NotBlank String name, @NotBlank @Email String email) {
}
