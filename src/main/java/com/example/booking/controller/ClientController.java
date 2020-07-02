package com.example.booking.controller;

import com.example.booking.dto.ClientDto;
import com.example.booking.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ClientDto createRoom(@RequestBody ClientDto roomDto) {
        return clientService.createClient(roomDto);
    }

    @PutMapping
    public ClientDto updateRoom(@RequestBody ClientDto roomDto) {
        return clientService.updateClient(roomDto);
    }

    @DeleteMapping
    public void deleteRoom(@PathParam("id") Integer id) {
        clientService.deleteClient(id);
    }
}
