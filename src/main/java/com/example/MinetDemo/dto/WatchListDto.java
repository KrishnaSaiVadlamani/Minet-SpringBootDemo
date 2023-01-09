package com.example.MinetDemo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WatchListDto {

    private int id;
    private int userId;
    private int cryptoId;

    private LocalDateTime updatedAt;
}
