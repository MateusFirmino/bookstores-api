package com.mateus.booktstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
public class Livro implements Serializable {

    private static final long serialVersoinUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Campo TITULO é requerido")
    @Length(min = 3,max = 50,message = "O campo TITULO deve ter entre 3 e 50 carecteres")
    private String titulo;
    @NotEmpty(message = "Campo NOME DO AUTOR é requerido")
    @Length(min = 3,max = 50,message = "O campo NOME deve ter entre 3 e 50 carecteres")
    private String nome_autor;
    @NotEmpty(message = "Campo TEXTO é requerido")
    @Length(min = 10,max =2000000 ,message = "O campo NOME deve ter entre 2 e 2.000.000  carecteres")
    private String texto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Livro() {
        super();
    }

    public Livro(Integer id, String titulo, String nome_autor, String texto, Categoria categoria) {
        super();
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
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Livro other = (Livro) o;
        if (id == null){
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result +((id == null) ? 0 : id.hashCode());
        return result;
    }
}
