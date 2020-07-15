package com.example.booking.service;

import com.example.booking.dto.SlotDto;
import com.example.booking.entity.Slot;
import com.example.booking.exception.SlotException;
import com.example.booking.repository.ClientRepository;
import com.example.booking.repository.RoomRepository;
import com.example.booking.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SlotServiceImpl implements SlotService {

    private final SlotRepository slotRepository;
    private final ConversionService conversionService;
    private final RoomRepository roomRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public SlotServiceImpl(SlotRepository slotRepository, ConversionService conversionService, RoomRepository roomRepository, ClientRepository clientRepository) {
        this.slotRepository = slotRepository;
        this.conversionService = conversionService;
        this.roomRepository = roomRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public SlotDto getSlotById(int number) {
        Slot slot = slotRepository.findById(number).orElseThrow(() -> new SlotException("Slot is not found"));
        return conversionService.convert(slot, SlotDto.class);
    }

    @Override
    public List<SlotDto> getAll() {
        List<Slot> slots = slotRepository.findAll();
        return slots.stream().map(slot -> conversionService.convert(slot, SlotDto.class)).collect(Collectors.toList());
    }

    @Override
    public SlotDto createSlot(SlotDto slotDto) {
        Slot slot = conversionService.convert(slotDto, Slot.class);
        return conversionService.convert(slotRepository.save(slot), SlotDto.class);
    }

    @Override
    public SlotDto updateSlot(SlotDto slotDto) {
        Slot slot = slotRepository.findById(slotDto.getId()).orElseThrow(() -> new SlotException("Slot is not found"));
        slot.setSlotId(slotDto.getId());
        slot.setBooked(slotDto.isBooked());
        slot.setBookingDate(slotDto.getBookingDate());
        slot.setRoom(roomRepository.findByRoomNumber(slotDto.getRoomNumber()));
        slot.setClient(clientRepository.findByClientId(slotDto.getClientId()));
        return conversionService.convert(slotRepository.save(slot), SlotDto.class);
    }

    @Override
    public void deleteSlot(int number) {
        Slot slot = slotRepository.findById(number).orElseThrow(() -> new SlotException("Slot is not found"));
        slotRepository.delete(slot);
    }
}
