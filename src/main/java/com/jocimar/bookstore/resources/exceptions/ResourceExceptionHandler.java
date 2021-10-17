/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocimar.bookstore.resources.exceptions;

import com.jocimar.bookstore.service.exceptions.DemaisExcepetions;
import com.jocimar.bookstore.service.exceptions.ViolacaoIntegridadeException;
import com.jocimar.bookstore.service.exceptions.ObjectNotFoundException;
import javax.servlet.ServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author F5078775
 */
@ControllerAdvice
public class ResourceExceptionHandler {
    
    
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objetoNaoEncontrado(ObjectNotFoundException e,ServletRequest request){
        StandardError standardError = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
   
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }
    
     @ExceptionHandler(ViolacaoIntegridadeException.class)
    public ResponseEntity<StandardError> integridadeViolada(ViolacaoIntegridadeException e,ServletRequest request){
        StandardError standardError = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
   
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }
    
    @ExceptionHandler(DemaisExcepetions.class)
    public ResponseEntity<StandardError> demaisExcecoes(DemaisExcepetions e,ServletRequest request){
        StandardError standardError = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
   
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }
    
     @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> erroValidacao(MethodArgumentNotValidException e,ServletRequest request){
        ValidationError erroValidacao = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro na validação dos campos:");
   
            for(FieldError x : e.getBindingResult().getFieldErrors()){
                
                erroValidacao.adicionaErro(x.getField(), x.getDefaultMessage());
                
            }
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroValidacao);
    }
    
    
    
    
}
