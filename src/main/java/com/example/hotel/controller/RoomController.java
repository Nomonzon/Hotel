package com.example.hotel.controller;

import com.example.hotel.entity.Hotel;
import com.example.hotel.entity.Room;
import com.example.hotel.repository.HotelRepo;
import com.example.hotel.repository.RoomRepo;
import com.example.hotel.service.RoomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@Controller
public class RoomController {

    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private HotelRepo hotelRepo;

    @GetMapping("/addRoom")
    public String getAddHotelPage(Model model) {
        model.addAttribute("room", new RoomDto());
        model.addAttribute("hotels", hotelRepo.findAll());
        return "addRoom";
    }

    @GetMapping("/rooms")
    public String getALlHotels(Model model,@RequestParam Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        model.addAttribute("rooms", roomRepo.findAll(pageable));
        model.addAttribute("count", roomRepo.countRoomBy() / 10);
        return "rooms";
    }

    @PostMapping("/addRoom")
    public String addHotel(@ModelAttribute RoomDto roomDto, Model model) {
        if (roomRepo.countRoomByNumbAndHotel_Id(roomDto.getNumb(), roomDto.getHotelId()) > 0) {
            model.addAttribute("message", "Bunday room alaqachon kiritilgan.");
            return "error";
        } else {
            Optional<Hotel> address = hotelRepo.findById(roomDto.getHotelId());
            if (address.isPresent()) {
                Hotel hotel1 = address.get();
                Room room = new Room(null, roomDto.getNumb(), roomDto.getFloor(), roomDto.getSize(), false, hotel1);
                roomRepo.save(room);
            }
            return "redirect:rooms?page=0";
        }
    }
}

