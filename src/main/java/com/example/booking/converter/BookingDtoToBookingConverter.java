package com.example.booking.converter;

import com.example.booking.dto.BookingDto;
import com.example.booking.entity.Booking;
import com.example.booking.repository.SlotRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookingDtoToBookingConverter implements Converter<BookingDto, Booking> {

    private final SlotRepository slotRepository;

    public BookingDtoToBookingConverter(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    @Override
    public Booking convert(BookingDto bookingDto) {
        Booking booking = new Booking();
        booking.setBookingId(bookingDto.getId());
        booking.setPaid(bookingDto.isPaid());
        booking.setPrice(bookingDto.getPrice());
        booking.setSlot(slotRepository.findBySlotId(bookingDto.getSlotId()));

        return booking;
    }
}
