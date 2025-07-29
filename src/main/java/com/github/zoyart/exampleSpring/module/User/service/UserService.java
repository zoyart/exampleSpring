package com.github.zoyart.exampleSpring.module.User.service;

import com.github.zoyart.exampleSpring.module.User.dto.UserPatchDTO;
import com.github.zoyart.exampleSpring.module.User.mapper.UserMapper;
import com.github.zoyart.exampleSpring.module.User.dto.UserCreateDTO;
import com.github.zoyart.exampleSpring.module.User.dto.UserShowDTO;
import com.github.zoyart.exampleSpring.module.User.dto.UserUpdateDTO;
import com.github.zoyart.exampleSpring.module.User.model.User;
import com.github.zoyart.exampleSpring.module.User.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserShowDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));

        return userMapper.toUserShowDTO(user);
    }

    public List<UserShowDTO> getAllUsers() {
        return userMapper.toUserShowDTOs(userRepository.findAll());
    }

    public void createUser(UserCreateDTO userCreateDTO) {
        User user = new User();
        userMapper.createUserFromDTO(userCreateDTO, user);

        userRepository.save(user);
    }

    public void updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));
        userMapper.updateUserFromDTO(userUpdateDTO, user);

        userRepository.save(user);
    }

    public void patchUser(Long id, UserPatchDTO userPatchDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));

        userMapper.patchUserFromDTO(userPatchDTO, user);
        userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
