package com.jocimar.bookstore;

import com.jocimar.bookstore.domain.Categoria;
import com.jocimar.bookstore.domain.Livro;
import com.jocimar.bookstore.repositories.CategoriaRepository;
import com.jocimar.bookstore.repositories.LivroRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
   
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

            Categoria cat1 =  new Categoria(null, "Informatica", "Livros de TI");
            
            Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Loren Ipsun", cat1);
            
            cat1.getLivros().addAll(Arrays.asList(l1));
            
            
            categoriaRepository.saveAll(Arrays.asList(cat1));
            livroRepository.saveAll(Arrays.asList(l1));
        
    }

}
