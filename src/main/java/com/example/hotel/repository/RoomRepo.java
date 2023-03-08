package com.example.hotel.repository;

import com.example.hotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomRepo extends JpaRepository<Room, Long> {

    Integer countRoomByNumbAndHotel_Id(int numb, Long hotel_id);
    Integer countRoomBy();


}
