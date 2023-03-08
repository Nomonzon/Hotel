package com.example.hotel.controller;


import com.example.hotel.entity.Hotel;
import com.example.hotel.repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;


@Controller
public class HotelController {


    @GetMapping("/addHotel")
    public String getAddHotelPage(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "addHotel";
    }
    @Autowired
    private HotelRepo hotelRepo;


    @GetMapping("/hotel")
    public String getALlHotels(Model model, @RequestParam Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        Collection<String> collection = new ArrayList<>();
        model.addAttribute("hotels", hotelRepo.findAll(pageable));
        model.addAttribute("count", hotelRepo.countOfHotels() / 10);
        return "hotels";
    }

    @PostMapping("/addHotel")
    public String addHotel(@ModelAttribute Hotel hotel, Model model) {
        if (hotelRepo.existsHotelByName(hotel.getName())) {
            model.addAttribute("message", "Bunday hotel alaqachon kiritilgan.");
            return "error";
        } else {
            hotelRepo.save(hotel);
            return "redirect:hotel?page=0";
        }

    }
}
