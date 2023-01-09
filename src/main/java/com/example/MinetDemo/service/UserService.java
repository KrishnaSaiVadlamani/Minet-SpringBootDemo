package com.example.MinetDemo.service;

import com.example.MinetDemo.dto.UserDto;
import com.example.MinetDemo.entity.User;

import java.util.List;

public interface UserService {
    List<UserDto> findAllUsers();

    User findUserById(int theId);

    User saveUser(User theUser);

}
