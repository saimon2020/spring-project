package com.example.booking.converter;

import com.example.booking.dto.BookingDto;
import com.example.booking.entity.Booking;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookingDtoToBookingConverter implements Converter<BookingDto, Booking> {
    @Override
    public Booking convert(BookingDto bookingDto) {
        Booking booking = new Booking();
        booking.setId(bookingDto.getId());
        booking.setPaid(bookingDto.isPaid());
        booking.setPrice(bookingDto.getPrice());
        booking.setSlot(bookingDto.getSlot());

        return booking;
    }
}
