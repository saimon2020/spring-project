package com.example.booking.converter;

import com.example.booking.dto.SlotDto;
import com.example.booking.entity.Slot;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SlotToSlotDtoConverter implements Converter<Slot, SlotDto> {
    @Override
    public SlotDto convert(Slot slot) {
        SlotDto target = new SlotDto();
        target.setId(slot.getId());
        target.setBooked(slot.isBooked());
        target.setBookingDate(slot.getBookingDate());
        target.setClient(slot.getClient());
        target.setRoom(slot.getRoom());
        return target;
    }

}
