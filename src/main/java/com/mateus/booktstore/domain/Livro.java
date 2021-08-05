package com.mateus.booktstore.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class Livro implements Serializable {
    private static final long serialVersoinUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String nome_autor;
    private String texto;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Livro(){
        super();
    }

    public Livro(Integer id, String titulo, String nome_autor, String texto, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.nome_autor = nome_autor;
        this.texto = texto;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public Livro setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public Livro setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getNome_autor() {
        return nome_autor;
    }

    public Livro setNome_autor(String nome_autor) {
        this.nome_autor = nome_autor;
        return this;
    }

    public String getTexto() {
        return texto;
    }

    public Livro setTexto(String texto) {
        this.texto = texto;
        return this;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Livro setCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro)) return false;
        Livro livro = (Livro) o;
        return Objects.equals(getId(), livro.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
