package com.bright.springboot.service;

/*
 * @Project Name: springboot-restful-webservices
 * @Author: Okechukwu Bright Onwumere
 * @Created: 03/04/2023
 */


import com.bright.springboot.dto.UserDto;
import com.bright.springboot.entity.User;

import java.util.List;


public interface UserService {

    UserDto createUser(UserDto userDto);

    User getUserById(Long userId);
    List<User> getAllUsers();
    User updateUser(User user, Long id);

    void deleteUser(Long userId);


}
