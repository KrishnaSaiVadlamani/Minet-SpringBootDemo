package com.example.minetdemo.dao;

import com.example.minetdemo.entity.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoRepository extends JpaRepository<Crypto,Integer> {
}
