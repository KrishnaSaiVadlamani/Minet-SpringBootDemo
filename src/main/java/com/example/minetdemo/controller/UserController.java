package com.example.minetdemo.controller;

import com.example.minetdemo.dto.UserDto;
import com.example.minetdemo.entity.User;
import com.example.minetdemo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/")
public class UserController {

    Logger logger
            = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;
    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userService.findAllUsers().stream().map(post -> modelMapper.map(post, UserDto.class))
                .toList();
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user){
        try {
            userService.saveUser(user);
        }catch (Exception e){
            logger.error("Exception Occured!!! adding user ");
        }
    }

    @GetMapping("/user/{theId}")
    public User showUser(@PathVariable int theId) {
        return userService.findUserById(theId);
    }
}
