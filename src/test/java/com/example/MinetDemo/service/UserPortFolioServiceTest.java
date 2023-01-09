package com.example.MinetDemo.service;

import com.example.MinetDemo.dao.UserPortFolioRepository;
import com.example.MinetDemo.entity.UserPortFolio;
import com.example.MinetDemo.entity.WatchList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
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
    public void testSaveUser() {
        UserPortFolio userPortFolio = new UserPortFolio(1);
        when(userPortFolioRepository.save(userPortFolio)).thenReturn(userPortFolio);
        UserPortFolio returnedUserPortFolio = userPortFolioService.saveUserPortFolio(userPortFolio);
        assertEquals(userPortFolio, returnedUserPortFolio);
    }

}
