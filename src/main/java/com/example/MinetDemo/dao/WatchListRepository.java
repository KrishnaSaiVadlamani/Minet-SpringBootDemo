package com.example.MinetDemo.dao;

import com.example.MinetDemo.entity.WatchList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WatchListRepository extends JpaRepository<WatchList,Integer> {

    @Query(value = "select watchList from WatchList watchList where watchList.userId=:userId")
    public List<WatchList> getWatchListByUserId(@Param("userId") Integer userId);
}
