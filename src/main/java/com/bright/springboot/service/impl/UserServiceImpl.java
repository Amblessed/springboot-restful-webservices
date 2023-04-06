package com.bright.springboot.service.impl;

/*
 * @Project Name: springboot-restful-webservices
 * @Author: Okechukwu Bright Onwumere
 * @Created: 03/04/2023
 */


import com.bright.springboot.dto.UserDto;
import com.bright.springboot.entity.User;
import com.bright.springboot.exception.EmailAlreadyExistsException;
import com.bright.springboot.exception.ResourceNotFoundException;
import com.bright.springboot.repository.UserRepository;
import com.bright.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {

        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Email Already Exists for User");
        }

        //Convert UserDto into User JPA Entity
        User user = modelMapper.map(userDto, User.class);

        User savedUser = userRepository.save(user);

        //Convert User JPA entity to UserDto
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).toList();
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        User existingUser =userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());
        User savedUser = userRepository.save(existingUser);
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public void deleteUser(Long userId) {
        User existingUser =userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        userRepository.delete(existingUser);
    }
}
