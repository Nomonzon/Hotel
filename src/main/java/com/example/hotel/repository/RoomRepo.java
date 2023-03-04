package com.example.hotel.repository;

import com.example.hotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomRepo extends JpaRepository<Room, Long> {


    @Query(value = "select count(*) from room", nativeQuery = true)
    Integer countOfRooms();

    boolean existsRoomByNumb(int numb);
}
