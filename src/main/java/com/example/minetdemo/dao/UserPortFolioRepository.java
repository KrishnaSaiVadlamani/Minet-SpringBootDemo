package com.example.minetdemo.dao;

import com.example.minetdemo.entity.UserPortFolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserPortFolioRepository extends JpaRepository<UserPortFolio,Integer> {
    @Query(value = "select userPortFolio from UserPortFolio userPortFolio where userPortFolio.userId=:userId")
    public List<UserPortFolio> getUserPortFolioByUserId(@Param("userId") Integer userId);
}
