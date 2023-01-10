package com.example.minetdemo.service;

import com.example.minetdemo.dto.TransactionDto;
import com.example.minetdemo.entity.Transaction;

import java.util.List;

public interface TransactionService {

    List<TransactionDto> findAllTransactions();

    Transaction findTransactionsById(int theId);

    Transaction saveTransactions(Transaction transactions);

}
