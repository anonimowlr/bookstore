/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocimar.bookstore.resources;

import com.jocimar.bookstore.domain.Categoria;
import com.jocimar.bookstore.dtos.CategoriaDto;
import com.jocimar.bookstore.service.CategoriaService;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author F5078775
 */
@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping(value="/{id}")
    public ResponseEntity<Categoria> buscaCategoria(@PathVariable Integer id){
        
       Categoria categoria = categoriaService.buscaCategoria(id);
       
       return ResponseEntity.ok().body(categoria);
    
        
    }
    
    @GetMapping
    public ResponseEntity<List<CategoriaDto>> buscarTodasCategorias(){
        List<Categoria> categorias = categoriaService.buscarTodasCategorias();
        List<CategoriaDto> categoriasDto = categorias.stream().map(categoria-> new CategoriaDto(categoria)).collect(Collectors.toList());
        return ResponseEntity.ok().body(categoriasDto);
         
    }
    
    
}
