package com.bright.springboot.service.impl;

/*
 * @Project Name: springboot-restful-webservices
 * @Author: Okechukwu Bright Onwumere
 * @Created: 03/04/2023
 */


import com.bright.springboot.dto.UserDto;
import com.bright.springboot.entity.User;
import com.bright.springboot.mapper.UserMapper;
import com.bright.springboot.repository.UserRepository;
import com.bright.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        //Convert UserDto into User JPA Entity
        User user = UserMapper.mapToUser(userDto);

        User savedUser = userRepository.save(user);

        //Convert User JPA entity to UserDto
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.get();
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto).toList();
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        User existingUser = userRepository.findById(id).get();
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());
        User savedUser = userRepository.save(existingUser);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
