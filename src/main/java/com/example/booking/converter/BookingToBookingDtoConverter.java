package com.example.booking.converter;

import com.example.booking.dto.BookingDto;
import com.example.booking.entity.Booking;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookingToBookingDtoConverter implements Converter<Booking, BookingDto> {
    @Override
    public BookingDto convert(Booking booking) {
        BookingDto target = new BookingDto();
        target.setId(booking.getId());
        target.setPaid(booking.isPaid());
        target.setPrice(booking.getPrice());
        target.setSlot(booking.getSlot());
        return target;
    }
}
