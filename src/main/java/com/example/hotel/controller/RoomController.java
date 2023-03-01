package com.example.hotel.controller;

import com.example.hotel.repository.HotelRepo;
import com.example.hotel.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {


    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private RoomRepo roomRepo;


}
