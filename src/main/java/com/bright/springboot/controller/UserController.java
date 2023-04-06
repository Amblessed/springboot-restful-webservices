package com.bright.springboot.controller;

/*
 * @Project Name: springboot-restful-webservices
 * @Author: Okechukwu Bright Onwumere
 * @Created: 03/04/2023
 */


import com.bright.springboot.dto.UserDto;
import com.bright.springboot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
@Tag(
        name = "CRUD REST APIS for User Resource",
        description = "CRUD REST APIS - Create USer, Update User, Get User, Get All Users, Delete User"
)
public class UserController {

    private final UserService userService;

    //build create User REST API
    @PostMapping("/create")
    @Operation(
            summary = "Create User REST API",
            description = "Create User REST API is used to dave user in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"

    )
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto){
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //build get User REST API
    @GetMapping("/{id}")
    @Operation(
            summary = "Get User by ID REST API",
            description = "Get User by ID REST API is used to retrieve a single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"

    )
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    //build get All Users REST API
    @GetMapping("/all")
    @Operation(
            summary = "Get all Users REST API",
            description = "Get all Users REST API is used to retrieve all the users from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"

    )
    public ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    //build update user REST API
    @PutMapping("/{id}/update")
    @Operation(
            summary = "Update User REST API",
            description = "Update User REST API is used to update a particular user in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"

    )
    public ResponseEntity<UserDto> updateUser(@RequestBody @Valid UserDto userDto, @PathVariable("id") Long id){
        UserDto updatedUserDto = userService.updateUser(userDto, id);
        return ResponseEntity.ok(updatedUserDto);
    }

    //build update user REST API
    @DeleteMapping("/{id}/delete")
    @Operation(
            summary = "Delete User by ID REST API",
            description = "Delete User by ID REST API is used to delete a particular user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"

    )
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User successfully deleted!!!");
    }


    /*@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException notFoundException, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                notFoundException.getMessage(),
                webRequest.getDescription(false),
                "USER_NOT_FOUND"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }*/
}
