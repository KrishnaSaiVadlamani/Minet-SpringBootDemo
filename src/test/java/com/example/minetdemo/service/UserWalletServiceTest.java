package com.example.minetdemo.service;

import com.example.minetdemo.dao.UserWalletRepository;
import com.example.minetdemo.entity.UserWallet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserWalletServiceTest {

    @Autowired
    private UserWalletService userWalletService;

    @MockBean
    private UserWalletRepository userWalletRepository;

    @Test
    public void getUserWallets(){
        when(userWalletRepository.findAll())
                .thenReturn(Stream.of(new UserWallet())
                        .toList());
    }

    @Test
    public void testFindById(){
        UserWallet userWallet = new UserWallet(1,2000);
        when(userWalletRepository.findById(1)).thenReturn(Optional.of(userWallet));
        assertEquals(userWallet,userWalletService.findById(1));
    }

    @Test
    public void testSaveUserWallet() {
        UserWallet userWallet = new UserWallet(1,2000);
        when(userWalletRepository.save(userWallet)).thenReturn(userWallet);
        UserWallet returnedUserWallet = userWalletService.savewallet(userWallet);
        assertEquals(userWallet, returnedUserWallet);
    }


}
