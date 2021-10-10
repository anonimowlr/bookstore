/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocimar.bookstore.repositories;

import com.jocimar.bookstore.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author F5078775
 */
@Repository
public interface CategoriaRepository  extends  JpaRepository<Categoria, Integer>{
    
}
