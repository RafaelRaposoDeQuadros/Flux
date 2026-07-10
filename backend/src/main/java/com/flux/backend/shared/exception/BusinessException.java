package com.flux.backend.shared.exception;

public class BusinessException extends RuntimeException{

    public BusinessException(String menssage){
        super(menssage);
    }
}
