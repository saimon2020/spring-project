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
    public ClientDto createClient(@RequestBody ClientDto clientDto) {
        return clientService.createClient(clientDto);
    }

    @PutMapping
    public ClientDto updateClient(@RequestBody ClientDto clientDto) {
        return clientService.updateClient(clientDto);
    }

    @DeleteMapping
    public void deleteClient(@PathParam("id") Integer id) {
        clientService.deleteClient(id);
    }
}
