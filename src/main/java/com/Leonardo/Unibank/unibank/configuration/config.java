package com.Leonardo.Unibank.unibank.configuration;

import com.Leonardo.Unibank.unibank.entities.Account;
import com.Leonardo.Unibank.unibank.entities.Client;
import com.Leonardo.Unibank.unibank.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class config implements CommandLineRunner {

    @Autowired
    private ClientRepository repository;

    @Override
    public void run(String... args) throws Exception {

        Client c1 = new Client(null, "Leonardo", "14687689520", Instant.parse("1998-10-06T18:20:00Z"));
        Client c2 = new Client(null, "Maria", "15887289521", Instant.parse("2000-04-03T06:15:00Z"));
        repository.saveAll(Arrays.asList(c1, c2));

        Account ac1 = new Account(null, 1406, 0.0, c1);
        Account ac2 = new Account(null, 2021, 0.0, c2);

        ac1.deposit(200.00);
        ac2.deposit(200.00);
        ac1.withdraw(50.00);
        ac1.transfer(ac2, 50.00);

        c1.setAccount(ac1);
        c2.setAccount(ac2);


        repository.saveAll(Arrays.asList(c1, c2));

    }
}
