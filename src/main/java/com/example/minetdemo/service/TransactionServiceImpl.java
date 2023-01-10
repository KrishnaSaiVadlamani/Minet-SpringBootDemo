package com.example.minetdemo.service;

import com.example.minetdemo.dao.TransactionRepository;
import com.example.minetdemo.dto.TransactionDto;
import com.example.minetdemo.entity.Transaction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public List<TransactionDto> findAllTransactions() {
        return transactionRepository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .toList();
    }

    @Override
    public Transaction findTransactionsById(int theId) {
        Optional<Transaction> result = transactionRepository.findById(theId);
        Transaction theTransaction = null;

        if(result.isPresent()){
            theTransaction=result.get();
        }else{
            throw new RuntimeException();
        }
        return theTransaction;
    }

    @Override
    public Transaction saveTransactions(Transaction transaction) {
       return transactionRepository.save(transaction);
    }

    public TransactionDto convertEntityToDTO(Transaction transaction){
        return mapper.map(transaction,TransactionDto.class);
    }
}
