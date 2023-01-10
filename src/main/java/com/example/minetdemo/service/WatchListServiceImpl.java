package com.example.minetdemo.service;

import com.example.minetdemo.dao.WatchListRepository;
import com.example.minetdemo.entity.WatchList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WatchListServiceImpl implements WatchListService {

    @Autowired
    private WatchListRepository watchListRepository;
    @Override
    public WatchList findById(int id) {
        Optional<WatchList> result = watchListRepository.findById(id);
        WatchList watchList = null;

        if(result.isPresent()){
            watchList=result.get();
        }else{
            throw new RuntimeException();
        }
        return watchList;
    }

    @Override
    public List<WatchList> getWatchListByUserId(int id) {
        return watchListRepository.getWatchListByUserId(id);
    }

    @Override
    public WatchList saveWatchList(WatchList watchList) {
        return watchListRepository.save(watchList);
    }

    @Override
    public void deleteById(int id) {
        watchListRepository.deleteById(id);
    }
}
