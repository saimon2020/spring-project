package com.example.booking.controller;

import com.example.booking.dto.RoomDto;
import com.example.booking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public RoomDto createRoom(@RequestBody RoomDto roomDto) {
        return roomService.createRoom(roomDto);
    }

    @PutMapping
    public RoomDto updateRoom(@RequestBody RoomDto roomDto) {
        return roomService.updateRoom(roomDto);
    }

    @DeleteMapping
    public void deleteRoom(@PathParam("number") Integer number) {
        roomService.deleteRoom(number);
    }
}
