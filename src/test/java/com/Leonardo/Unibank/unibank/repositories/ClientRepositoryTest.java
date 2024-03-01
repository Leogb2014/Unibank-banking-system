package com.Leonardo.Unibank.unibank.repositories;


import com.Leonardo.Unibank.unibank.entities.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Temporal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;
import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
public class ClientRepositoryTest {

    @Autowired
    ClientRepository repository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Should get client successfully from Database")
    void findByIdCase1(){
        Client client = new Client(null, "Leo", "15428565478", Instant.parse("1998-10-06T18:20:00Z"));
        this.createClient(client);

        Optional<Client> result = this.repository.findById(client.getId());

        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should not get client from Database when client not exist")
    void findByIdCase2(){
        Client client = new Client(1L, "Leo", "15428565478", Instant.parse("1998-10-06T18:20:00Z"));

        Optional<Client> result = this.repository.findById(client.getId());

        assertThat(result.isEmpty()).isTrue();
    }

    private Client createClient(Client client){
        this.entityManager.persist(client);
        return client;
    }



}
