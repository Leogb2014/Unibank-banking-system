package com.Leonardo.Unibank.unibank.services;

import com.Leonardo.Unibank.unibank.dtos.ClientDTO;
import com.Leonardo.Unibank.unibank.entities.Client;
import com.Leonardo.Unibank.unibank.repositories.ClientRepository;
import com.Leonardo.Unibank.unibank.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional
    public void RegisterClient(Client client){
        repository.save(client);
    }

    @Transactional(readOnly = true)
    public List<ClientDTO> findAll(){
        List<Client> list = repository.findAll();
        List<ClientDTO> listDto = list.stream().map(ClientDTO::new).collect(Collectors.toList());
        return listDto;
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        try{
            Client client = repository.findById(id).get();
            ClientDTO clientDto = new ClientDTO(client);
            return clientDto;

        }catch(NoSuchElementException e){
            throw new ResourceNotFoundException(id);
        }
    }

    @Transactional
    public void updateClient(Long id, Client newClient){
        try {
            Client client = repository.getReferenceById(id);
            updateData(client, newClient);
            repository.save(client);
        }catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateData(Client client, Client newClient) {
        client.setName(newClient.getName());
        client.setBirthDate(newClient.getBirthDate());
    }

    @Transactional
    public void deleteById(Long id){
        findById(id);
        repository.deleteById(id);
    }


}
