package com.example.booking.controller;

import com.example.booking.dto.BookingDto;
import com.example.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public BookingDto createBooking(@RequestBody BookingDto bookingDto) {
        return bookingService.createBooking(bookingDto);
    }

    @PutMapping
    public BookingDto updateBooking(@RequestBody BookingDto bookingDto) {
        return bookingService.updateBooking(bookingDto);
    }

    @DeleteMapping
    public void deleteBooking(@PathParam("id") Integer id) {
        bookingService.deleteBooking(id);
    }
}
