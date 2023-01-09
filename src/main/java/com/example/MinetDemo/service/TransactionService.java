package com.example.MinetDemo.service;

import com.example.MinetDemo.dto.TransactionDto;
import com.example.MinetDemo.entity.Transaction;

import java.util.List;

public interface TransactionService {

    List<TransactionDto> findAllTransactions();

    Transaction findTransactionsById(int theId);

    Transaction saveTransactions(Transaction transactions);

}
