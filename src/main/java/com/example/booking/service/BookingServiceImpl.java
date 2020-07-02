package com.example.booking.service;

import com.example.booking.dto.BookingDto;
import com.example.booking.entity.Booking;
import com.example.booking.exception.BookingException;
import com.example.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final ConversionService conversionService;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, ConversionService conversionService) {
        this.bookingRepository = bookingRepository;
        this.conversionService = conversionService;
    }

    @Override
    public BookingDto getBookingById(int id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new BookingException("Booking is not found"));
        return conversionService.convert(booking, BookingDto.class);
    }

    @Override
    public List<BookingDto> getAll() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream().map(booking -> conversionService.convert(booking, BookingDto.class)).collect(Collectors.toList());
    }

    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        Booking booking = conversionService.convert(bookingDto, Booking.class);
        return conversionService.convert(bookingRepository.save(booking), BookingDto.class);
    }

    @Override
    public BookingDto updateBooking(BookingDto bookingDto) {
        Booking booking = bookingRepository.findById(bookingDto.getId()).orElseThrow(() -> new BookingException("Booking is not found"));
        booking.setId(bookingDto.getId());

        return conversionService.convert(bookingRepository.save(booking), BookingDto.class);
    }

    @Override
    public void deleteBooking(int id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new BookingException("Booking is not found"));
        bookingRepository.delete(booking);
    }
}
