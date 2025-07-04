package com.ms.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRecordDto(java.util.UUID userId, @NotBlank String name, @NotBlank @Email String email) {
}
