/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.todo_api2.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;

/**
 *
 * GlobalExceptionHandler se encarga de capturar y manejar excepciones lanzadas por el sistema.
 * Esta diseñado para centralizar el manejo de todas las excepciones en una sola clase.
 * 
 * Maneja excepciones del tipo:
 * 
 * ResourceNotFoundException.class 
 * Devuelve con código HTTP 404(NOT FOUND) con un mensaje descriptivo.
 * 
 * MethodArgumentNotValidException.class Devuelve un código HTTP 400 junto con un 
 * diccionario que mapea el mensaje de error cuando falla 
 * una jakarta validation. campo -> mensaje de error. 
 * 
 * IllegalArgumentException.class Devuelve con código HTTP 400 Y  captura las excepciones 
 * de las reglas del dominio.
 * 
 * handleTooManyRequest se encarga de devolver un código HTTP 429 que indica que el usuario 
 * ha alcanzado el limite de requests.
 * 
 * handleSqlViolation se encarga de devolver UN código HTTP 409 y de indicar que el usuario
 * esta intentado crear una tarjeta ya registrada en la base de datos.
 * 
 * @author Asus
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex){
        return new ResponseEntity<> (ex.getMessage(), HttpStatus.NOT_FOUND);
        
    }    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleError(MethodArgumentNotValidException ex){
        
        Map<String, String> errors = new HashMap<>();
        
        ex.getBindingResult().getAllErrors().forEach(error -> {
        String fieldName = ((FieldError)error).getField();
        String fieldError = error.getDefaultMessage();
        errors.put(fieldName, fieldError);
        
        });
        
        return new ResponseEntity<> (errors, HttpStatus.BAD_REQUEST);

    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegal(IllegalArgumentException ex){
        return new ResponseEntity<> (ex.getMessage(), HttpStatus.BAD_REQUEST);
    
    }
    
    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<String> handleTooManyRequest(WebClientResponseException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.TOO_MANY_REQUESTS);
    }
    
    
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> handleSqlViolation(SQLIntegrityConstraintViolationException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
                    }
}  

