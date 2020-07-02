package com.example.booking.converter;

import com.example.booking.dto.RoomDto;
import com.example.booking.entity.Room;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoomToRoomDtoConverter implements Converter<Room, RoomDto> {
    @Override
    public RoomDto convert(Room room) {
        RoomDto target = new RoomDto();
        target.setNumber(room.getNumber());
        target.setType(room.getType());
        target.setSlots(room.getSlots());
        return target;
    }
}
