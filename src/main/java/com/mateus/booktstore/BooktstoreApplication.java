package com.mateus.booktstore;

import com.mateus.booktstore.domain.Categoria;
import com.mateus.booktstore.domain.Livro;
import com.mateus.booktstore.repositories.CategoriaRepository;
import com.mateus.booktstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BooktstoreApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;

    public static void main(String[] args) {

        SpringApplication.run(BooktstoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null,"Informatica","Livros de TI");

        Livro l1 = new Livro(null,"Carregando a turma","Hondinha Brabo","Loren ipsum",cat1);

        cat1.getLivros().addAll(Arrays.asList(l1));

        this.categoriaRepository.saveAll(Arrays.asList(cat1));
        this.livroRepository.saveAll(Arrays.asList(l1));
    }

}
