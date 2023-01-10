package com.example.minetdemo.dao;

import com.example.minetdemo.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    @Query(value = "select transaction from Transaction transaction where transaction.userId=:userId")
    public List<Transaction> getTransactionByUserId(@Param("userId") Integer userId);
}
