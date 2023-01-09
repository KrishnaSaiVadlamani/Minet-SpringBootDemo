package com.example.MinetDemo.dao;

import com.example.MinetDemo.entity.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoRepository extends JpaRepository<Crypto,Integer> {
}
