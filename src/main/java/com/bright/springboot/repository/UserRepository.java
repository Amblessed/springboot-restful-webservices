package com.bright.springboot.repository;

/*
 * @Project Name: springboot-restful-webservices
 * @Author: Okechukwu Bright Onwumere
 * @Created: 03/04/2023
 */


import com.bright.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
