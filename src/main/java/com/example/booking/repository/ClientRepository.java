package com.example.booking.repository;

import com.example.booking.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByEmail(String email);
    Client findByClientId(int id);
}
