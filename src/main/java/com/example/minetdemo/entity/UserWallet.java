package com.example.minetdemo.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "user_wallet")
public class UserWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private int walletId;

    @Column(name = "amount")
    @Getter
    @Setter
    private double amount;

    @OneToOne(mappedBy = "userWallet",cascade = CascadeType.ALL)
    private Transaction transaction;


    public UserWallet(int walletId, double amount) {
        this.walletId = walletId;
        this.amount = amount;
    }

    public UserWallet() {
    }
}
