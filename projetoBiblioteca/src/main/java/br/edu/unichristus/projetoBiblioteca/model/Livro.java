package br.edu.unichristus.projetoBiblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.text.spi.DateFormatProvider;

@Entity
public class Livro {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    // Atributos da entidade Livro
    private String id;
    private String titulo;
    private Double numEdicao;
    private DateFormatProvider dataPublicacao;
    private String idAutor;
    private String idEditora;
    private Integer paginas;
    private String idCategoria;
}
