package com.example.MinetDemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;
    @Column(name = "first_name")
    @Getter
    @Setter
    private String firstName;

    @Column(name = "last_name")
    @Getter
    @Setter
    private String lastName;

    @Column(name = "email")
    @Getter
    @Setter
    private String email;
    @Column(name = "password")
    @Getter
    @Setter
    private String password;
    @Column(name = "user_wallet_id")
    @Getter
    @Setter
    private int walletId;

   @OneToOne(cascade = CascadeType.ALL)
   @PrimaryKeyJoinColumn(name = "user_id")
   @Getter @Setter
    private UserPortFolio userPortFolio;



    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @Getter
    @Setter
    private List<Transaction> transactionList;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @Getter
    @Setter
    private List<WatchList> watchListList;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, int walletId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.walletId = walletId;
    }
}
