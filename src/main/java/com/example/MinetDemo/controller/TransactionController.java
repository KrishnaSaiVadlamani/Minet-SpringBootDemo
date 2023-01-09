package com.example.MinetDemo.controller;

import com.example.MinetDemo.dao.TransactionRepository;
import com.example.MinetDemo.dto.TransactionDto;
import com.example.MinetDemo.entity.Transaction;
import com.example.MinetDemo.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/transactions")
    public List<TransactionDto> transactionList(){
        return transactionService.findAllTransactions().stream().map(post -> modelMapper.map(post, TransactionDto.class)).collect(Collectors.toList());
    }

    @PostMapping("/transaction")
    public void addTransaction(@RequestBody Transaction transaction){
        try {
            transactionService.saveTransactions(transaction);
        }catch (Exception e){
            System.out.println("Exception Occured!!! adding transaction "+e);
        }
    }

    @GetMapping("/transaction/{id}")
    public List<Transaction> showTransactionById(@PathVariable int id) {
        return transactionRepository.getTransactionByUserId(id);
    }
}
