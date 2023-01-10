package com.example.minetdemo.service;

import com.example.minetdemo.entity.WatchList;

import java.util.List;

public interface WatchListService {

    WatchList findById(int id);

    List<WatchList> getWatchListByUserId(int id);

    WatchList saveWatchList(WatchList watchList);

    void deleteById(int id);
}
