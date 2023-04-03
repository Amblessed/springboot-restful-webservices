package com.bright.springboot.controller;

/*
 * @Project Name: springboot-restful-webservices
 * @Author: Okechukwu Bright Onwumere
 * @Created: 03/04/2023
 */


import com.bright.springboot.dto.UserDto;
import com.bright.springboot.entity.User;
import com.bright.springboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    //build create User REST API
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //build get User REST API
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    //build get All Users REST API
    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    //build update user REST API
    @PutMapping("/{id}/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("id") Long id){
        UserDto updatedUserDto = userService.updateUser(userDto, id);
        return ResponseEntity.ok(updatedUserDto);
    }

    //build update user REST API
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User successfully deleted!!!");
    }
}
