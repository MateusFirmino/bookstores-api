package com.mateus.booktstore.services;

import com.mateus.booktstore.domain.Categoria;
import com.mateus.booktstore.domain.Livro;
import com.mateus.booktstore.repositories.CategoriaRepository;
import com.mateus.booktstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDeDados() {
        Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
        Categoria cat2 = new Categoria(null, "Ficação Cientifica", "Ficção cientifica");
        Categoria cat3 = new Categoria(null, "Saude & Bem Estar", "Saude em geral");
        Categoria cat4 = new Categoria(null, "Vazio", "Sem desc");

        Livro l1 = new Livro(null, "Carregando a turma", "Hondinha Brabo", "Loren ipsum", cat1);
        Livro l2 = new Livro(null, "Você cosnegue tudo", "João Otavio", "Lorem ipsum", cat3);
        Livro l3 = new Livro(null, "Vingadores : Ultimate", "Stan Lee", "Lorem ipsum", cat2);
        Livro l4 = new Livro(null, "Saude Mental", "Lorena Mattos", "Lorem ipsum", cat3);


        cat1.getLivros().addAll(Arrays.asList(l1)); //reconhecimento da categoria com os livros
        cat2.getLivros().addAll(Arrays.asList(l3));
        cat3.getLivros().addAll(Arrays.asList(l2, l4));

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3,cat4)); // salvando categorias
        this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4)); //salvando os livros
    }

}
