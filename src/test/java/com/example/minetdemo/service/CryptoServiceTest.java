package com.example.minetdemo.service;

import com.example.minetdemo.dao.CryptoRepository;
import com.example.minetdemo.entity.Crypto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CryptoServiceTest {

    @Autowired
    private CryptoService cryptoService;
    @MockBean
    private CryptoRepository cryptoRepository;
    @Test
    public void getCryptos(){
        when(cryptoRepository.findAll())
                .thenReturn(Stream.of(new Crypto())
                .collect(Collectors.toList()));
        assertEquals(1, cryptoService.findAllCryptos().size());
    }

    @Test
    public void testFindById(){
        Crypto crypto=new Crypto(1,"Bitcoin",38000.42,12345668.8,14523684.9,153246843.5,2.1);
        when(cryptoRepository.findById(1)).thenReturn(Optional.of(crypto));
        assertEquals(crypto,cryptoService.findCryptoById(1));
    }

    @Test
    public void testSaveCrypto() {
        Crypto crypto = new Crypto(1,"Bit",1245355.1,1875364.2,124563.1,1452634.2,2.1);
        when(cryptoRepository.save(crypto)).thenReturn(crypto);
        Crypto returnedCrypto = cryptoService.saveCrypto(crypto);
        assertEquals(crypto, returnedCrypto);
    }

}
