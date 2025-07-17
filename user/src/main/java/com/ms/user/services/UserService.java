package com.ms.user.services;

import com.ms.user.models.UserModel;
import com.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserService {

    final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public UserModel save(@RequestBody @Valid UserModel userModel) {
        return userRepository.save(userModel);
    }

    public List<UserModel> findAll() {
        return userRepository.findAll()
                .stream()
                .filter(userModel -> !userModel.isDeleted())
                .collect(Collectors.toList());
    }
    public Optional<UserModel> findById(UUID id) {
        return userRepository.findById(id);
    }
    @Transactional
    public void delete(UserModel userModel) {
        userRepository.delete(userModel);
    }


}
