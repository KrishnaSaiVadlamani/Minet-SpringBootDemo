package com.example.minetdemo.service;

import com.example.minetdemo.dao.UserPortFolioRepository;
import com.example.minetdemo.entity.UserPortFolio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPortFolioServiceTest {

    @Autowired
    private UserPortFolioService userPortFolioService;

    @MockBean
    private UserPortFolioRepository userPortFolioRepository;

    @Test
    public void testFindById(){
        UserPortFolio userPortFolio = new UserPortFolio(1);
        when(userPortFolioRepository.findById(1)).thenReturn(Optional.of(userPortFolio));
        assertEquals(userPortFolio,userPortFolioService.findPortFoliosByUserId(1));
    }

    @Test
    public void testSaveUserPortFolio() {
        UserPortFolio userPortFolio = new UserPortFolio(1);
        when(userPortFolioRepository.save(userPortFolio)).thenReturn(userPortFolio);
        UserPortFolio returnedUserPortFolio = userPortFolioService.saveUserPortFolio(userPortFolio);
        assertEquals(userPortFolio, returnedUserPortFolio);
    }

}
