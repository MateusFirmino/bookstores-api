package com.mateus.booktstore.resources;

import com.mateus.booktstore.domain.Categoria;
import com.mateus.booktstore.dtos.CategoriaDTO;
import com.mateus.booktstore.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

//End Points aqui
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    private final CategoriaService service;

    @Autowired
    public CategoriaResource(CategoriaService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findbyId(@PathVariable Integer id){
        Categoria obj = service.findByid(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        List<Categoria> list = service.findAll();
        List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}

//localhost:8080/categorias/1
