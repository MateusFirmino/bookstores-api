package com.mateus.booktstore.services;

import com.mateus.booktstore.domain.Categoria;
import com.mateus.booktstore.domain.Livro;
import com.mateus.booktstore.repositories.LivroRepository;
import com.mateus.booktstore.services.exceptions.ObejctNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id) {
        Optional<Livro> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObejctNotFoundException("Objeto não encontrado! Id: " + id + ", " +
                "Tipo: " + Livro.class.getName()));

    }

    public List<Livro> findAll(Integer id_cat) {
        categoriaService.findByid(id_cat);
        return repository.findAllByCategoria(id_cat);

    }

    public Livro update(Integer id, Livro obj) {
        Livro newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(Livro newObj, Livro obj) {
        newObj.setTitulo(obj.getTitulo());
        newObj.setNome_autor(obj.getNome_autor());
        newObj.setTexto(obj.getTexto());
    }

    public Livro create(Integer id_cat, Livro obj) {
        obj.setId(null);
        Categoria cat = categoriaService.findByid(id_cat);
        obj.setCategoria(cat);
        return repository.save(obj);
    }
}
