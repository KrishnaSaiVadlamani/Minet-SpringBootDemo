package com.example.MinetDemo.service;

import com.example.MinetDemo.dao.UserWalletRepository;
import com.example.MinetDemo.dto.UserDto;
import com.example.MinetDemo.dto.UserWalletDto;
import com.example.MinetDemo.entity.User;
import com.example.MinetDemo.entity.UserWallet;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserWalletServiceImpl implements UserWalletService{

    @Autowired
    private UserWalletRepository userWalletRepository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public UserWallet findById(int user_id) {
        Optional<UserWallet> result = userWalletRepository.findById(user_id);
        UserWallet userWallet = null;

        if(result.isPresent()){
            userWallet=result.get();
        }else{
            throw new RuntimeException();
        }
        return userWallet;
    }

    @Override
    public UserWallet savewallet(UserWallet userWallet) {
        return userWalletRepository.save(userWallet);
    }

    @Override
    public List<UserWalletDto> findAllWallets() {
        return userWalletRepository.findAll().stream().map(this::convertEntityToDTO)
                .collect(Collectors.toList());

    }

    public UserWalletDto convertEntityToDTO(UserWallet userWallet){
        return mapper.map(userWallet,UserWalletDto.class);
    }

}
