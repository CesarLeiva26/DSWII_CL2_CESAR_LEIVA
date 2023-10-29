package edu.pe.cibertec.DSWII_CL2_CESAR_LEIVA.Exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }
}