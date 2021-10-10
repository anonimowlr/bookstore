package com.jocimar.bookstore;

import com.jocimar.bookstore.domain.Categoria;
import com.jocimar.bookstore.domain.Livro;
import com.jocimar.bookstore.repositories.CategoriaRepository;
import com.jocimar.bookstore.repositories.LivroRepository;
import com.jocimar.bookstore.service.DbService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
    
    
    @Autowired
    private DbService dbService;
  

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        
        dbService.instanciaBaseDados();

           
        
    }

}
