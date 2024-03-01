package com.Leonardo.Unibank.unibank.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Long id){
        super("Id: " + id + " not found");
    }
}
