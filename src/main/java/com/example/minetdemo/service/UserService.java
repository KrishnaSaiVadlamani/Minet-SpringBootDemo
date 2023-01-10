package com.example.minetdemo.service;

import com.example.minetdemo.dto.UserDto;
import com.example.minetdemo.entity.User;

import java.util.List;

public interface UserService {
    List<UserDto> findAllUsers();

    User findUserById(int theId);

    User saveUser(User theUser);

}
