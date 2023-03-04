package com.example.hotel.controller;

import com.example.hotel.entity.Hotel;
import com.example.hotel.entity.Room;
import com.example.hotel.repository.HotelRepo;
import com.example.hotel.repository.RoomRepo;
import com.example.hotel.service.RoomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RestController
public class RoomController {


    @GetMapping("/addRoom")
    public String getAddHotelPage(Model model) {
        model.addAttribute("room", new Room());
        return "addRoom";
    }
    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private HotelRepo hotelRepo;

    @GetMapping("/room")
    public String getALlHotels(Model model, @RequestParam Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        Collection<String> collection = new ArrayList<>();
        model.addAttribute("rooms", roomRepo.findAll(pageable));
        model.addAttribute("count", roomRepo.countOfRooms() / 10 - 1);
        return "hotels";
    }

    @PostMapping("/addRoom")
    public String addHotel(@ModelAttribute Room room, Model model) {
        if (roomRepo.existsRoomByNumb(room.getNumb())) {
            model.addAttribute("message", "Bunday room alaqachon kiritilgan.");
            return "error";
        } else {
            roomRepo.save(room);
            return "redirect:room?page=0";
        }





//       public String add(@RequestBody RoomDto roomDto) {
////        Optional<hotel> address = hotelRepo.findById(facultyDto.gethotelId());
////        if (address.isPresent()) {
////            hotel hotel1 = address.get();
////            Room room= new Faculty(null, roomDto.getName(), hotel1);
////            RoomRepo.save(room);
    }
}
