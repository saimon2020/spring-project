package com.example.booking.converter;

import com.example.booking.dto.SlotDto;
import com.example.booking.entity.Slot;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SlotDtoToSlotConverter implements Converter<SlotDto, Slot> {
    @Override
    public Slot convert(SlotDto slotDto) {
        Slot slot = new Slot();
        slot.setId(slotDto.getId());
        slot.setRoom(slotDto.getRoom());
        slot.setClient(slotDto.getClient());
        slot.setBookingDate(slotDto.getBookingDate());
        slot.setBooked(slotDto.isBooked());
        return slot;
    }

}
