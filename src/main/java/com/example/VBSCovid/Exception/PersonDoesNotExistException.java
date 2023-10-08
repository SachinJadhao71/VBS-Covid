package com.example.VBSCovid.Exception;

public class PersonDoesNotExistException extends RuntimeException{

    public PersonDoesNotExistException(String message){
        super(message);
    }
}
