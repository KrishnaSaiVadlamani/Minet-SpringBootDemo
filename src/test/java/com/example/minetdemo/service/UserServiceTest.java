package com.example.minetdemo.service;

import com.example.minetdemo.dao.UserRepository;
import com.example.minetdemo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void getUsers(){
        when(userRepository.findAll())
                .thenReturn(Stream.of(new User())
                        .collect(Collectors.toList()));
        assertEquals(1, userService.findAllUsers().size());

    }

    @Test
    public void testFindById(){
        User user=new User("krishna","kittu","kittu@gmail.com","1234",1);
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        assertEquals(user,userService.findUserById(1));
    }

    @Test
    public void testSaveUser() {
        User user=new User("krishna","kittu","kittu@gmail.com","1234",1);
        when(userRepository.save(user)).thenReturn(user);
        User returnedUser = userService.saveUser(user);
        assertEquals(user, returnedUser);
    }

}
