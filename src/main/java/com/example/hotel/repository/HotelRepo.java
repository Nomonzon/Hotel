package com.example.hotel.repository;

import com.example.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface HotelRepo extends JpaRepository<Hotel, Long> {

//    @Query(value = "select * from hotel limit :page offset :size*10;", nativeQuery = true)
//    List<Hotel> getHotel(@Param("page") Integer page,@Param("size") Integer size);

    @Query(value = "select count(*) from hotel", nativeQuery = true)
    Integer countOfHotels();


    boolean existsHotelByName(String name);


}
