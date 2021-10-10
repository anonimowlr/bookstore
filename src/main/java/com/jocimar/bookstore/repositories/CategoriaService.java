/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocimar.bookstore.repositories;

import com.jocimar.bookstore.domain.Categoria;
import org.springframework.stereotype.Service;

/**
 *
 * @author F5078775
 */
@Service
public class CategoriaService {
    
    CategoriaRepository categoriaRepository;
    
    public Categoria salvarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
        
    }
    
   
    
}
