package br.edu.unichristus.projetoBiblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.text.spi.DateFormatProvider;

@Entity
public class Autor {
    // Atributos da entidade Autor
    @Id
    @GeneratedValue (strategy  = GenerationType.IDENTITY)
    private String id;
    private String nomeCompleto;
    private DateFormatProvider dataNascimento;
    private String nacionalidade;
    private Integer qtdLivros;
}
