package com.Leonardo.Unibank.unibank.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="accounts")
public class Account {

    @Id
    private Long id;
    private Integer number;
    private Double balance = 0.0;

    @JsonIgnore
    @OneToOne
    @MapsId
    private Client client;

    public Account(){

    }

    public Account(Long id, Integer number, Double balance, Client client) {
        this.id = id;
        this.number = number;
        this.balance = balance;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void deposit(double amount){
        if (amount > 0.0){
            balance += amount;
        }
        else {
            throw new RuntimeException("amount required to deposit");
        }

    }

    public void withdraw(double amount){
        if (amount > 0.0 && amount <=balance ){
            balance -= amount;
        } else {
            throw new RuntimeException("Unable to withdraw");
        }

    }
    public void transfer(Account destinationcAccount, double amount) {
        if (amount > 0.0 && amount <= balance) {
            balance -= amount;
            destinationcAccount.deposit(amount);
        } else {
            throw new RuntimeException("Transfer was not possible");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
