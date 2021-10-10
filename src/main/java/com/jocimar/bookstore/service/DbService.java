/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jocimar.bookstore.service;

import com.jocimar.bookstore.domain.Categoria;
import com.jocimar.bookstore.domain.Livro;
import com.jocimar.bookstore.repositories.CategoriaRepository;
import com.jocimar.bookstore.repositories.LivroRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author F5078775
 */
@Service
public class DbService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDados() {
        Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
        Categoria cat2 = new Categoria(null, "Ficcção Científica", "Ficção Científica");
        Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");

        Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Loren Ipsun", cat1);
        Livro l2 = new Livro(null, "Engenharia de software", "Louis V. Gerstner", "Loren Ipsun", cat1);
        Livro l3 = new Livro(null, "The Time Machine", "H. G. Wells", "Loren Ipsun", cat2);
        Livro l4 = new Livro(null, "The Wars of the Worlds", "H. G. Wells", "Loren Ipsun", cat2);
        Livro l5 = new Livro(null, "I,Robot ", "Isaac Asimov", "Loren Ipsun", cat2);

        cat1.getLivros().addAll(Arrays.asList(l1, l2));
        cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));

    }

}
