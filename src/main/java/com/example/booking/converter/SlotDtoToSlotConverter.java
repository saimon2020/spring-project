package com.example.booking.converter;

import com.example.booking.dto.SlotDto;
import com.example.booking.entity.Slot;
import com.example.booking.repository.ClientRepository;
import com.example.booking.repository.RoomRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SlotDtoToSlotConverter implements Converter<SlotDto, Slot> {

    private final RoomRepository roomRepository;
    private final ClientRepository clientRepository;


    public SlotDtoToSlotConverter(RoomRepository roomRepository, ClientRepository clientRepository) {
        this.roomRepository = roomRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Slot convert(SlotDto slotDto) {
        Slot slot = new Slot();
        slot.setSlotId(slotDto.getId());
        slot.setRoom(roomRepository.findByRoomNumber(slotDto.getRoomNumber()));
        slot.setClient(clientRepository.findByClientId(slotDto.getClientId()));
        slot.setBookingDate(slotDto.getBookingDate());
        slot.setBooked(slotDto.isBooked());
        return slot;
    }

}
