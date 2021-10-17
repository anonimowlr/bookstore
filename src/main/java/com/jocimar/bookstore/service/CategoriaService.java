/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocimar.bookstore.service;

import com.jocimar.bookstore.domain.Categoria;
import com.jocimar.bookstore.dtos.CategoriaDto;
import com.jocimar.bookstore.repositories.CategoriaRepository;
import com.jocimar.bookstore.service.exceptions.DemaisExcepetions;
import com.jocimar.bookstore.service.exceptions.ObjectNotFoundException;
import com.jocimar.bookstore.service.exceptions.ViolacaoIntegridadeException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 *
 * @author F5078775
 */
@Service
public class CategoriaService {
    
    @Autowired
    private  CategoriaRepository categoriaRepository;
    
    public Categoria buscaCategoria(Integer id){
        
        Optional<Categoria> categoria =  categoriaRepository.findById(id);
        return categoria.orElseThrow(()-> new ObjectNotFoundException("Categoria não encontrada"));
        
    }
    
    
    public List<Categoria> buscarTodasCategorias(){
        
        return categoriaRepository.findAll();
        
        
    }
    
    public Categoria criarCategoria(Categoria categoria){
        categoria.setId(null);
        
             return categoriaRepository.save(categoria);
       
       
        
    }

    public Categoria atualizar(Integer id, CategoriaDto catDto) {
        Categoria categoria = buscaCategoria(id);
        
        categoria.setDescricao(catDto.getDescricao());
        categoria.setNome(catDto.getNome());
        return categoriaRepository.save(categoria);
    }

    public void deletarCategoria(Integer id) {
        Categoria categoria = buscaCategoria(id);
        try {
            
            categoriaRepository.delete(categoria);
        } catch (DataIntegrityViolationException e) {
            throw  new ViolacaoIntegridadeException("Violação de integridade. Categoria não pode ser deletado, possui livros associados!!");
        } 
        


    }
    
    
    
    
}
