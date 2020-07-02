package com.example.booking.service;

import com.example.booking.dto.SlotDto;

import java.util.List;

public interface SlotService {
    SlotDto getSlotById(int id);

    List<SlotDto> getAll();

    SlotDto createSlot(SlotDto roomDto);

    SlotDto updateSlot(SlotDto roomDto);

    void deleteSlot(int number);
}
