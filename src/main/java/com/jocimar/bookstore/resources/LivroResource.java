/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocimar.bookstore.resources;

import com.jocimar.bookstore.domain.Livro;
import com.jocimar.bookstore.dtos.LivroDto;
import com.jocimar.bookstore.service.LivroService;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author F5078775
 */
@RestController
@RequestMapping(value="/livros") // o "value" é opcional
public class LivroResource {
    
    
    @Autowired
    private LivroService livroService;
    
    
    @GetMapping(value="/{id}")
    public ResponseEntity<Livro> buscarLivro(@PathVariable Integer id){
        
        Livro livro = livroService.buscarLivro(id);
        
        return ResponseEntity.ok().body(livro);
        
    }
    
    @GetMapping
    public ResponseEntity<List<LivroDto>> buscarTodosivros(@RequestParam(value="categoria", defaultValue = "0") Integer id_cat){
        
        List<Livro> livros = livroService.buscarTodos(id_cat);
        List<LivroDto> livrosDto = livros.stream().map(livro->new LivroDto(livro)).collect(Collectors.toList());
        
        return ResponseEntity.ok().body(livrosDto);
        
    }
    
}
