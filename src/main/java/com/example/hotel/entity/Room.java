package com.example.hotel.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private int numb;

    @Column(nullable = false)
    private int floor;

    @Column(nullable = false)
    private int size;

    private boolean busy;

    @ManyToOne
    private Hotel hotel;
}
