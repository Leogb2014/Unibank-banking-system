package com.Leonardo.Unibank.unibank.controllers;

import com.Leonardo.Unibank.unibank.dtos.ClientDTO;
import com.Leonardo.Unibank.unibank.entities.Client;
import com.Leonardo.Unibank.unibank.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping
    public ResponseEntity<Void> registerClient(@RequestBody Client client){
        service.RegisterClient(client);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll(){
       List<ClientDTO> list = service.findAll();
       return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
        ClientDTO client = service.findById(id);
        return ResponseEntity.ok().body(client);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Void> updateClient(@PathVariable Long id, @RequestBody Client client){
        service.updateClient(id, client);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
