package com.example.minetdemo.service;

import com.example.minetdemo.dao.WatchListRepository;
import com.example.minetdemo.entity.WatchList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WatchListServiceTest {

    @Autowired
    private WatchListService watchListService;

    @MockBean
    private WatchListRepository watchListRepository;

    @Test
    public void testFindById(){
        WatchList watchList = new WatchList(1,1, LocalDateTime.now());
        when(watchListRepository.findById(1)).thenReturn(Optional.of(watchList));
        assertEquals(watchList,watchListService.findById(1));
    }

    @Test
    public void testSaveWatchList() {
        WatchList watchList = new WatchList(1,1, LocalDateTime.now());
        when(watchListRepository.save(watchList)).thenReturn(watchList);
        WatchList returnedWatchList = watchListService.saveWatchList(watchList);
        assertEquals(watchList, returnedWatchList);
    }

    @Test
    public void testDeleteById(){
        watchListService.deleteById(1);
        verify(watchListRepository, times(1)).deleteById(1);
    }

}
