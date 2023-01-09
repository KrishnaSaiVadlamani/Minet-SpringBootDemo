package com.example.MinetDemo.service;

import com.example.MinetDemo.dao.TransactionRepository;
import com.example.MinetDemo.entity.Transaction;
import com.example.MinetDemo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;
    @MockBean
    private TransactionRepository transactionRepository;

    @Test
    public void getTransactions(){
        when(transactionRepository.findAll())
                .thenReturn(Stream.of(new Transaction())
                        .collect(Collectors.toList()));
    }

    @Test
    public void testFindById(){
        Transaction transaction=new Transaction("sold",3000,2000,2,LocalDateTime.now(),1,2);
        when(transactionRepository.findById(1)).thenReturn(Optional.of(transaction));
        assertEquals(transaction,transactionService.findTransactionsById(1));
    }

    @Test
    public void testSaveUser() {
        Transaction transaction=new Transaction("sold",3000,2000,2,LocalDateTime.now(),1,2);
        when(transactionRepository.save(transaction)).thenReturn(transaction);
        Transaction returnedTransaction = transactionService.saveTransactions(transaction);
        assertEquals(transaction, returnedTransaction);
    }

}
