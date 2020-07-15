package com.example.booking.repository;

import com.example.booking.entity.Booking;
import com.example.booking.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Booking findByBookingId(int id);
}
