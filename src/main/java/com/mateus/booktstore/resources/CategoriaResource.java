package com.mateus.booktstore.resources;

import com.mateus.booktstore.domain.Categoria;
import com.mateus.booktstore.dtos.CategoriaDTO;
import com.mateus.booktstore.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

//End Points aqui
@CrossOrigin("*")
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

    @PostMapping
    public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> update(@Valid @PathVariable Integer id , @RequestBody CategoriaDTO objDto) {
        Categoria newObj = service.update(id, objDto);
        return ResponseEntity.ok().body(new CategoriaDTO(newObj)); // instanciou o categoria Dto e ja retornou na mesma linha
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
