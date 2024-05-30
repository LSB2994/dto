package org.kshrd.rest_api2.excepton;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
