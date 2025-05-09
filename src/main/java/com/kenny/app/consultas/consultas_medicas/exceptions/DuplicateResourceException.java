package com.kenny.app.consultas.consultas_medicas.exceptions;

public class DuplicateResourceException extends RuntimeException{

    public DuplicateResourceException(String message){
        super(message);
    }
}
