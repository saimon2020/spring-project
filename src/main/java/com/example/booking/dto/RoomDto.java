package com.example.booking.dto;

import com.example.booking.entity.Slot;
import com.example.booking.enums.RoomType;

import java.util.ArrayList;
import java.util.List;

public class RoomDto {
    private int number;
    private RoomType type;
    private List<Slot> slots = new ArrayList<>();

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }
}