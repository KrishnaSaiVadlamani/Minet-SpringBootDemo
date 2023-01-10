package com.example.minetdemo.controller;

import com.example.minetdemo.dao.WatchListRepository;
import com.example.minetdemo.entity.WatchList;
import com.example.minetdemo.service.WatchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class WatchListController {


    @Autowired
    private WatchListService watchListService;

    @Autowired
    private WatchListRepository watchListRepository;

    @GetMapping("/watchlist/{id}")
    public List<WatchList> showWatchListById(@PathVariable int id){
        return watchListRepository.getWatchListByUserId(id);
    }

    @PostMapping("/watchlist")
    public WatchList addWatchList(@RequestBody WatchList watchList){
        return watchListService.saveWatchList(watchList);
    }

    @PostMapping("/delete")
    public void deleteWatchListById(int id){
      watchListService.deleteById(id);
    }

}