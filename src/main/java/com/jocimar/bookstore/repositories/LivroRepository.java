/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocimar.bookstore.repositories;

import com.jocimar.bookstore.domain.Livro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author F5078775
 */
@Repository
public interface LivroRepository   extends JpaRepository<Livro, Integer>{
    @Query("SELECT livro from Livro  livro WHERE livro.categoria.id =:id_cat")
     List<Livro> findAllByCategoria(@Param(value = "id_cat")Integer id_cat);
    
}
