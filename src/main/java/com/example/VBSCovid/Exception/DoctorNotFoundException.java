package com.example.VBSCovid.Exception;

public class DoctorNotFoundException extends RuntimeException{

    public DoctorNotFoundException(String message){
        super(message);
    }
}
