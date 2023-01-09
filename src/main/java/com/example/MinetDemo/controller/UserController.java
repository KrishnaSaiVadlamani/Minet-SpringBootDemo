package com.example.MinetDemo.controller;

import com.example.MinetDemo.dto.UserDto;
import com.example.MinetDemo.entity.User;
import com.example.MinetDemo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;
    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userService.findAllUsers().stream().map(post -> modelMapper.map(post, UserDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user){
        try {
            userService.saveUser(user);
        }catch (Exception e){
            System.out.println("Exception Occured!!! adding user "+e);
        }
    }

    @GetMapping("/user/{theId}")
    public User showUser(@PathVariable int theId) {
        return userService.findUserById(theId);
    }
}
