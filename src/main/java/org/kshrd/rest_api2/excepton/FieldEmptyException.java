package org.kshrd.rest_api2.excepton;

public class FieldEmptyException extends RuntimeException{
    public FieldEmptyException(String message){
        super(message);
    }
}
