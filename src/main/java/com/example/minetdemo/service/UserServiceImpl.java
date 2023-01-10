package com.example.minetdemo.service;

import com.example.minetdemo.dao.UserRepository;
import com.example.minetdemo.dto.UserDto;
import com.example.minetdemo.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream().map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public User findUserById(int theId) {
        Optional<User> result = userRepository.findById(theId);

        User theUser = null;

        if (result.isPresent()) {
            theUser = result.get();
        }else{
            throw new RuntimeException();
        }

        return theUser;
    }


    @Override
    public User saveUser(User theUser) {
       return userRepository.save(theUser);
    }

    public UserDto convertEntityToDTO(User user){
        return mapper.map(user,UserDto.class);
    }

}
