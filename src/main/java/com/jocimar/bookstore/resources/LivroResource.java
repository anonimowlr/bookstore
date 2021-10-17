/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocimar.bookstore.resources;

import com.jocimar.bookstore.domain.Livro;
import com.jocimar.bookstore.dtos.LivroDto;
import com.jocimar.bookstore.service.LivroService;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author F5078775
 */
@CrossOrigin("*")
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
    
    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizaLivro(@PathVariable Integer id,@Valid @RequestBody LivroDto livroDto){
        Livro livroAtualizado = livroService.atualizarLivro(id,livroDto);
        
        return ResponseEntity.ok().body(livroAtualizado);
        
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Livro> atualizaLivroParcial(@PathVariable Integer id,@Valid @RequestBody LivroDto livroDto){
        Livro livroAtualizado = livroService.atualizarLivro(id,livroDto);
        
        return ResponseEntity.ok().body(livroAtualizado);
        
    }
    
    
    @PostMapping
    public ResponseEntity<Livro> criarLivro(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat, @Valid @RequestBody Livro livro){
        
        livro = livroService.criarLivro(id_cat,livro);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(livro.getId()).toUri();
        
        return ResponseEntity.created(uri).build();
        
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Integer id){
        livroService.deletarLivro(id);
        
        return ResponseEntity.noContent().build();
    }
    
}
