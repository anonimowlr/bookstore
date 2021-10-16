/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocimar.bookstore.dtos;

import com.jocimar.bookstore.domain.Livro;
import java.io.Serializable;

/**
 *
 * @author F5078775
 */
public class LivroDto implements Serializable {
    
    private Integer id;
    private String titulo;
    private String nomeAutor;
    private String texto;
    

    public LivroDto() {
        super();
    }

    public LivroDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.nomeAutor = livro.getNomeAutor();
        this.texto = livro.getTexto();
    }

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
    
    
}
