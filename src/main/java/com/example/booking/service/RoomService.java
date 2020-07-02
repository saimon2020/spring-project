package com.example.booking.service;

import com.example.booking.dto.RoomDto;

import java.util.List;

public interface RoomService {
    RoomDto getRoomByNumber(int number);

    List<RoomDto> getAll();

    RoomDto createRoom(RoomDto roomDto);

    RoomDto updateRoom(RoomDto roomDto);

    void deleteRoom(int number);
}
