package com.ms.user.controllers;

import com.ms.user.dto.UserRecordDto;
import com.ms.user.dto.UserResponseDTO;
import com.ms.user.exception.UserNotFoundException;
import com.ms.user.mappers.UserMapper;
import com.ms.user.models.UserModel;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> saveUser(@RequestBody @Valid UserRecordDto userRecordDto) {
        var userModel = UserMapper.toModel(userRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toDto(userService.save(userModel)));

    }
    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {
        List<UserModel> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(
            @PathVariable UUID id,
            @RequestBody @Valid UserRecordDto userRecordDto) {

        userService.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuário com ID " + id + " não encontrado."));

        var userModel = UserMapper.toModel(id, userRecordDto);
        var updatedUser = userService.save(userModel);

        return ResponseEntity.ok(UserMapper.toDto(updatedUser));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        var user = userService.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuário com ID " + id + " não encontrado."));
        userService.delete(user);
        return ResponseEntity.noContent().build();
    }
}
