package com.Leonardo.Unibank.unibank.dtos;

import com.Leonardo.Unibank.unibank.entities.Client;

import java.time.Instant;
import java.util.Objects;

public class ClientDTO {

    private Long id;
    private String name;
    private Instant birthDate;

    public ClientDTO(Client client){
        id = client.getId();
        name = client.getName();
        birthDate = client.getBirthDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO clientDTO = (ClientDTO) o;
        return Objects.equals(id, clientDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
