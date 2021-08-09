package com.mateus.booktstore.services;

import com.mateus.booktstore.domain.Categoria;
import com.mateus.booktstore.dtos.CategoriaDTO;
import com.mateus.booktstore.repositories.CategoriaRepository;
import com.mateus.booktstore.services.exceptions.ObejctNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository repository;

    @Autowired
    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public Categoria findByid(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObejctNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria create(Categoria obj) {
        obj.setId(null); //Se passar id como param. e ele ja existir na base, vai sobrescrever , por isso é nulo.
        return repository.save(obj);

    }

    public Categoria update(Integer id, CategoriaDTO objDto) {
        Categoria obj = findByid(id);
        obj.setNome(objDto.getNome());
        obj.setDescricao(objDto.getDescrição());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findByid(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.mateus.booktstore.services.exceptions.DataIntegrityViolationException("Categoria não pode ser deletada!" +
                    " Possui livros associados");
        }
    }
}
