package com.bright.springboot.mapper;

/*
 * @Project Name: springboot-restful-webservices
 * @Author: Okechukwu Bright Onwumere
 * @Created: 03/04/2023
 */


import com.bright.springboot.dto.UserDto;
import com.bright.springboot.entity.User;

public class UserMapper {


    /**
     * @param user Object to be converted into a UserDto Object
     * @return a UserDto Object
     */
    public static UserDto mapToUserDto(User user){
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
    }

    /**
     * @param userDto object to be converted into a User Object
     * @return a User Object
     */
    public static User mapToUser(UserDto userDto){
        return new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());
    }
}
