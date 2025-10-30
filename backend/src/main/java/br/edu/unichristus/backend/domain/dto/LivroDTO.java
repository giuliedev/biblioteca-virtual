package br.edu.unichristus.backend.domain.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class LivroDTO {

    private Long id;
    private String titulo;
    private String autor;
    private Integer anoPublicacao;
    private String categoria;
    private LocalDate dataAdicionado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataAdicionado() {
        return dataAdicionado;
    }

    public void setDataAdicionado(LocalDate dataAdicionado) {
        this.dataAdicionado = dataAdicionado;
    }
}
{
}
