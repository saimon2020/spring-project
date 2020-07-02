package com.example.booking.service;

import com.example.booking.dto.ClientDto;
import com.example.booking.entity.Client;
import com.example.booking.exception.ClientException;
import com.example.booking.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ConversionService conversionService;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ConversionService conversionService) {
        this.clientRepository = clientRepository;
        this.conversionService = conversionService;
    }

    @Override
    public ClientDto getClientById(int number) {
        Client client = clientRepository.findById(number).orElseThrow(() -> new ClientException("Client is not found"));
        return conversionService.convert(client, ClientDto.class);
    }

    @Override
    public List<ClientDto> getAll() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(client -> conversionService.convert(client, ClientDto.class)).collect(Collectors.toList());
    }

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        Client client = conversionService.convert(clientDto, Client.class);
        return conversionService.convert(clientRepository.save(client), ClientDto.class);
    }

    @Override
    public ClientDto updateClient(ClientDto clientDto) {
        Client client = clientRepository.findById(clientDto.getId()).orElseThrow(() -> new ClientException("Client is not found"));
        client.setId(clientDto.getId());
        client.setName(clientDto.getName());
        client.setSurname(clientDto.getSurname());
        client.setBirthday(clientDto.getBirthday());
        client.setEmail(clientDto.getEmail());
        client.setMale(clientDto.isMale());
        return conversionService.convert(clientRepository.save(client), ClientDto.class);
    }

    @Override
    public void deleteClient(int number) {
        Client client = clientRepository.findById(number).orElseThrow(() -> new ClientException("Client is not found"));
        clientRepository.delete(client);
    }
}
