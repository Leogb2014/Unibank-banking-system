package com.Leonardo.Unibank.unibank.repositories;

import com.Leonardo.Unibank.unibank.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
