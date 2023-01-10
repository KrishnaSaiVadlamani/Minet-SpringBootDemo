package com.example.minetdemo.controller;

import com.example.minetdemo.dao.TransactionRepository;
import com.example.minetdemo.dto.TransactionDto;
import com.example.minetdemo.entity.Transaction;
import com.example.minetdemo.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/")
public class TransactionController {

    Logger logger
            = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/transactions")
    public List<TransactionDto> transactionList(){
        return transactionService.findAllTransactions().stream().map(post -> modelMapper.map(post, TransactionDto.class)).toList();
    }

    @PostMapping("/transaction")
    public void addTransaction(@RequestBody Transaction transaction){
        try {
            transactionService.saveTransactions(transaction);
        }catch (Exception e){
            logger.error("Exception Occured!!! adding transaction ");
        }
    }

    @GetMapping("/transaction/{id}")
    public List<Transaction> showTransactionById(@PathVariable int id) {
        return transactionRepository.getTransactionByUserId(id);
    }
}
