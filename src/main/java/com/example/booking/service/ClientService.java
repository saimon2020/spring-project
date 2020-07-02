package com.example.booking.service;

import com.example.booking.dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto getClientById(int id);

    List<ClientDto> getAll();

    ClientDto createClient(ClientDto clientDto);

    ClientDto updateClient(ClientDto clientDto);

    void deleteClient(int number);
}
