package com.example.MinetDemo.service;

import com.example.MinetDemo.entity.WatchList;

import java.util.List;

public interface WatchListService {

    WatchList findById(int id);

    List<WatchList> getWatchListByUserId(int id);

    WatchList saveWatchList(WatchList watchList);

    void deleteById(int id);
}
