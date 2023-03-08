package com.example.hotel.service;

import com.example.hotel.entity.Hotel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomDto {


    private Long id;
    private int numb;
    private int floor;
    private int size;
    private boolean busy;
    private Long hotelId;
}
