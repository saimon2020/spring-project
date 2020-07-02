package com.example.booking.service;

import com.example.booking.dto.BookingDto;

import java.util.List;

public interface BookingService {
    BookingDto getBookingById(int id);

    List<BookingDto> getAll();

    BookingDto createBooking(BookingDto bookingDto);

    BookingDto updateBooking(BookingDto bookingDto);

    void deleteBooking(int number);
}
