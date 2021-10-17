/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocimar.bookstore.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author F5078775
 */


public class ValidationError  extends StandardError{

    
    private List<FieldMessage>  errosValidacao =  new  ArrayList<>();
    
    public ValidationError() {
        super();
    }

    public ValidationError(Long timestamp, Integer status, String messageError) {
        super(timestamp, status, messageError);
    }

    public List<FieldMessage> getErrosValidacao() {
        return errosValidacao;
    }

    public void adicionaErro(String fieldMessage, String erro) {
        this.errosValidacao.add(new FieldMessage(fieldMessage, erro));
    }
    
    
    
    
    
    
    
    
}
