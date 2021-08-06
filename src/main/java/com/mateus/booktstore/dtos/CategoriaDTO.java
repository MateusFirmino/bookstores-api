package com.mateus.booktstore.dtos;

import com.mateus.booktstore.domain.Categoria;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;
    private String descrição;

    public CategoriaDTO() {
        super();
    }

    public CategoriaDTO(Categoria obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descrição = obj.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }
}
