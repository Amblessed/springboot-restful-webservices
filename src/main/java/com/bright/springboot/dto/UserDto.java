package com.bright.springboot.dto;

/*
 * @Project Name: springboot-restful-webservices
 * @Author: Okechukwu Bright Onwumere
 * @Created: 03/04/2023
 */


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Schema(
        description = "UserDto Model Information"
)
public class UserDto {

    private Long id;

    @NotEmpty(message = "First name cannot be empty")
    @Schema(description = "User first name")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    @Schema(description = "User last name")
    private String lastName;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email address needs to be valid")
    @Schema(description = "User email address")
    private String email;
}
