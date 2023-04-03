package com.bright.springboot.service;

/*
 * @Project Name: springboot-restful-webservices
 * @Author: Okechukwu Bright Onwumere
 * @Created: 03/04/2023
 */


import com.bright.springboot.dto.UserDto;

import java.util.List;


public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto userDto, Long id);

    void deleteUser(Long userId);


}
