package com.example.booking.controller;

import com.example.booking.dto.SlotDto;
import com.example.booking.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/slots")
public class SlotController {
    private final SlotService slotService;

    @Autowired
    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @PostMapping
    public SlotDto createSlot(@RequestBody SlotDto slotDto) {
        return slotService.createSlot(slotDto);
    }

    @PutMapping
    public SlotDto updateSlot(@RequestBody SlotDto slotDto) {
        return slotService.updateSlot(slotDto);
    }

    @DeleteMapping
    public void deleteSlot(@PathParam("id") Integer id) {
        slotService.deleteSlot(id);
    }
}
