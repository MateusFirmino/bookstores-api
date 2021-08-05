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
public class BooktstoreApplication {

    public static void main(String[] args) {

        SpringApplication.run(BooktstoreApplication.class, args);
    }

}
