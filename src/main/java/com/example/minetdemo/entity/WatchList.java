package com.example.minetdemo.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "watchlist")
public class WatchList {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int id;
    @Column(name = "user_id")
    @Getter
    @Setter
    private int userId;
    @Column(name = "crypto_id")
    @Getter
    @Setter
    private int cryptoId;

    @Column(name = "updated_at")
    @Getter
    @Setter
    private LocalDateTime updatedAt;

    public WatchList() {
    }

    public WatchList(int userId, int cryptoId, LocalDateTime updatedAt) {
        this.userId = userId;
        this.cryptoId = cryptoId;
        this.updatedAt = updatedAt;
    }
}
