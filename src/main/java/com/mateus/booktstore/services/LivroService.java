package com.mateus.booktstore.services;

import com.mateus.booktstore.domain.Livro;
import com.mateus.booktstore.repositories.LivroRepository;
import com.mateus.booktstore.services.exceptions.ObejctNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public Livro findById(Integer id){
        Optional<Livro> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObejctNotFoundException("Objeto não encontrado! Id: " + id + ", " +
                "Tipo: " + Livro.class.getName()));

    }
}
