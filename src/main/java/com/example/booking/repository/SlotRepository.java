package com.example.booking.repository;

import com.example.booking.entity.Client;
import com.example.booking.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Integer> {
    Slot findBySlotId(int id);
}
