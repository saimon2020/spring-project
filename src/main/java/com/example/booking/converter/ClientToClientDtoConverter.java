package com.example.booking.converter;

import com.example.booking.dto.ClientDto;
import com.example.booking.entity.Client;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientToClientDtoConverter implements Converter<Client, ClientDto> {
    @Override
    public ClientDto convert(Client client) {
        ClientDto target = new ClientDto();
        target.setId(client.getId());
        target.setBirthday(client.getBirthday());
        target.setName(client.getName());
        target.setSurname(client.getSurname());
        target.setEmail(client.getEmail());
        target.setMale(client.isMale());
        target.setSlots(client.getSlots());
        return target;
    }
}
