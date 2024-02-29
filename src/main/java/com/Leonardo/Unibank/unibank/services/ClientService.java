package com.Leonardo.Unibank.unibank.services;

import com.Leonardo.Unibank.unibank.dtos.ClientDTO;
import com.Leonardo.Unibank.unibank.entities.Client;
import com.Leonardo.Unibank.unibank.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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
        Client client = repository.findById(id).get();
        ClientDTO clientDto = new ClientDTO(client);
        return clientDto;
    }

    @Transactional
    public void updateClient(Long id, Client newClient){
        Client client = repository.getReferenceById(id);
        updateData(client, newClient);
        repository.save(client);
    }

    private void updateData(Client client, Client newClient) {
        client.setName(newClient.getName());
        client.setBirthDate(newClient.getBirthDate());
    }

    @Transactional
    public void deleteById(Long id){
        repository.deleteById(id);
    }


}
