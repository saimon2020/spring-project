package com.example.booking.converter;

import com.example.booking.dto.ClientDto;
import com.example.booking.entity.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientDtoToClientConverter implements Converter<ClientDto, Client> {
    @Override
    public Client convert(ClientDto clientDto) {
        Client client = new Client();
        client.setMale(clientDto.isMale());
        client.setEmail(clientDto.getEmail());
        client.setBirthday(clientDto.getBirthday());
        client.setName(clientDto.getName());
        client.setSurname(clientDto.getSurname());
        client.setId(clientDto.getId());
        client.setSlots(clientDto.getSlots());
        return client;
    }
}
